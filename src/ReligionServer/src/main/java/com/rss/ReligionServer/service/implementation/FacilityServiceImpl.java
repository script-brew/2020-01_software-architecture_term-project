package com.rss.ReligionServer.service.implementation;

import com.rss.ReligionServer.dao.AddressDao;
import com.rss.ReligionServer.dao.FacilityDao;
import com.rss.ReligionServer.model.AddressModel;
import com.rss.ReligionServer.model.FacilityModel;
import com.rss.ReligionServer.model.mapping.AddressMapping;
import com.rss.ReligionServer.model.mapping.FacilityMapping;
import com.rss.ReligionServer.service.FacilityService;
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
        try {
            List<FacilityMapping> mappings = facilityDao.retrieveByKind(kind);

            List<FacilityModel> facilityModels = new ArrayList<>();
            for(FacilityMapping mapping : mappings) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<FacilityModel> findFacilityByName(String name) {
        return null;
    }

    @Override
    public int modifyFacility(FacilityModel facilityModel) {
        return 0;
    }

    @Override
    public int deleteFacility(int id) {
        return 0;
    }
}
