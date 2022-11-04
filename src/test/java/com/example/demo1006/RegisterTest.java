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
//	mockMvc�O��� WebApplicationContext �ҫإߪ�����A�i�H�ӽs�gweb���Ϊ���X����
	private WebApplicationContext wac;

//	��{��HTTP�ШD�������A�D�n�O�ΨӴ���controller
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
//		�p�G headers �n�[���ѼƦ��h�ӡA�i�ϥΤU�C�覡
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
				.contentType(CONTENT_TYPE)// headers �n�[���Ѽƥu��CONTENT_TYPE �ɥi�����ϥΡA�L���z�Lheaders�[�J�C
				.content(mapString)); // ��b mockMvc.content �����e�ݭn���O�r��A�ҥH���b�W���ন�r��

//		get response && �N response ���e�ন�r��
		String resString = result.andReturn().getResponse().getContentAsString();

//		�o�쪺 response �r���ন Json(map)
		JacksonJsonParser jsonParser = new JacksonJsonParser();
		Map<String, Object> resData = jsonParser.parseMap(resString);// parseMap
		String rtnMessage = (String) resData.get("message"); // get key ���ovalue(Object)
		Assert.isTrue(rtnMessage.equalsIgnoreCase("SUCCESSFULLLL"), "Message error");
//		Assert: �P�_���L�Ȫ����G�O�_�M�w�����@�ˡA�p�G�@�˴N���`����A�_�h�|�ߥXAssertionError
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
//		�@�볣�O�ΤW����ؤ�k�A���bunitest�O�ΤU������k
//		Assert.notNull(reg, "�o�O�ŭ�!");
		Assert.isTrue(reg.getAccount().equalsIgnoreCase("A99"), "Account error!");
		registerDao.delete(reg);
//		
		Assert.isTrue(!registerDao.findById("A99").isPresent(), "���O��!");
		Assert.isTrue(!registerDao.existsById("A99"), "���O��!");
//		�H�W��ؤ�k��@�ؼg�N�n
		System.out.println("register test");

	}

	@Test
	public void activeAccount() {
		// �Ыرb��
		Register reg = registerService.register("A99", "0000000", "A", 0, "Taiwan");
		Assert.isTrue(!reg.isActive(), "Account is active!");// reg.isActive() == false
		// �w�]��false
//		�p�G�Ѽƪ����A���u�h�^�ǫ᭱�T��(���Q�E���O�u��)
//		Assert.isTrue: �P�_�Ĥ@�ӰѼƬO�_���u�A�p�G���G���O�Q�n�����G �h�^�ǫ᭱�T��
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
//		�p�G headers �n�[���ѼƦ��h�ӡA�i�ϥΤU�C�覡
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
				.contentType(CONTENT_TYPE)// headers �n�[���Ѽƥu��CONTENT_TYPE �ɥi�����ϥΡA�L���z�Lheaders�[�J�C
				.content(mapString)); // ��b mockMvc.content �����e�ݭn���O�r��A�ҥH���b�W���ন�r��

//		get response && �N response ���e�ন�r��
		String resString = result.andReturn().getResponse().getContentAsString();

//		�o�쪺 response �r���ন Json(map)
		JacksonJsonParser jsonParser = new JacksonJsonParser();
		Map<String, Object> resData = jsonParser.parseMap(resString);// parseMap
		String rtnMessage = (String) resData.get("message"); // get key ���ovalue(Object)
		Assert.isTrue(rtnMessage.equalsIgnoreCase("SUCCESSFULLLL"), "Message error!");

		System.out.println(resData);

	}

}
