package cn.edu.nju.citi.API;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Authorize {
    /**
     *
     * @param jsonInformation json字符串
     * @return json中包含的授权码
     */
    public static String getToken(String jsonInformation) {
        JSONObject responseBody = (JSONObject) JSON.parse(jsonInformation);
        //System.out.println(responseBody.get("access_token"));
        if (responseBody.get("access_token")==null) return null;
        return responseBody.get("access_token").toString();
    }

    public static String getRefresh_Token(String jsonInformation) {
        JSONObject responseBody = (JSONObject) JSON.parse(jsonInformation);
        //System.out.println(responseBody.toString());
        if (responseBody.get("refresh_token")==null) return null;
        return responseBody.get("refresh_token").toString();
    }

    /**
     *
     * @param url 修正url格式
     * @return
     */
    public static String getTokenByRF(String url) {
        Pattern pattern = Pattern.compile("(\")([^<]*)(\")");
        Matcher matcher = pattern.matcher(url);
        while (matcher.find()) {
            return matcher.group(2);
        }
        return null;
    }

    /**
     *
     * @return 简化版的授权码获得，不需要用户信息（但是需要处理）
     */
    public static String getAccessToken() {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials&scope=/api");
        Request request = new Request.Builder()
                .url("https://sandbox.apihub.citi.com/gcb/api/clientCredentials/oauth2/token/hk/gcb")
                .post(body)
                .addHeader("authorization", "Basic NWM2M2Q0ZGUtMjdhMS00ZjE5LTkxNjUtZjFiNDUzNDVhOTMxOnZXNWxVNXhBMnhYMnlIN25INXBQOHFCMG1PNXBGMG5BN3hSOGRDMHRHM3NIMGhVOGtU")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("accept", "application/json")
                .build();
        String returnInformation = null;
        try {
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();
            //System.out.println(responseBody.string());
            returnInformation = responseBody.string();
        } catch (IOException ex) {
            System.out.println("Authorize request Error");
        }
        System.out.println(returnInformation);
        return returnInformation;
    }

    public static String getAccessTokenWithGrantType(String code, String redirect_URL) {
        String returnInformation = null;
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=authorization_code&code=" + code + "&redirect_uri=" + redirect_URL);
        Request request = new Request.Builder()
                .url("https://sandbox.apihub.citi.com/gcb/api/authCode/oauth2/token/hk/gcb")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("authorization", "Basic NWM2M2Q0ZGUtMjdhMS00ZjE5LTkxNjUtZjFiNDUzNDVhOTMxOnZXNWxVNXhBMnhYMnlIN25INXBQOHFCMG1PNXBGMG5BN3hSOGRDMHRHM3NIMGhVOGtU")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .build();
        try {
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();
            //System.out.println(responseBody.string());
            returnInformation = responseBody.string();
        } catch (IOException ex) {
            System.out.println("Authorize request Error");
        }
        System.out.println(returnInformation);
        return returnInformation;
    }

    /**
     *
     * @param userID
     * @param formerRefreshToken
     * @return
     */
    public static String refreshToken(String userID, String formerRefreshToken) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=refresh_token&refresh_token=" + formerRefreshToken);
        Request request = new Request.Builder()
                .url("https://sandbox.apihub.citi.com/gcb/api/authCode/oauth2/refresh")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("authorization", "Basic NWM2M2Q0ZGUtMjdhMS00ZjE5LTkxNjUtZjFiNDUzNDVhOTMxOnZXNWxVNXhBMnhYMnlIN25INXBQOHFCMG1PNXBGMG5BN3hSOGRDMHRHM3NIMGhVOGtU")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .build();
        String returnInformation = null;
        try {
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();
            //System.out.println(responseBody.string());
            returnInformation = responseBody.string();
        } catch (IOException ex) {
            System.out.println("Authorize request Error");
        }
        System.out.println(returnInformation);
        return returnInformation;
    }

    /**
     *
     * @param token
     * @param tokenType
     * @return
     */
    public static String revokeToken(String token, String tokenType) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "token=" + token + "&token_type_hint=" + tokenType);
        Request request = new Request.Builder()
                .url("https://sandbox.apihub.citi.com/gcb/api/authCode/oauth2/revoke")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("authorization", "Basic NWM2M2Q0ZGUtMjdhMS00ZjE5LTkxNjUtZjFiNDUzNDVhOTMxOnZXNWxVNXhBMnhYMnlIN25INXBQOHFCMG1PNXBGMG5BN3hSOGRDMHRHM3NIMGhVOGtU")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .build();

        String returnInformation = null;
        try {
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();
            //System.out.println(responseBody.string());
            returnInformation = responseBody.string();
        } catch (IOException ex) {
            System.out.println("Authorize request Error");
        }
        System.out.println(returnInformation);
        return returnInformation;
    }
}
