package com.rss.service.implementation;

import com.rss.entity.Address;
import com.rss.entity.Facility;
import com.rss.reqeust.FacilityModel;
import com.rss.service.SearchService;
import com.rss.util.retrofitUtil.APIUtils;
import com.rss.util.retrofitUtil.ReligionAPI;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchServiceImpl implements SearchService {
    private ReligionAPI religionAPI;

    public SearchServiceImpl() {
        this.religionAPI = APIUtils.getReligionAPI();
    }

    @Override
    public List<Facility> findFacilityAll() {
        return null;
    }

    @Override
    public List<Facility> findFacByPos(Address address) {
        return null;
    }

    @Override
    public List<Facility> findByCate(String cate) {
        return null;
    }

    @Override
    public List<Facility> findByName(String name) {
        List<Facility> facilityList = new ArrayList<>();
        Call<List<FacilityModel>> call = religionAPI.requestFacilityByName(name);
        try {
            Response<List<FacilityModel>> response = call.execute();
            for(FacilityModel model : response.body()) {
                Facility facility = model.toFacility();
                facilityList.add(facility);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facilityList;
    }
}
