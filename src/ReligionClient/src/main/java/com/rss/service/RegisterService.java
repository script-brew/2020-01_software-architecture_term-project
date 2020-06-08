package com.rss.service;

import com.rss.entity.Facility;

import java.util.List;

public interface RegisterService {
    int registerFacility(Facility facility);
    List<Facility> findFacByRegUser(int userId);
    int modifyFac(Facility facility);
    int deleteFac(int facId);
}
