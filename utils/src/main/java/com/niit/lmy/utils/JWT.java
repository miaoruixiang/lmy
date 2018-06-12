package com.niit.lmy.utils;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.velocity.runtime.directive.Foreach;
import org.json.JSONObject;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JWT {

    private static final String EXP = "exp";

    private static final String PAYLOAD = "payload";

    /**
     * get jwt String of object
     * @param object
     *            the POJO object
     * @param maxAge
     *            the milliseconds of life time
     * @return the jwt token
     */
    //加密
    public static <T> String sign(T object, long maxAge,String SECRET) {
        try {
            final JWTSigner signer = new JWTSigner(SECRET);
            final Map<String, Object> claims = new HashMap<>();
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(object);
            claims.put(PAYLOAD, jsonString);
            claims.put(EXP, System.currentTimeMillis() + maxAge);
            return signer.sign(claims);
        } catch(Exception e) {
            return null;
        }
    }


    /**
     * get the object of jwt if not expired
     * @param jwt
     * @return POJO object
     */
    //解密
    public static<T> T unsign(String jwt, Class<T> classT,String  SECRET) {
        final JWTVerifier verifier = new JWTVerifier(SECRET);
        try {
            final Map<String,Object> claims= verifier.verify(jwt);
            if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {
                long exp = (Long)claims.get(EXP);
                long currentTimeMillis = System.currentTimeMillis();
                if (exp > currentTimeMillis) {
                    String json = (String)claims.get(PAYLOAD);
                    ObjectMapper objectMapper = new ObjectMapper();
                    return objectMapper.readValue(json, classT);
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }


    public static void main (String args[]){
        String a = sign("aaa", 60 * 60 * 60, "aaa");
        System.out.println(a);

//        BASE64Encoder encoder = new BASE64Encoder();
//        String jdkEncode = encoder.encode(new String(a.split("\\.")[1]).getBytes());
//        System.out.println("JDKEncode-->" + jdkEncode);

        BASE64Decoder decoder = new BASE64Decoder();
        try {

            String decode = new String(decoder.decodeBuffer(a.split("\\.")[1]));
            JSONObject jsonObject = new JSONObject(decode);
            String payload = jsonObject.getString("payload");
            System.out.println(payload.substring(1,payload.length()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
