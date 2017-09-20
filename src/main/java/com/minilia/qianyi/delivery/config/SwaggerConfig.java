package com.minilia.qianyi.delivery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.google.common.base.Predicates.not;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;

/**
 * @author qianyi
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket merchantStoreApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("internal-api")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                .paths(or(regex("/api/.*")))
                .build()
                .apiInfo(testApiInfo());
    }


    private ApiInfo testApiInfo() {
        ApiInfo apiInfo = new ApiInfo("快递鸟项目",//大标题
                "快递鸟物流",//小标题
                "0.1",//版本
                "NO terms of service",
                "qianyi.com",//作者
                "The Apache License, Version 2.0",//链接显示文字
                "www.qiany.com"//网站链接
        );

        return apiInfo;
    }

}
