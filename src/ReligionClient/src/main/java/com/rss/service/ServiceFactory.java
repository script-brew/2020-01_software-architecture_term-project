package com.rss.service;

public interface ServiceFactory {
    SignUpService getSignUpService();
    SignInService getSignInService();
    SearchService getSearchService();
    RegisterService getRegisterService();
}
