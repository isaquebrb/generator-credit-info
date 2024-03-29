package br.com.isaquebrb.iftm.generatorcreditinfo.config;

import br.com.isaquebrb.iftm.generatorcreditinfo.controller.CrednetController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    private static final String CONTROLLERS_PACKAGE = CrednetController.class.getPackageName();

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CONTROLLERS_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }
}
