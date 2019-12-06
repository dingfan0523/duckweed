package com.blogs.duckweed.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.ApiModel;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * @author dingfan
 */
@ApiModel(value = "token工具类")
public class TokenUtil {
    /**
     * 签名秘钥
     */
    public static final String SECRET = "547660553";

    /**
     * 有效期(10小时)
     */
    public static final long EXPIRES_TIME = 36000000;


    /**
     * 生成token
     *
     * @param username 用户标识
     * @return token
     */
    public static String createJwtToken(String username) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMills = System.currentTimeMillis();
        Date now = new Date(nowMills);

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        //创建token
        JwtBuilder builder = Jwts.builder().setId(username).setIssuedAt(now).signWith(signatureAlgorithm, signingKey);
        //添加过期时间
        if (EXPIRES_TIME >= 0) {
            long expMillis = nowMills + EXPIRES_TIME;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    /**
     * 验证和读取JWT的示例方法
     */
    public static Claims parseJWT(String jwt) {
        Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET)).parseClaimsJws(jwt).getBody();
        return claims;
    }

    public static void main(String[] args) {
        String token = TokenUtil.createJwtToken("13416075240");
        System.out.println(token);
        System.out.println(parseJWT(token));
    }
}
