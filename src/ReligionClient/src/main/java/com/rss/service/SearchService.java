package com.rss.service;

import com.rss.entity.Address;
import com.rss.entity.Facility;

import java.util.List;

public interface SearchService {
    List<Facility> findFacilityAll();
    List<Facility> findFacByPos(String address, int mode);
    List<Facility> findByCate(String cate);
    List<Facility> findByName(String name);
}
