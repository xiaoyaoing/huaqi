package com.edu.nju.citi;

import com.edu.nju.citi.API.Account;
import com.edu.nju.citi.API.Authorize;

public class AuthTest {
    public static void main(String[] args) {
        Account.getAccountInformation(Authorize.getToken(Authorize.getAccessToken()));
    }
}
