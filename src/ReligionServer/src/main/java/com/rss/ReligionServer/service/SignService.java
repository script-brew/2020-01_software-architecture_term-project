package com.rss.ReligionServer.service;

import com.rss.ReligionServer.model.SignInfo;
import com.rss.ReligionServer.model.UserModel;

import java.util.List;

public interface SignService {
    int signIn(SignInfo signInfo);
    int create(UserModel userModel);
    List<UserModel> findAll();
    List<UserModel> findUserByEmail(String email);
    UserModel findUserById(int id);
    int modifyUser(UserModel userModel);
    int deleteUser(int id);
}
