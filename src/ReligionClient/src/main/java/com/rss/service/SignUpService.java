package com.rss.service;

import com.rss.entity.User;

public interface SignUpService {
    boolean isEmailExist(String email);
    boolean isPasswordAppropriate(String password);
    boolean checkPassword(String check, String confirm);
    int requestSignUp(User newUser);
}
