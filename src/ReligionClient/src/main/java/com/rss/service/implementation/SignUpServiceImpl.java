package com.rss.service.implementation;

import com.rss.entity.User;
import com.rss.reqeust.SignUpRequest;
import com.rss.respond.SignResponse;
import com.rss.service.RegisterService;
import com.rss.service.SignUpService;
import com.rss.util.retrofitUtil.APIUtils;
import com.rss.util.retrofitUtil.ReligionAPI;
import com.rss.util.retrofitUtil.SignAPI;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class SignUpServiceImpl implements SignUpService {
    private SignAPI signAPI;

    public SignUpServiceImpl() {
        signAPI = APIUtils.getSignAPI();
    }

    @Override
    public boolean isEmailExist(String email) {
        Call<SignResponse> call = signAPI.isEmailExist(email);
        try {
            Response<SignResponse> response = call.execute();
            SignResponse result = response.body();
            if(!result.getError().equals("")) throw new Exception(result.getError());

            return result.getCode() == 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isPasswordAppropriate(String password) {
        return false;
    }

    @Override
    public boolean checkPassword(String check, String confirm) {
        return check.equals(confirm);
    }

    @Override
    public int requestSignUp(User newUser) {
        SignUpRequest signUpRequest = newUser.toSignUpRequest();

        Call<SignResponse> call = signAPI.requestSignUp(signUpRequest);

        try {
            Response<SignResponse> response = call.execute();
            SignResponse result = response.body();
            if(!result.getError().equals("")) throw new Exception(result.getError());

            return result.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
