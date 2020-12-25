package com.yitao.notice.config;

import com.google.common.base.Predicates;
import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    private static String SWAGGER_BASE_PACKAGE = "com.yitao";

    /**
     * 创建docket
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .produces(Sets.newHashSet("application/json;charset=UTF-8"))
                .consumes(Sets.newHashSet("application/json;charset=UTF-8"))
                .protocols(Sets.newHashSet("http", "https"))
                .forCodeGeneration(true)
                .apiInfo(this.apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_BASE_PACKAGE))
                .paths(Predicates.not(PathSelectors.regex("/error.*"))).build();
    }

    /**
     * 构建 api文档的详细信息函数
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("逸淘一键下单RESTful API")
                //条款地址
                .version("1.0")
                .contact(new Contact("山东逸淘软件", "http://www.yitao.com", "admin@yitao.com"))
                //描述
                .description("一键下单api")
                .build();
    }

}
