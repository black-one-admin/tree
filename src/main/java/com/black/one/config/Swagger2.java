package com.black.one.config;


import com.black.one.annotations.SwhAnnotation;
import com.black.one.annotations.SystemClassAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Scope(value="singleton")表示作用域为单例模式
 * @Classname Swagger2
 * @Description swagger自定义配置
 * @Date 2019-03-14 23:01
 * @Created by fengjingxing
 */
@Configuration
@EnableSwagger2
@Scope(value="singleton")
public class Swagger2 {

    private final static String ACCESS_TOKEN_KEY="access_token";
    public static void main(String[] args) {
                 SpringApplication.run(Swagger2.class, args);
    }


    private void sys(List<Parameter> pars){

        String ACCESS_TOKEN_Value="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyU3RhdHVzIjoiMSIsImxvZ2luVHlwZSI6MSwidXNlcl9uYW1lIjoi6IOh5Y2O6IuXIiwidXNlclR5cGVJbmZvcyI6W3sidXNlclR5cGVJZCI6IjUiLCJjb21tb25UeXBlIjoiNSIsInN5c3RlbVR5cGUiOiIzIiwic3RhdHVzIjoiMSJ9XSwidXNlck5hbWUiOiLog6HljY7oi5ciLCJ1c2VySWQiOiJGNDVCQzE3MTk1Mzg0REMzQUE2QjM2OTgyNUI4NUI0OSIsImNsaWVudF9pZCI6ImdwLWdhdGV3YXktY2VudGVyIiwiYXVkIjpbIkFMTCJdLCJpZGVudGl0eVR5cGUiOjEsInVzZXJBY2NvdW50Ijoi6IOh5Y2O6IuXIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sInN5c3RlbVR5cGUiOiIzIiwidXNlclR5cGVOb3ciOiI1IiwiZXhwIjoxNTg2NDE0MDc0LCJqdGkiOiIxNGFmZDQyMC0yYWY3LTQ0ZDEtODE0Zi0wNzM2MzZmNzY3MTIifQ.MFT1AR24POftK38M5vK8MgLE5ZhTJRtoPco5Zh9eWn_Z7zNhsFYo5kd1KU0I1TUiow7iSdLv55fDR_LNnRMvlGWfm5jEH8_Gnr5dqyjJ-fx05T5DngtyltiLFasSfgFY2-r0m4Dg0yPyPRsaz4934NTS3KGoXMdeFrVl2aP1rStfL18VXwhkHEbWUmNsDRXHeswGfkJQ6sHS5RT0wJOM9lbHNezN2lqQ9-PZQaAC5h_vyqYHYa025sMBEiAe6zOrUkCuw323mWZg11L2Q0GU6ZjzUUIdVVUwa2anpGqLcsb1zgVZxmGvlYu33L0T_2nU6jyLKbHGua4vfZR0z6PztA";


       ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name(ACCESS_TOKEN_KEY).defaultValue(ACCESS_TOKEN_Value)
                .description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true).
                build();
        pars.add(tokenPar.build());
    }

    @Bean
    public Docket webAPI(){
        List<Parameter> pars = new ArrayList<Parameter>();
        this.sys(pars);
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("GPMS API interface document")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(SystemClassAnnotation.class))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Building RESTful APIs with Swagger 2 in GPMS")
                .termsOfServiceUrl("http://localhost/")
                .contact(new Contact("系统参数","", ""))
                .version("1.0")
                .description("Deployment information")
                .build();
    }


    @Bean
    public Docket webAPISwh(){
        List<Parameter> pars = new ArrayList<Parameter>();
        this.sys(pars);
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("分组")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(SwhAnnotation.class))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .apiInfo(apiInfoSwh());
    }


    private ApiInfo apiInfoSwh(){
        return new ApiInfoBuilder()
                .title("Swh分组")
                .termsOfServiceUrl("http://localhost/")
                .contact(new Contact("Swh分组","", ""))
                .version("1.0")
                .description("Swh分组")
                .build();
    }
}
