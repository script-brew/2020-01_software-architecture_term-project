package com.rss.ReligionServer.dao;

import com.rss.ReligionServer.model.AddressModel;
import com.rss.ReligionServer.model.FacilityModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityDao {
    int create(FacilityModel facilityModel);
    FacilityModel retrieveById(int id);
    List<FacilityModel> retrieveByCate(String kind);
    List<FacilityModel> retrieveByPos(@Param("adrress") AddressModel addressModel,
                                      @Param("to") int to);
    List<FacilityModel> retrieveByName(String name);
    int update(FacilityModel facilityModel);
    int remove(int id);
}
