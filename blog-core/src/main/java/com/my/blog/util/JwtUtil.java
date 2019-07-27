package com.my.blog.util;


import com.my.blog.exception.SystemException;
import com.my.blog.repository.model.User;
import com.my.blog.repository.vo.AdminVo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class JwtUtil {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 保存路径
     */
    private String saveKey = "";

    /**
     * 刷新时间
     */
    private static int REFRESH_TIME = 30;

    /**
     * yyyyMMddHHmmss
     */
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * token 过期时间 默认 1天 24小时 60分 60秒
     */
    private static final int expTimeOut = 24 * 60 * 60;


    /**
     * 时间格式
     */
    private TimeFormat timeFormat;

    /**
     * token 密钥
     */
    private static final String tokenSecret = "eyJhbGciOiJIUzI1fg55NiIsInR5cCI6IkpXVCJ9.234eyJuYW1lIjoicWluemhlbmdsaWFuZ2Fz";

    public AdminVo create(User user) {
        return create(user, expTimeOut);
    }


    public AdminVo create(User user, int timeSecond) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
        // 签发时间
        Date nowDate = new Date();

        // token过期时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(Calendar.SECOND, timeSecond);
        Date expDate = calendar.getTime();

        // 刷新时间
        calendar.setTime(nowDate);
        calendar.add(Calendar.SECOND, timeSecond - REFRESH_TIME);
        Date refreshDate = calendar.getTime();

        Map<String, Object> claims = new HashMap<>();
        claims.put("alg", "HS512");
        claims.put("typ", "JWT");

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(nowDate)
                .setSubject(JsonUtils.toJSONString(user))
                .setExpiration(expDate)                // 过期时间
                .signWith(signatureAlgorithm, tokenSecret)                                           // 签名算法以及密匙
                .compact();

        setUserCache(token, JsonUtils.toJSONString(user), timeSecond - REFRESH_TIME);

        AdminVo adminVo = new AdminVo();
        adminVo.setToken(token);
        adminVo.setRefreshDate(refreshDate.getTime());
        adminVo.setUser(user);
        return adminVo;
    }

    public Boolean verify(String token) throws MalformedJwtException {
        Claims claims;
        try {
            //解密token，拿到里面的对象claims
            claims = Jwts.parser().setSigningKey(tokenSecret)
                    .parseClaimsJws(token).getBody();
            User subject = JsonUtils.fromJSONString(claims.getSubject(), User.class);

            String user = redisUtil.get(getKey(token));
            return user != null;
        }catch (SystemException e){
            log.info(e.getMsg());
            return false;
        }

    }

    /**
     * 刷新jwt
     *
     * @param claims     claims
     * @param singingKey 密钥
     * @param expiration 过期时间
     * @return 刷新后的jwt
     */
    public String refreshToken(Claims claims, String singingKey, Long expiration) {
        return "";
    }

    /**
     * 保存用户
     */
    public void setUserCache(String key, String loginUser, int seconds) {
        redisUtil.set(getKey(key), loginUser, seconds);
    }

    public User getUser(String token) throws MalformedJwtException {
        Claims claims;
        //解密token，拿到里面的对象claims
        claims = Jwts.parser().setSigningKey(tokenSecret)
                .parseClaimsJws(token).getBody();
        return JsonUtils.fromJSONString(claims.getSubject(), User.class);
    }

    public boolean updateUser(String key, String loginUser, int seconds) {
        if (exists(getKey(key))) {
            setUserCache(key, loginUser, seconds);
            return true;
        }
        return false;
    }

    public void remove(String key) {
        del(getKey(key));
    }

    private boolean exists(String key) {
        return redisUtil.exists(key);
    }

    private String getKey(String key) {
        return "security:session:" + key;
    }

    private Long expire(String key, int expire) {
        return redisUtil.expire(key, expire);
    }

    private void del(String key) {
        redisUtil.del(key);
    }

    /**
     * 过期时间格式枚举
     *
     * @author qinzhengliang
     * @version [版本号, 2018年6月29日]
     */
    public enum TimeFormat {
        TIME_MILLIS_PATTERN, FULL_CHINESE_PATTERN
    }

    public String getSaveKey() {
        return saveKey;
    }

    public void setSaveKey(String saveKey) {
        this.saveKey = saveKey;
    }
}
