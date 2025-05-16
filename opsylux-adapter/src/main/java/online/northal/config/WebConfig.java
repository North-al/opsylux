package online.northal.config;

import online.northal.handler.AuthInterceptorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private AuthInterceptorHandler authInterceptorHandler;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptorHandler)
                .excludePathPatterns("/auth/login", "/docs/**") // 放行登录接口
                .addPathPatterns("/**");
    }
}
