package online.northal.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

@Slf4j
@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expire}")
    private long expire;

    private SecretKey key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }


    /**
     * 生成 token
     */
    public String generateToken(Long userId, String username) {

        log.info("secretKeyString: {}", this.secret);
        log.info("expirationTime: {}", this.expire);
//        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        log.info("key: {}", this.key);
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expire);

        return Jwts.builder()
                .issuer("North") // 发行人
                .subject(userId.toString()) // 主题
                .issuedAt(now) // 签发时间
                .expiration(expiryDate) // 过期时间
                .claim("username", username)
                .claim("userId", userId) // 自定义字段
                .signWith(key) // 签名算法和密钥
                .compact(); // 生成 token
    }

    /**
     * 解析 token
     */
    public Claims parseToken(String token) {
        try {
           return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
        } catch (Exception e) {
            // 解析失败，可能是 token 已过期或无效
            return null;
        }
    }


    /**
     * @param token token
     * @return 是否过期
     * */
    public boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getExpiration();
        return expiration.before(new Date());
    }
}
