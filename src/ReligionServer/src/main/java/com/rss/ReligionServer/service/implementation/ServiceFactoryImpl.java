package com.rss.ReligionServer.service.implementation;

import com.rss.ReligionServer.service.FacilityService;
import com.rss.ReligionServer.service.ServiceFactory;
import com.rss.ReligionServer.service.SignService;

public class ServiceFactoryImpl implements ServiceFactory{
    private static volatile ServiceFactory instance;
    private SignService signService;
    private FacilityService facilityService;

    public static synchronized ServiceFactory getInstance() {
        if(instance == null) {
            synchronized (ServiceFactoryImpl.class) {
                if(instance == null) {
                    instance = new ServiceFactoryImpl();
                }
            }
        }

        return instance;
    }

    @Override
    public FacilityService getFacilityService() {
        if(facilityService == null) facilityService = new FacilityServiceImpl();
        return facilityService;
    }

    @Override
    public SignService getSignService() {
        if(signService == null) signService = new SignServiceImpl();
        return signService;
    }
}
