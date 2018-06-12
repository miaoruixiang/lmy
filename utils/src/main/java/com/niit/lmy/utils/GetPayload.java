package com.niit.lmy.utils;

import org.json.JSONObject;
import sun.misc.BASE64Decoder;

import java.io.IOException;

public class GetPayload {
    public static String get(String token){
        String payload = null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            JSONObject jsonObject =  new JSONObject(new  String(decoder.decodeBuffer(token.split("\\.")[1])));
            payload = jsonObject.getString("payload");
            payload = payload.replace("\"","").replace("\"","");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return payload;
    }

    public static void main(String[] args) {
        String p = get("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1Mjg3NzkwOTk1ODQsInBheWxvYWQiOiJcIjEzMTUzNDY0YTZzZFwiIn0.3kShUZsJ_pCLQFuBpPg6P12oWi7U50BY_y2h_rXQXB8");
        System.out.println(p);
    }
}
