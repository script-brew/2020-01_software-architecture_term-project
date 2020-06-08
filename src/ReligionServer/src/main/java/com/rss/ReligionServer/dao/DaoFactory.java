package com.rss.ReligionServer.dao;

public interface DaoFactory {
    UserDao getUserDao();
    FacilityDao getFacilityDao();
    AddressDao getAddressDao();
    UserFacilityDao getUserFacilityDao();
}
