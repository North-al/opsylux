package online.northal.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    /** 全局 API 基础信息 */
    @Bean
    public OpenAPI opsyluxOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Opsylux 管理后台 API")
                        .description("咖啡店后台管理系统接口文档")
                        .version("v1.0.0")
                        .contact(new Contact().name("North").email("north_al@163.com"))
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("项目仓库")
                        .url("https://github.com/Northal/opsylux"));
    }
}
