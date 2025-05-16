package online.northal.handler;

import io.jsonwebtoken.Claims;
import online.northal.exception.UnauthorizedException;
import online.northal.utils.JwtUtil;
import online.northal.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        String token = request.getHeader(this.header);
        if (token == null || !token.startsWith("Bearer ")) {
            throw new UnauthorizedException("用户未登录，请前往登录");
        }

        token = token.replace("Bearer ", "");
        Claims claims = this.jwtUtil.parseToken(token);
        if (claims == null || jwtUtil.isTokenExpired(token)) {
            throw new UnauthorizedException("登录已过期，请重新登录");
        }

        String username = claims.get("userId").toString();
        request.setAttribute("username", username);

//        TODO: Redis token验证

        return true;
    }
}
