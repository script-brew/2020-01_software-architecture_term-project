package com.rss.service.implementation;

import com.rss.entity.Address;
import com.rss.entity.Facility;
import com.rss.service.SearchService;
import com.rss.util.retrofitUtil.APIUtils;
import com.rss.util.retrofitUtil.ReligionAPI;

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
        return null;
    }
}
