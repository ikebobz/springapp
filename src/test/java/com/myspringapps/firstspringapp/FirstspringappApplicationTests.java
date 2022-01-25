package com.myspringapps.firstspringapp;

import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

//import org.aspectj.lang.annotation.Before;
import org.junit.Before;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class FirstspringappApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private MockMvc mvc;

	@Autowired
	private EmployeeRepository er;

	@Before
	public void pretests() throws Exception
	{
		//Stream.of(new String[]{"Freddy","Quimby","TX","+111789","fq@warnerbros.com","male"},new String[]{"ken","rogers","NJ","+23456234","krogers@outlook.com","male"}).forEach(d -> er.save(new Employee(d)));
	}
	@Test
	public void EmployeeReflectedInRead() throws ExecutionException{
		//MediaType haljson = MediaType.parseMediaType("application/hal+json;charset=UTF-8");
	    //this.mvc.perform(MockMvcRequestBuilders.get("/employees"));
	}

}
