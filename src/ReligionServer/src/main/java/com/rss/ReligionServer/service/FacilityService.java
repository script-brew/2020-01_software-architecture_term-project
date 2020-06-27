package com.rss.ReligionServer.service;

import com.rss.ReligionServer.model.AddressModel;
import com.rss.ReligionServer.model.FacilityModel;

import java.util.List;

public interface FacilityService {
    int registerFacility(FacilityModel facilityModel);
    List<FacilityModel> findByUserId(int userId);
    List<FacilityModel> findFacilityByKind(String kind);
    List<FacilityModel> findFacilityByPos(String address, int mode);
    List<FacilityModel> findFacilityByName(String name);
    int modifyFacility(FacilityModel facilityModel);
    int deleteFacility(int id);
}
