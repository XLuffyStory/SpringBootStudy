The SpringBootTestStudy is mainly to demo sample for a Controller Test.

And use the below 2 annotation for the test class with the latest spring boot.

@RunWith(SpringRunner.class)
@SpringBootTest


--The code is checked from book <Spring boot 实战 - 【汪云飞】>
==========================================================================
package com.app;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Transactional // 确保每次测试后的数据将会被回滚
@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {
	@Autowired
	PersonRepository personRepository;

	MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	String expectedJson;

	@Before
	public void setUp() throws JsonProcessingException {
		Person p1 = new Person("aaa");
		Person p2 = new Person("bbb");
		personRepository.save(p1);
		personRepository.save(p2);

		expectedJson = Obj2Json(personRepository.findAll());
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}

	protected String Obj2Json(Object obj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}

	@Test
	public void testPersonController() throws Exception {
		String uri = "/person";
		// 获得request的执行结果
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();

		Assert.assertEquals("错误，正确的返回值为200", 200, status);
		Assert.assertEquals("错误，返回值和预期返回值不一致", expectedJson, content);
	}

}
