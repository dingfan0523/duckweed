package com.blogs.duckweed.common.util;

import io.jsonwebtoken.*;
import io.swagger.annotations.ApiModel;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dingfan
 */
@ApiModel(value = "token工具类")
public class TokenUtil {
    /**
     * token 用户id
     */
    private static final String CLAIM_KEY_USER_ID = "userId";
    /**
     * token 生成时间
     */
    private static final String CLAIM_KEY_CREATED = "created";
    /**
     * 签名秘钥
     */
    private static final String SECRET = "ping#fan";

    /**
     * 有效期(10小时)
     */
    private static final long EXPIRES_TIME = 5000;


    /**
     * 生成token
     *
     * @param username 用户标识
     * @return token
     */
    @Deprecated
    public static String createJwtToken(String username) {
        long nowMills = System.currentTimeMillis();
        Date now = new Date(nowMills);
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
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
     * 生成token
     *
     * @param userId 用户实体
     * @return token
     */
    public static String createJwtToken(Integer userId) {
        long nowMills = System.currentTimeMillis();
        Map<String, Object> claims = new HashMap<>(2);
        claims.put(CLAIM_KEY_USER_ID, userId);
        claims.put(CLAIM_KEY_CREATED, nowMills);
        return Jwts.builder().setClaims(claims).setExpiration(new Date(nowMills + EXPIRES_TIME)).signWith(SignatureAlgorithm.HS256, SECRET).compact();
    }

    /**
     * 检查token有效性
     *
     * @param token token
     * @return true 有效 false 失效
     */
    public static boolean validateToken(String token, int userId) {
        try {
            int id = getUserIdFromToken(token);
            Date expiredDate = getExpiredDateFromToken(token);
            return id == userId && new Date().before(expiredDate);
        } catch (ExpiredJwtException e) {
            return false;
        }
    }

    /**
     * 读取token中的用户id
     *
     * @param token token
     * @return 用户id
     */
    public static int getUserIdFromToken(String token) throws ExpiredJwtException {
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        return (int) claims.get(CLAIM_KEY_USER_ID);
    }

    /**
     * 读取token中的过期时间
     *
     * @param token token
     * @return 过期时间
     */
    private static Date getExpiredDateFromToken(String token) throws ExpiredJwtException {
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        return claims.getExpiration();
    }

}
