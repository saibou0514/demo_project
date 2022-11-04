package com.example.demo1006.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration // ��spring ���J�����O�]�w
@EnableSwagger2 // �ҥ� Swagger2.createRest API ��ƫإ� Docket �� Bean
public class SwaggerConfig {

	public static final ApiInfo DEFAULT_API_INFO = new ApiInfoBuilder()
			.title("Restful API!")
			.build();

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO) // ���API�򥻤���T�A�i���[
				.select() // �^�Ǥ@�� ApiSelectorBuilder ��ҡA�Ψӱ���Ǥ����i�� Swagger �Ӯi�{
//				�]�w�M�󱽴y���|
//				Swagger �|���y�M��U�Ҧ� controller �w�q�� API �ò��ͤ��
//				�Y���Q API ���ͬ�����ءA�i�bAPI�W�[�W @ApiIgnore
				.apis(RequestHandlerSelectors.basePackage("com.example.demo1006.controller"))
				
				
				
				
				.paths(PathSelectors.any())
				.build();
	}

}
