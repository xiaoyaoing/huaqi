package com.example.demo;

import com.example.demo.API.Account;
import com.example.demo.API.Authorize;

public class AuthTest {
    public static void main(String[] args) {
       Account.getAccountInformation(Authorize.getToken(Authorize.getAccessToken()));
    }
}
