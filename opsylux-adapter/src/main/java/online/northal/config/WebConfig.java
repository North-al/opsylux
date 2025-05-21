package online.northal.config;

import online.northal.handler.AuthInterceptorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private AuthInterceptorHandler authInterceptorHandler;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 所有接口都支持跨域
                .allowedOriginPatterns("*") // 支持任意域名
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 支持的方法
                .allowedHeaders("*") // 支持的请求头
                .allowCredentials(true) // 允许携带 cookie
                .maxAge(3600); // 预检请求的缓存时间（秒）

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptorHandler)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/login",
                        "/register",
                        "/docs/**",
                        "/swagger-ui/**",
                        "/error"
                ); // 排除不需要拦截的路径
    }
}
