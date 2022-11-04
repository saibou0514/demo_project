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

@Configuration // 讓spring 載入該類別設定
@EnableSwagger2 // 啟用 Swagger2.createRest API 函數建立 Docket 的 Bean
public class SwaggerConfig {

	public static final ApiInfo DEFAULT_API_INFO = new ApiInfoBuilder()
			.title("Restful API!")
			.build();

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO) // 顯示API基本之資訊，可不加
				.select() // 回傳一個 ApiSelectorBuilder 實例，用來控制那些介面可給 Swagger 來展現
//				設定套件掃描路徑
//				Swagger 會掃描套件下所有 controller 定義的 API 並產生文件
//				若不想 API 產生相關文建，可在API上加上 @ApiIgnore
				.apis(RequestHandlerSelectors.basePackage("com.example.demo1006.controller"))
				
				
				
				
				.paths(PathSelectors.any())
				.build();
	}

}
