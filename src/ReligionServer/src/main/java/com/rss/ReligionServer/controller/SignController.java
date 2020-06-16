package com.rss.ReligionServer.controller;

import com.rss.ReligionServer.dao.UserDao;
import com.rss.ReligionServer.model.SignInfo;
import com.rss.ReligionServer.model.UserModel;
import com.rss.ReligionServer.response.ResponseForm;
import com.rss.ReligionServer.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SignController {
    @Autowired
    SignService signService;

    @RequestMapping(value = "/isEmailExist", method = RequestMethod.GET)
    public ResponseForm isEmailExist(@RequestParam String email) {
        try {
            List<UserModel> userModels = signService.findUserByEmail(email);
            if (userModels.isEmpty()) return new ResponseForm(0, 0, "");
            else return new ResponseForm(1, userModels.get(0).getId(), "");
        } catch (Exception e) {
            return new ResponseForm(1, 0, e.toString());
        }

    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseForm signUp(@RequestBody UserModel userModel) {
        int userId = 0;
        try {
            userId = signService.create(userModel);
        } catch (Exception e) {
            return new ResponseForm(1, userId,  e.toString());
        }
        return new ResponseForm(0, userId, "");
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public ResponseForm signIn(@RequestBody SignInfo signInfo) {
        int sign = signService.signIn(signInfo);
        return new ResponseForm(sign, 0, signInfo.getEmail());
    }

    @RequestMapping(value = "/findUserById", method = RequestMethod.GET)
    public UserModel findUserById(@RequestParam int id) {
        return null;
    }

    @RequestMapping(value = "/findUserByEmail", method = RequestMethod.GET)
    public UserModel findUser(@RequestParam String email) {
        return null;
    }

    @RequestMapping(value = "/findUserAll", method = RequestMethod.GET)
    public List<UserModel> findAll() {
        List<UserModel> userModels = signService.findAll();
        return userModels;
    }

    @RequestMapping(value = "/modifyUser", method = RequestMethod.PUT)
    public ResponseForm modifyUser(@RequestBody UserModel userModel) {
        try {
            int update = signService.modifyUser(userModel);
        } catch (Exception e) {
            return new ResponseForm(1, userModel.getId(), e.toString());
        }
        return new ResponseForm(0, userModel.getId(), "");
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public ResponseForm deleteUser(@RequestParam int userId) {
        try {
            signService.deleteUser(userId);
        } catch (Exception e) {
            return new ResponseForm(1, userId, e.toString());
        }
        return new ResponseForm(0, userId, "");
    }
}
