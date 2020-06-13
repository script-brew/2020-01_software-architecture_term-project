package com.rss.ReligionServer.dao;

import com.rss.ReligionServer.model.AddressModel;
import com.rss.ReligionServer.model.FacilityModel;
import com.rss.ReligionServer.model.mapping.AddressMapping;
import com.rss.ReligionServer.model.mapping.FacilityMapping;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityDao {
    long create(FacilityMapping facilityMapping);
    List<FacilityMapping> retrieveAll();
    FacilityMapping retrieveById(int id);
    List<FacilityMapping> retrieveByKind(String kind);
    List<FacilityMapping> retrieveByPos(@Param("address") AddressMapping addressMapping,
                                      @Param("to") int to);
    List<FacilityMapping> retrieveByName(String name);
    List<FacilityMapping> retrieveByUserId(int userId);
    long update(FacilityMapping facilityMapping);
    long remove(int id);
}
