package com.huan.study.configuration;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2 文档
 *
 * @author huan.fu
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(path -> true)
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("product-商品提供者")
				.description("spring cloud学习")
				.termsOfServiceUrl("https://gitee.com/huan1993/spring-cloud-parent")
				.contact(new Contact("huan.fu", "", "1451578387@qq.com"))
				.version("0.0.1")
				.build();
	}
}