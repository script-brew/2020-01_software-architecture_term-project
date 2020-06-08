package com.rss.ReligionServer.controller;

import com.rss.ReligionServer.model.SignInfo;
import com.rss.ReligionServer.model.UserModel;
import com.rss.ReligionServer.response.ResponseForm;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignController {

    @RequestMapping(value = "/isEmailExist", method = RequestMethod.GET)
    public ResponseForm isEmailExist(@RequestParam String email) {
        return null;
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseForm signUp(@RequestBody UserModel userModel) {
        return null;
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public ResponseForm signIn(@RequestBody SignInfo signInfo) {
        return null;
    }
}
