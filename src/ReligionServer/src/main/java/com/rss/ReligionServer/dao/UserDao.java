package com.rss.ReligionServer.dao;

import com.rss.ReligionServer.model.UserModel;
import com.rss.ReligionServer.model.mapping.UserMapping;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    long create(UserMapping user);
    List<UserMapping> retrieveAll();
    List<UserMapping> retrieveByEmail(String email);
    UserMapping retrieveById(int id);
    long update(UserMapping user);
    long remove(int id);
}
