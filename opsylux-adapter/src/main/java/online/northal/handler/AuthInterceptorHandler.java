package online.northal.handler;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import online.northal.domain.entity.SysUser;
import online.northal.exception.UnauthorizedException;
import online.northal.utils.JwtUtil;
import online.northal.utils.RedisCache;
import online.northal.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class AuthInterceptorHandler implements HandlerInterceptor {
    @Autowired
    private RedisCache redisCache;

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${jwt.header}")
    private String header;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 放行 OPTIONS 请求
        if ("OPTIONS".equals(request.getMethod())) {
            return true;
        }

        // 打印当前配置的header值以便调试
        log.info("配置的header名称: {}", this.header);

        // 尝试从配置的header获取token
        String token = request.getHeader(this.header);
        log.info("从{}获取的token: {}", this.header, token);

        // 如果配置的header获取不到，尝试从标准的"Authorization"获取
        if (token == null && !this.header.equals("Authorization")) {
            token = request.getHeader("Authorization");
            log.info("从标准Authorization获取的token: {}", token);
        }

        if (token == null || !token.startsWith("Bearer ")) {
            throw new UnauthorizedException("用户未登录，请前往登录");
        }

        token = token.replace("Bearer ", "");
        Claims claims = this.jwtUtil.parseToken(token);
        if (claims == null || jwtUtil.isTokenExpired(token)) {
            throw new UnauthorizedException("登录已过期，请重新登录");
        }

        String username = claims.get("username").toString();
        String userId = claims.get("userId").toString();
        SysUser user = new SysUser();
        user.setId(Long.valueOf(userId));
        user.setUsername(username);
        UserHolder.set(user);

//        TODO: Redis token验证

        return true;
    }
}
