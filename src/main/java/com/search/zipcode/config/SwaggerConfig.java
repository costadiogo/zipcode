package com.search.zipcode.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

    @Configuration
    @EnableSwagger2
    public class SwaggerConfig {

        @Bean
        public Docket userApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.any())
                    .build()
                    .apiInfo(metaInfo());
        }

        private ApiInfo metaInfo() {
            ApiInfo apiInfo = new ApiInfo(
                    "Ceps Api",
                    "Api Cep Search ",
                    "1.0",
                    "Terms of Service",
                    new Contact("Diogo Costa", "https://www.linkedin.com/in/diogo-costa-8138a69b",
                            "costadiogo30@gmail.com"),
                    "Apache License Version 2.0", " http://www.apache.org/licenses",
                    new ArrayList<VendorExtension>()
            );
            return apiInfo;
        }

        protected void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("swagger-ui.html")
                    .addResourceLocations("classpath:/META-INF/resources/");

            registry.addResourceHandler("/webjars/**")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
    }

