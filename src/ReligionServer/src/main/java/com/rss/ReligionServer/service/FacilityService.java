package com.rss.ReligionServer.service;

import com.rss.ReligionServer.model.AddressModel;
import com.rss.ReligionServer.model.FacilityModel;

import java.util.List;

public interface FacilityService {
    int registerFacility(FacilityModel facilityModel);
    List<FacilityModel> findAll();
    List<FacilityModel> findFacilityByKind(String kind);
    List<FacilityModel> findFacilityByPos(AddressModel addressModel);
    List<FacilityModel> findFacilityByName(String name);
    int modifyFacility(FacilityModel facilityModel);
    int deleteFacility(int id);
}
