package com.jtp7.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "swagger",value = {"enable"},havingValue = "true")
public class SwaggerConfiguration {

    public static final String TAG_1 = "司机信息接口";
    public static final String TAG_2 = "报销申请信息接口";
    public static final String TAG_3 = "卡车信息接口";

    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select()
                // 要扫描的API(Controller)基础包
                .apis(RequestHandlerSelectors.basePackage("com.jtp7.demo"))
                .paths(PathSelectors.any())
                .build().tags(new Tag(TAG_1,"司机信息接口"),new Tag(TAG_2,TAG_2),new Tag(TAG_3,TAG_3));
    }

    /**
     * @param
     * @return springfox.documentation.service.ApiInfo
     * @Title: 构建API基本信息
     * @methodName: buildApiInfo
     */
    private ApiInfo buildApiInfo() {
        Contact contact = new Contact("开发者","","2077618466@qq.com");
        return new ApiInfoBuilder()
                .title("订单管理API文档")
                .description("")
                .contact(contact)
                .version("1.0.0").build();
    }

}
