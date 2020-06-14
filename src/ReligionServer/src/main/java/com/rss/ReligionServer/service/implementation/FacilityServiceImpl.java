package com.rss.ReligionServer.service.implementation;

import com.rss.ReligionServer.dao.AddressDao;
import com.rss.ReligionServer.dao.FacilityDao;
import com.rss.ReligionServer.model.AddressModel;
import com.rss.ReligionServer.model.FacilityModel;
import com.rss.ReligionServer.model.mapping.AddressMapping;
import com.rss.ReligionServer.model.mapping.FacilityMapping;
import com.rss.ReligionServer.service.FacilityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {
    @Autowired
    FacilityDao facilityDao;

    @Autowired
    AddressDao addressDao;

    private Logger log = LoggerFactory.getLogger(FacilityServiceImpl.class);

    @Override
    public int registerFacility(FacilityModel facilityModel) {

        AddressModel addressModel = facilityModel.getAddress();
        AddressMapping addressMapping = new AddressMapping(
                addressModel.getId(), addressModel.getCity(), addressModel.getGu(),
                addressModel.getDong(), addressModel.getPostalCode(), addressModel.getApartment());

        int addressId = (int) addressDao.create(addressMapping);

        FacilityMapping facilityMapping = new FacilityMapping(
                facilityModel.getId(), facilityModel.getName(), facilityModel.getNumber(), facilityModel.getDescription(),
                facilityModel.getUrl(), facilityModel.getKind(), facilityModel.getRegUserId(), addressMapping.getId());

        int facilityId = (int) facilityDao.create(facilityMapping);

        return facilityId;
    }

    @Override
    public List<FacilityModel> findAll() {
        List<FacilityMapping> facilityMappings = facilityDao.retrieveAll();

        List<FacilityModel> facilityModels = new ArrayList<>();
        for(FacilityMapping mapping : facilityMappings) {
            AddressMapping addressMapping = addressDao.retrieveById(mapping.getAddressId());
            AddressModel addressModel = new AddressModel(addressMapping.getId(), addressMapping.getCity(),
                    addressMapping.getGu(), addressMapping.getDong(), addressMapping.getPostalCode(), addressMapping.getApartment());

            FacilityModel facilityModel = new FacilityModel(mapping.getId(), mapping.getName(), mapping.getNumber(), mapping.getDescription(),
                    mapping.getUrl(), mapping.getKind(), mapping.getRegUserId(), addressModel);

            facilityModels.add(facilityModel);
        }
        return facilityModels;
    }

    @Override
    public List<FacilityModel> findFacilityByKind(String kind) {
        List<FacilityModel> facilityModels = new ArrayList<>();
        try {
            List<FacilityMapping> mappings = facilityDao.retrieveByKind(kind);


            for(FacilityMapping mapping : mappings) {
                AddressMapping addressMapping = addressDao.retrieveById(mapping.getAddressId());
                AddressModel addressModel = new AddressModel(addressMapping.getId(), addressMapping.getCity(), addressMapping.getGu(),
                        addressMapping.getDong(), addressMapping.getPostalCode(), addressMapping.getApartment());

                FacilityModel model = new FacilityModel(mapping.getId(), mapping.getName(), mapping.getNumber(),
                        mapping.getDescription(), mapping.getUrl(), mapping.getKind(), mapping.getRegUserId(), addressModel);

                facilityModels.add(model);
            }
        } catch (Exception e) {
            log.error("error in service(findByKind)", e);
        }
        return facilityModels;
    }

    @Override
    public List<FacilityModel> findFacilityByPos(AddressModel addressModel) {
        try {
            int to = 0;
            if(addressModel.getCity() == null)
                throw new Exception();

            if(addressModel.getGu() == null) to = 0;
            else if(addressModel.getDong() == null) to = 1;
            else to = 2;
            AddressMapping mapping = new AddressMapping(addressModel.getId(), addressModel.getCity(), addressModel.getGu(), addressModel.getDong(), addressModel.getPostalCode(), addressModel.getApartment());

            List<FacilityMapping> facilityMappings = facilityDao.retrieveByPos(mapping, to);
            List<FacilityModel> facilityModels = new ArrayList<>();

            for(FacilityMapping facilityMapping : facilityMappings) {
                AddressMapping addressMapping = addressDao.retrieveById(facilityMapping.getAddressId());

                AddressModel model = new AddressModel(addressMapping.getId(), addressMapping.getCity(), addressMapping.getGu(), addressMapping.getDong(), addressMapping.getPostalCode(), addressMapping.getApartment());

                FacilityModel facilityModel = new FacilityModel(facilityMapping.getId(), facilityMapping.getName(), facilityMapping.getNumber(),
                        facilityMapping.getDescription(), facilityMapping.getUrl(), facilityMapping.getKind(), facilityMapping.getRegUserId(), model);
                facilityModels.add(facilityModel);

                return facilityModels;
            }
        } catch (Exception e) {
            log.error("error in service(findByPos)", e);
        }

        return null;
    }

    @Override
    public List<FacilityModel> findFacilityByName(String name) {
        List<FacilityModel> facilityModels = new ArrayList<>();
        try {
            List<FacilityMapping> mappings = facilityDao.retrieveByName(name);

            for(FacilityMapping mapping : mappings) {
                AddressMapping addressMapping = addressDao.retrieveById(mapping.getAddressId());
                AddressModel addressModel = new AddressModel(addressMapping.getId(), addressMapping.getCity(), addressMapping.getGu(),
                        addressMapping.getDong(), addressMapping.getPostalCode(), addressMapping.getApartment());

                FacilityModel facilityModel = new FacilityModel(mapping.getId(), mapping.getName(), mapping.getNumber(), mapping.getDescription(), mapping.getUrl(),
                        mapping.getKind(), mapping.getRegUserId(), addressModel);

                facilityModels.add(facilityModel);
            }
        } catch (Exception e) {
            log.error("error in service(findByName)", e);
        }
        return facilityModels;
    }

    @Override
    public int modifyFacility(FacilityModel facilityModel) {
        try {
            AddressModel addressModel = facilityModel.getAddress();
            AddressMapping addressMapping = new AddressMapping(addressModel.getId(), addressModel.getCity(), addressModel.getGu(),
                    addressModel.getDong(), addressModel.getPostalCode(), addressModel.getApartment());
            boolean result = addressDao.update(addressMapping) > 0;
            if (!result) throw new Exception("update address failed");

            FacilityMapping facilityMapping = new FacilityMapping(facilityModel.getId(), facilityModel.getName(), facilityModel.getNumber(), facilityModel.getDescription(),
                    facilityModel.getUrl(), facilityModel.getKind(), facilityModel.getRegUserId(), facilityModel.getAddress().getId());

            result = facilityDao.update(facilityMapping) > 0;

            return result ? 0 : 1;
        } catch (Exception e) {
            log.error("error in service(modify)", e);
        }

        return 1;
    }

    @Override
    public int deleteFacility(int id) {
        try {
            FacilityMapping facilityMapping = facilityDao.retrieveById(id);
            if(facilityMapping == null) throw new Exception("there is no data.");

            AddressMapping addressMapping = addressDao.retrieveById(facilityMapping.getAddressId());
            boolean result = addressDao.remove(addressMapping.getId()) > 0;
            if(!result) throw new Exception("delete address failed");

            result = facilityDao.remove(facilityMapping.getId()) > 0;

            return result ? 0 : 1;
        } catch (Exception e) {
            log.error("error in service(delete)", e);
        }
        return 1;
    }
}
