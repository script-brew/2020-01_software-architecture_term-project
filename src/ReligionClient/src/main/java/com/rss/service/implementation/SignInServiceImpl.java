package com.rss.service.implementation;

import com.rss.entity.User;
import com.rss.service.SignInService;
import com.rss.util.retrofitUtil.APIUtils;
import com.rss.util.retrofitUtil.ReligionAPI;
import com.rss.util.retrofitUtil.SignAPI;
import retrofit2.Retrofit;

public class SignInServiceImpl implements SignInService {
    private SignAPI signAPI;

    public SignInServiceImpl() {
        signAPI = APIUtils.getSignAPI();
    }
    @Override
    public User requestSignIn(String email, String password) {
        return null;
    }
}
