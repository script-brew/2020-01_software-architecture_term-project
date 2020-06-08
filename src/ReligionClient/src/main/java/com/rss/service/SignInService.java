package com.rss.service;

import com.rss.entity.User;

public interface SignInService {
    User requestSignIn(String email, String password);
}
