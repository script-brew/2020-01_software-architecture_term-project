package com.rss.service.implementation;

import com.rss.entity.Facility;
import com.rss.service.RegisterService;
import com.rss.util.retrofitUtil.APIUtils;
import com.rss.util.retrofitUtil.ReligionAPI;

import java.util.List;

public class RegisterServiceImpl implements RegisterService {
    private ReligionAPI religionAPI;

    public RegisterServiceImpl() {
        religionAPI = APIUtils.getReligionAPI();
    }

    @Override
    public int registerFacility(Facility facility) {
        return 0;
    }

    @Override
    public List<Facility> findFacByRegUser(int userId) {
        return null;
    }

    @Override
    public int modifyFac(Facility facility) {
        return 0;
    }

    @Override
    public int deleteFac(int facId) {
        return 0;
    }
}
