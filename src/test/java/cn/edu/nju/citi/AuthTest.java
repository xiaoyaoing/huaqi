package cn.edu.nju.citi;

import cn.edu.nju.citi.API.Account;
import cn.edu.nju.citi.API.Authorize;

public class AuthTest {
    public static void main(String[] args) {
        Account.getAccountInformation(Authorize.getToken(Authorize.getAccessToken()));
    }
}
