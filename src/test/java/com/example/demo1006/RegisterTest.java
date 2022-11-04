package com.example.demo1006;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo1006.entity.Register;
import com.example.demo1006.repository.RegisterDao;
import com.example.demo1006.service.ifs.RegisterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.Result;

@WebAppConfiguration
@SpringBootTest(classes = Demo1006Application.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RegisterTest {

	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

	@Autowired
//	mockMvc是基於 WebApplicationContext 所建立的物件，可以來編寫web應用的整合測試
	private WebApplicationContext wac;

//	實現對HTTP請求的模擬，主要是用來測試controller
	private MockMvc mockMvc;

	@BeforeAll
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Autowired
	private RegisterService registerService;

	@Autowired
	private RegisterDao registerDao;

	@SuppressWarnings("unchecked")
	@Test
	public void registerControllerTest() throws Exception {
//		如果 headers 要加的參數有多個，可使用下列方式
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

//		set request body
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("account", "A99");
		map.put("pwd", "123456");
		map.put("name", "Anna");
		map.put("age", 20);
		map.put("city", "Tainan");

//		map to string
		ObjectMapper objectMapper = new ObjectMapper();
		String mapString = objectMapper.writeValueAsString(map);

		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/register")
//				.headers(headers) 
				.contentType(CONTENT_TYPE)// headers 要加的參數只有CONTENT_TYPE 時可直接使用，無須透過headers加入。
				.content(mapString)); // 放在 mockMvc.content 的內容需要的是字串，所以先在上面轉成字串

//		get response && 將 response 內容轉成字串
		String resString = result.andReturn().getResponse().getContentAsString();

//		得到的 response 字串轉成 Json(map)
		JacksonJsonParser jsonParser = new JacksonJsonParser();
		Map<String, Object> resData = jsonParser.parseMap(resString);// parseMap
		String rtnMessage = (String) resData.get("message"); // get key 取得value(Object)
		Assert.isTrue(rtnMessage.equalsIgnoreCase("SUCCESSFULLLL"), "Message error");
//		Assert: 判斷布林值的結果是否和預期的一樣，如果一樣就正常執行，否則會拋出AssertionError
		Map<String, Object> rtnInfo = (Map<String, Object>) resData.get("register_info");
		Assert.isTrue(((String) rtnInfo.get("account")).equals("A99"), "Account error!");

		System.out.println(resData);
		registerDao.deleteById("A99");

	}

	@Test
	public void registerTest() {
		Register reg = registerService.register("A99", "123456", "A", 20, "Tainan");
//		Optional<Register> result = registerDao.findById("A01");
//		
//		if(reg.isPresent()) {
//		}

//		if(registerDao.existsById("A01")) {
//		}
//		一般都是用上面兩種方法，但在unitest是用下面的方法
//		Assert.notNull(reg, "這是空值!");
		Assert.isTrue(reg.getAccount().equalsIgnoreCase("A99"), "Account error!");
		registerDao.delete(reg);
//		
		Assert.isTrue(!registerDao.findById("A99").isPresent(), "不是空!");
		Assert.isTrue(!registerDao.existsById("A99"), "不是空!");
//		以上兩種方法選一種寫就好
		System.out.println("register test");

	}

	@Test
	public void activeAccount() {
		// 創建帳號
		Register reg = registerService.register("A99", "0000000", "A", 0, "Taiwan");
		Assert.isTrue(!reg.isActive(), "Account is active!");// reg.isActive() == false
		// 預設為false
//		如果參數的狀態為真則回傳後面訊息(未被激活是真的)
//		Assert.isTrue: 判斷第一個參數是否為真，如果結果不是想要的結果 則回傳後面訊息
		registerService.activeAccount("A99");

		Register newReg = registerDao.findById("A99").get();
		Assert.isTrue(newReg.isActive(), "Account is inactive!");// newReg.isActive() == ture
		registerDao.delete(newReg);

		System.out.println("active account!");
	}

	@Test
	public void addRoleTest() {
		List<String> roleList = new ArrayList<>();
		roleList.add("as");
		roleList.add("sd");
		roleList.add("sd");
		roleList.add("as");
		registerService.addRole("A02", roleList);

		System.out.println("role test!");
	}

	@SuppressWarnings("unchecked")
	@Test
	public void addRoleListControllerTest() throws Exception {
//		如果 headers 要加的參數有多個，可使用下列方式
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

//		set request body
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> roleList = new ArrayList<String>();
		roleList.add("AAA");
		roleList.add("BBB");
		map.put("account", "A02");
		map.put("role_list", roleList);

//		map to string
		ObjectMapper objectMapper = new ObjectMapper();
		String mapString = objectMapper.writeValueAsString(map);

		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/add_role_list")
//				.headers(headers) 
				.contentType(CONTENT_TYPE)// headers 要加的參數只有CONTENT_TYPE 時可直接使用，無須透過headers加入。
				.content(mapString)); // 放在 mockMvc.content 的內容需要的是字串，所以先在上面轉成字串

//		get response && 將 response 內容轉成字串
		String resString = result.andReturn().getResponse().getContentAsString();

//		得到的 response 字串轉成 Json(map)
		JacksonJsonParser jsonParser = new JacksonJsonParser();
		Map<String, Object> resData = jsonParser.parseMap(resString);// parseMap
		String rtnMessage = (String) resData.get("message"); // get key 取得value(Object)
		Assert.isTrue(rtnMessage.equalsIgnoreCase("SUCCESSFULLLL"), "Message error!");

		System.out.println(resData);

	}

}
