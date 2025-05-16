package online.northal.config;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    private static final String SECURITY_SCHEME_NAME = "bearerAuth";

    @Value("${jwt.header}")
    private String jwtHeader;

    /**
     * 全局 API 基础信息
     */
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
                        .url("https://github.com/Northal/opsylux")
                )
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(new Components().addSecuritySchemes(SECURITY_SCHEME_NAME,
                                new SecurityScheme()
                                        .name(jwtHeader)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                );
    }

    /**
     * 全局添加请求头 Authorization 参数
     */
    @Bean
    public OpenApiCustomiser globalHeaderOpenApiCustomiser() {
        return openApi -> openApi.getPaths().values().forEach(pathItem ->
                pathItem.readOperations().forEach(operation -> {
                    Parameter authHeader = new Parameter()
                            .in(ParameterIn.HEADER.toString())
                            .required(false)
                            .name("Authorization")
                            .description("JWT Token")
                            .example("Bearer xxxxxxxx")
                            .schema(new io.swagger.v3.oas.models.media.StringSchema());
                    operation.addParametersItem(authHeader);
                }));
    }
}
