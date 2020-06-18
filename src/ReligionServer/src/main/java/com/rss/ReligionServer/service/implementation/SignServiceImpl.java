package com.rss.ReligionServer.service.implementation;

import com.rss.ReligionServer.dao.UserDao;
import com.rss.ReligionServer.model.SignInfo;
import com.rss.ReligionServer.model.UserModel;
import com.rss.ReligionServer.model.mapping.UserMapping;
import com.rss.ReligionServer.service.SignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SignServiceImpl implements SignService {
    @Autowired
    UserDao userDao;
    private Logger log = LoggerFactory.getLogger(SignServiceImpl.class);

    @Override
    public UserModel signIn(SignInfo signInfo) {
        List<UserMapping> userModels = userDao.retrieveByEmail(signInfo.getEmail());

        if(userModels == null) return null;

        for(UserMapping userModel : userModels) {
            log.info(String.format("email: %s, password: %s\n", userModel.getEmail(), userModel.getPassword()));
            if(userModel.getPassword().equals(signInfo.getPassword())) {
                UserModel user = new UserModel(userModel.getId(), userModel.getEmail(), userModel.getPassword(), userModel.getName(),
                        userModel.getNumber(), userModel.getBirthday(), userModel.getKind());

                log.info(String.format("find user info: %s\n", user.toString()));
                return user;
            }
        }
        return null;
    }

    @Override
    public int create(UserModel userModel) {
        try {
            if(userModel == null) throw new Exception();

            UserMapping mapping = new UserMapping(userModel.getId(), userModel.getEmail(), userModel.getPassword(),
                    userModel.getName(), userModel.getNumber(), userModel.getBirthday(), userModel.getKind());

            int userId = (int) userDao.create(mapping);

            if(userId == -1) throw new Exception();

            return userId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<UserModel> findAll() {
        List<UserMapping> mappings = userDao.retrieveAll();

        List<UserModel> userModels = new ArrayList<>();
        for(UserMapping mapping : mappings) {
            UserModel userModel = new UserModel(mapping.getId(), mapping.getEmail(), mapping.getPassword(), mapping.getName(),
                    mapping.getNumber(), mapping.getBirthday(), mapping.getKind());
            userModels.add(userModel);
        }
        return userModels;
    }

    @Override
    public List<UserModel> findUserByEmail(String email) {
        List<UserMapping> mappings = userDao.retrieveByEmail(email);

        List<UserModel> userModels = new ArrayList<>();
        for(UserMapping mapping : mappings) {
            UserModel userModel = new UserModel(mapping.getId(), mapping.getEmail(), mapping.getPassword(), mapping.getName(),
                    mapping.getNumber(), mapping.getBirthday(), mapping.getKind());
            userModels.add(userModel);
        }
        return userModels;
    }

    @Override
    public UserModel findUserById(int id) {
        UserMapping mapping = userDao.retrieveById(id);

        UserModel userModel = new UserModel(mapping.getId(), mapping.getEmail(), mapping.getPassword(), mapping.getName(),
                mapping.getNumber(), mapping.getBirthday(), mapping.getKind());

        return userModel;
    }

    @Override
    public int modifyUser(UserModel userModel) {
        try {
            if(userModel == null) throw new Exception();
            UserMapping mapping = new UserMapping(userModel.getId(), userModel.getEmail(), userModel.getPassword(),
                    userModel.getName(), userModel.getNumber(), userModel.getBirthday(), userModel.getKind());

            boolean isUpdate = userDao.update(mapping) > 0;

            return isUpdate ? 1 : 0;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int deleteUser(int id) {
        try {
            UserMapping mapping = userDao.retrieveById(id);
            if(mapping == null) throw new Exception();

            boolean isDelete = userDao.remove(id) > 0;
            return isDelete ? 0 : 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
}
