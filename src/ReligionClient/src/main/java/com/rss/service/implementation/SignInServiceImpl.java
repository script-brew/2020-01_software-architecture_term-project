package com.rss.service.implementation;

import com.rss.entity.User;
import com.rss.reqeust.SignRequest;
import com.rss.reqeust.UserModel;
import com.rss.service.SignInService;
import com.rss.util.retrofitUtil.APIUtils;
import com.rss.util.retrofitUtil.ReligionAPI;
import com.rss.util.retrofitUtil.SignAPI;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignInServiceImpl implements SignInService {
    private SignAPI signAPI;

    public SignInServiceImpl() {
        signAPI = APIUtils.getSignAPI();
    }
    @Override
    public User requestSignIn(String email, String password) {
        SignRequest signRequest = new SignRequest(email, password);
        Call<UserModel> call = signAPI.requestSignIn(signRequest);

        try {
            Response<UserModel> response = call.execute();
            UserModel userModel = response.body();

            if(userModel == null) return null;

            User user = userModel.toUser();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
