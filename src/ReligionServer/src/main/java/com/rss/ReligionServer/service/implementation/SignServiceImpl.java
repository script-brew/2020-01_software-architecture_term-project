package com.rss.ReligionServer.service.implementation;

import com.rss.ReligionServer.dao.UserDao;
import com.rss.ReligionServer.model.SignInfo;
import com.rss.ReligionServer.model.UserModel;
import com.rss.ReligionServer.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignServiceImpl implements SignService {
    @Autowired
    UserDao userDao;

    @Override
    public int signIn(SignInfo signInfo) {
        List<UserModel> userModels = userDao.retrieveByEmail(signInfo.getEmail());
        if(userModels == null) return 1;

        for(UserModel userModel : userModels) {
            if(userModel.getPassword().equals(signInfo.getPassword())) return 0;
        }
        return 1;
    }

    @Override
    public int create(UserModel userModel) {
        int userId = (int) userDao.create(userModel);
        return userId;
    }

    @Override
    public List<UserModel> findAll() {
        List<UserModel> userModels = userDao.retrieveAll();
        return userModels;
    }

    @Override
    public List<UserModel> findUserByEmail(String email) {
        List<UserModel> userModels = userDao.retrieveByEmail(email);
        return userModels;
    }

    @Override
    public UserModel findUserById(int id) {
        UserModel userModel = userDao.retrieveById(id);
        return userModel;
    }

    @Override
    public int modifyUser(UserModel userModel) {
        boolean isUpdate = userDao.update(userModel) > 0;
        return isUpdate ? 0 : 1;
    }

    @Override
    public int deleteUser(int id) {
        boolean isDelete = userDao.remove(id) > 0;
        return isDelete ? 0 : 1;
    }
}
