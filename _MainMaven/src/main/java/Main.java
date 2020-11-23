import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Main {
    private static final long EXPIRATIONTIME = 60_000; // 有效期

    private static int expir = 30; // 超时时间
    // 公钥
    private static String secretPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjt3v3z8ukVod/GpDZZJGrELXvMLTAb/+qF+DzzAXKrdK2NqWP0ADVMPjSBh6Sf/t/8mvss8Pq43UEI3TYzs/ybZ/CY8kSb4hk8Mx1rKJstX6SmFQ0P68/MOM+WjZWtB0mQZzsmJI0BoDk8g0j32ob7jFz1ne8qMerluXIhYJHHA9xN5kzlFS5v1Cx92dPfKxW7LzRFi9wthN2tHsqdPK0l7QWk7Vf4wxdbh1mzFZmr5I5ALKgWCM+a/JlBO3+2Jbz69W4z5iqFKd9dHGfW5okalPpmuokijAB3EJSk6wspFNk8ujWzffN12IERdMh0Ii/dxF+/y/OMlw6GoqbDFJxQIDAQAB";
    // 私钥
    private static String secretPrivateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCO3e/fPy6RWh38akNlkkasQte8wtMBv/6oX4PPMBcqt0rY2pY/QANUw+NIGHpJ/+3/ya+yzw+rjdQQjdNjOz/Jtn8JjyRJviGTwzHWsomy1fpKYVDQ/rz8w4z5aNla0HSZBnOyYkjQGgOTyDSPfahvuMXPWd7yox6uW5ciFgkccD3E3mTOUVLm/ULH3Z098rFbsvNEWL3C2E3a0eyp08rSXtBaTtV/jDF1uHWbMVmavkjkAsqBYIz5r8mUE7f7YlvPr1bjPmKoUp310cZ9bmiRqU+ma6iSKMAHcQlKTrCykU2Ty6NbN983XYgRF0yHQiL93EX7/L84yXDoaipsMUnFAgMBAAECggEAK4dzjpGxnpfWixHVdx0aa2HyWZECuYXGEYcIohgE9v7hzzDKlnrqiOkmVtEecW2JFmZdIh30qFCOTHzp61IiHVN9YWw7ojxL/rl6de/wBI0ttXvxI7x52Im8akGH+COLYxSUK8XGaaGDdYOKgC3JJEEoBAVd6I/KyVUet0P/gqo6pluWXhumJkfz0d6UZlzXhe3YgvjkYNcr24agk5dDV85WX0EvpQw8UrlXCkiM0MYDRWYWTaDJQDe1ARJX440igO5zT8UBv5kYvcMBvVa6myzJr83B+dYxKq9KZA3VK9vMJoEo+8E2UOjzZZOCIcpAabQA375Bl1zeELZ5zwMAAQKBgQDZg0UP2qypuWjawxRRwQc79QfMOrJkJ5AFTx5OGJ/hFq3XFMPNK7Ru7JOoQKOmGipcz+j+y6loXkOrSE7Q6u9UGZKb1qjEaYNMqpUGmYoA3DlD6p8t+oKk8x8t+IG4luke8F4FHiyEPKHcMLFui/hHkCo99QJwycMEkf80KCDoRQKBgQCoJWqaxrG8Bmyv5IzoJH5bhPVty+NiTWQEnRsN0iC/SJfELKAswqo0MKkwlt3Qt0+QCOdjqYWecL5OzH7WyJcOGFs9iJSSsvp+IQkQS8icZvvhhVgl+3EKqGqctmnGIzv6GJdEBYducHxvyvne8HaL/kETQuLnl6kFMGkvoaSzgQKBgCEF+xBDJP/HtJGyGH2pDs4dj4eESd1G3GjR8EnvFyb3aIFFF80om4ZTyL88wRvQ0SmyLy+wABJmbWOt4Ll7Uca08ztRxeG8G0EijOmpmfgzd0ZGctBqPjeI6ezy088QqmgWGlAwmpWhFvn1MpsUCSfkTWWGs04oc8FX4SUsCoL5AoGAaCk1jsfDVmzMa3GzcCMbO2pz9x40r7KtYMZJ+hfPPW+kxFu4pcG5WjdCt9zdb+v+l4VMgcqEAZBp87puYHNGT+76pnWzQ+Unk3a3fKbVkT2ijyPhZTYL4sRNtuKxR5KQFu+g1Pxv1xRLoZ0liNuBNFu+yEXI9hpXE+XXYzBJLQECgYAfC94OP3SRYDGv5Dglf8yGsmmiIxRSs28Di6lOIBRrBZ15vVqz/0yD6dQOV9a60qu6NKCsU490IzYLc3b3+Z5zGRo/OOu2Ab9+ELAQ9Yx9xIzQOqjFIzjldZ8DYHzIQwLMfHB9GADBZpdpK5xAJoU4qOTpuXQOPY9WRwPdNdYsmA==";

    public static void main(String[] args) throws Exception {
        Map<String, Object> sub = new HashMap<>();
        sub.put("username", "zhangsan");
        sub.put("usersrc", "jxboss");
        // 私钥加密信息
        String str = generateJWT(JSONObject.toJSONString(sub));
        // JWT密文信息
        System.out.println(str);
        // 公钥解析密文，得到用户信息
        System.out.println(getJwtJson(str));

    }

    /**
     * Generate JWT. 待加密对象字符串
     */
    public static String generateJWT(String json) {
        return generateJWT(json, expir);
    }

    /**
     * 加密用户信息字符串，得到JWT
     */
    public static String generateJWT(String json, long min) {
        // 生成JWT
        String jwt = Jwts.builder().setSubject(json)
                .setExpiration(new Date(System.currentTimeMillis() + min * EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS256, secretPrivateKey).compact();
        return jwt;
    }

    /**
     * Gets the claims.
     *
     * @param token the token
     * @return the claims
     */
    public static Claims getClaims(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        // 解析 Token
        Claims claims = Jwts.parser().setSigningKey(secretPublicKey).parseClaimsJws(token).getBody();
        return claims;
    }

    /**
     * 通过JWT 获取用户用信息
     */
    public static String getJwtJson(String token) {
        Claims claims = getClaims(token);
        if (claims != null) {
            return claims.getSubject();
        }
        return null;
    }

    private static PrivateKey getPrivateKey(String privateKey)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] privateKeyBytes = Base64.getMimeDecoder().decode(privateKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        return keyFactory.generatePrivate(privateKeySpec);
    }

    private static PublicKey getPublicKey(String puKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] publicKeyBytes = Base64.getMimeDecoder().decode(puKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }
}
