package com.edu.nju.citi.API;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.UUID;

public class Account {
    public static String getAccountInformation(String access_token) {
        OkHttpClient client = new OkHttpClient();
        String information = "";
        Request request = new Request.Builder()
                .url("https://sandbox.apihub.citi.com/gcb/api/v1/accounts/details")
                .get()
                .addHeader("authorization", "Bearer " + access_token)
                .addHeader("uuid", UUID.randomUUID().toString())
                .addHeader("accept", "application/json")
                .addHeader("client_id", "5c63d4de-27a1-4f19-9165-f1b45345a931")
                .build();
        try {
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();
            //System.out.println(responseBody.string());
            information = responseBody.string();
        } catch (IOException ex) {
            System.out.println("Account request Error");
        }
        System.out.println(information);
        return information;
    }
}
