package com.rss.ReligionServer.dao.implementation;

import com.rss.ReligionServer.dao.*;

public class DaoFactoryCreator implements DaoFactory {
    private static volatile DaoFactory instance;
    private UserDao userDao;
    private FacilityDao facilityDao;
    private AddressDao addressDao;
    private UserFacilityDao userFacilityDao;

    public static synchronized DaoFactory getInstance() {
        if(instance == null) {
            synchronized (DaoFactoryCreator.class) {
                if(instance == null) {
                    instance = new DaoFactoryCreator();
                }
            }
        }
        return instance;
    }

    @Override
    public UserDao getUserDao() {
        if(userDao == null) userDao = new UserDaoImpl();
        return userDao;
    }

    @Override
    public FacilityDao getFacilityDao() {
        if(facilityDao == null) facilityDao = new FacilityDaoImpl();
        return facilityDao;
    }

    @Override
    public AddressDao getAddressDao() {
        if(addressDao == null) addressDao = new AddressDaoImpl();
        return addressDao;
    }

    @Override
    public UserFacilityDao getUserFacilityDao() {
        if(userFacilityDao == null) userFacilityDao = new UserFacilityDaoImpl();
        return userFacilityDao;
    }
}
