package com.xiaomi.serverauth.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket merchantStoreApi() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        parameterBuilder.name("token")
                .description("login token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build(); //header中的token参数非必填，传空也可以
        pars.add(parameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("internal-api")
                .genericModelSubstitutes( DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                .apis(RequestHandlerSelectors.any()) // 对所有api进行监控
                .paths(PathSelectors.any()) // 对所有路径进行监控
                .build()
                .globalOperationParameters(pars);
    }

}
