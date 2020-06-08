package com.rss.service.implementation;

import com.rss.service.*;

public class ServiceFactoryCreator implements ServiceFactory {
    private static volatile ServiceFactory instance;
    private SignUpService signUpService;
    private SignInService signInService;
    private SearchService searchService;
    private RegisterService registerService;

    public static synchronized ServiceFactory getInstance() {
        if(instance == null) {
            synchronized (ServiceFactoryCreator.class) {
                if(instance == null)
                    instance = new ServiceFactoryCreator();
            }
        }
        return instance;
    }

    @Override
    public SignUpService getSignUpService() {
        if(signUpService == null) signUpService = new SignUpServiceImpl();
        return signUpService;
    }

    @Override
    public SignInService getSignInService() {
        if(signInService == null) signInService = new SignInServiceImpl();
        return signInService;
    }

    @Override
    public SearchService getSearchService() {
        if(searchService == null) searchService = new SearchServiceImpl();
        return searchService;
    }

    @Override
    public RegisterService getRegisterService() {
        if(registerService == null) registerService = new RegisterServiceImpl();
        return registerService;
    }
}
