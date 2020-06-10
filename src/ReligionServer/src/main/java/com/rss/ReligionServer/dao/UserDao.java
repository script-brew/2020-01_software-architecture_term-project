package com.rss.ReligionServer.dao;

import com.rss.ReligionServer.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    long create(UserModel user);
    List<UserModel> retrieveAll();
    List<UserModel> retrieveByEmail(String email);
    UserModel retrieveById(int id);
    long update(UserModel userModel);
    long remove(int id);
}
