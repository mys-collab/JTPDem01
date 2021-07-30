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
    public static final String TAG_4 = "订单信息接口";
    public static final String TAG_5 = "用户信息接口";


    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select()
                // 要扫描的API(Controller)基础包
                .apis(RequestHandlerSelectors.basePackage("com.jtp7.demo"))
                .paths(PathSelectors.any())
                .build().tags(new Tag(TAG_1,"司机信息接口"),new Tag(TAG_4,"订单信息接口"),new Tag(TAG_5,"用户信息接口"));
    }

    /**
     * @param
     * @return springfox.documentation.service.ApiInfo
     * @Title: 构建API基本信息
     * @methodName: buildApiInfo
     */
    private ApiInfo buildApiInfo() {
        Contact contact = new Contact("JTP全体19","127.0.0.1","2077618466@qq.com");
        return new ApiInfoBuilder()
                .title("订单管理API文档")
                .description("记录公司的司机信息、卡车信息、订单信息，油费报销审批，并根据司机的订单查看其月度的工作报表，计算薪酬记录公司的司机信息、" +
                        "卡车信息、订单信息，油费报销审批，并根据司机的订单查看其月度的工作报表，计算薪酬, 注意测试需要,权限,可以注释掉权限模块或者放行自己写的方法")
                .contact(contact)
                .version("0.0.2").build();
    }

}
