package com.rss.service.implementation;

import com.rss.entity.Address;
import com.rss.entity.Facility;
import com.rss.reqeust.AddressModel;
import com.rss.reqeust.FacilityModel;
import com.rss.respond.RegisterResponse;
import com.rss.service.RegisterService;
import com.rss.util.retrofitUtil.APIUtils;
import com.rss.util.retrofitUtil.ReligionAPI;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegisterServiceImpl implements RegisterService {
    private ReligionAPI religionAPI;

    public RegisterServiceImpl() {
        religionAPI = APIUtils.getReligionAPI();
    }

    @Override
    public int registerFacility(Facility facility) {
        Address address = facility.getAddress();
        AddressModel addressModel = new AddressModel(address.getCity(), address.getGu(), address.getDong(),
                address.getZibun(), address.getPostalCode(), address.getApartment());
        FacilityModel model = new FacilityModel(facility.getId(), facility.getName(), facility.getNumber(), facility.getDescription(),
                facility.getUrl(), facility.getKind(), facility.getRegUserId(),addressModel);

        Call<RegisterResponse> call = religionAPI.registerFacility(model);
        try {
            Response<RegisterResponse> response = call.execute();
            int facilityId = response.body().getId();

            return facilityId;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Facility> findFacByRegUser(int userId) {
        List<Facility> result = new ArrayList<>();
        Call<List<FacilityModel>> call = religionAPI.requestFacilityByUserId(userId);
        try {
            Response<List<FacilityModel>> response = call.execute();
            for(FacilityModel model : response.body()) {
                result.add(model.toFacility());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int modifyFac(Facility facility) {
        Address address = facility.getAddress();
        AddressModel addressModel = new AddressModel(address.getCity(), address.getGu(), address.getDong(),
                address.getZibun(), address.getPostalCode(), address.getApartment());
        addressModel.setId(address.getId());
        FacilityModel model = new FacilityModel(facility.getId(), facility.getName(), facility.getNumber(), facility.getDescription(),
                facility.getUrl(), facility.getKind(), facility.getRegUserId(),addressModel);

        Call<RegisterResponse> call = religionAPI.updateFacility(model);
        try {
            Response<RegisterResponse> response = call.execute();
            int result = response.body().getCode();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int deleteFac(int facId) {
        Call<RegisterResponse> call = religionAPI.deleteFacility(facId);
        try {
            Response<RegisterResponse> response = call.execute();
            int result = response.body().getCode();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
