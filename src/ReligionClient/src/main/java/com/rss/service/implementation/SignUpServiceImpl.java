package com.rss.service.implementation;

import com.rss.entity.User;
import com.rss.service.RegisterService;
import com.rss.service.SignUpService;
import com.rss.util.retrofitUtil.APIUtils;
import com.rss.util.retrofitUtil.ReligionAPI;
import com.rss.util.retrofitUtil.SignAPI;

public class SignUpServiceImpl implements SignUpService {
    private SignAPI signAPI;

    public SignUpServiceImpl() {
        signAPI = APIUtils.getSignAPI();
    }

    @Override
    public boolean isEmailExist(String email) {
        return false;
    }

    @Override
    public boolean isPasswordAppropriate(String password) {
        return false;
    }

    @Override
    public boolean checkPassword(String check, String confirm) {
        return false;
    }

    @Override
    public int requestSignUp(User newUser) {
        return 0;
    }
}
