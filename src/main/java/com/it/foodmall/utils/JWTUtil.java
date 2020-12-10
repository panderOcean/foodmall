package com.it.foodmall.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.it.foodmall.bean.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JWTUtil {
    private static  final String Signature = "+1dsaf2@wq1";

    public static String getToken(User user){
        Date start = new Date();
        //30天有效时间
        Date end = new Date(start.getTime() + (long) 7 * 24 * 60 * 60 * 1000);
        return  JWT.create()
                .withClaim("UID",user.getUID())
                .withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(Signature));
    }

    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(Signature)).build().verify(token);
    }

    public static String getTokenUserId(){
        String token = getRequest().getHeader("token");
        return JWT.require(Algorithm.HMAC256(Signature)).build().verify(token).getClaim("UID").asString();

//        JWTVerifier build = JWT.require(Algorithm.HMAC256(Signature)).build();
//        DecodedJWT verify = build.verify(token);
//        System.out.println(verify.getClaim("UID").asString());

//        DecodedJWT decode = JWT.decode(token);
//        String userId = decode.getClaim("UID").asString();
//        String expiresAt = decode.getExpiresAt().toString();
//        String string = decode.getIssuedAt().toString();
//        return JWT.decode(token).getAudience().get(0);
//        return "asd";
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }

}
