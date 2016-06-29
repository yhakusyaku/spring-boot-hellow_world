package yhakusyaku.sample.controller;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import yhakusyaku.sample.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@WithMockUser(username = "user", roles = "USER")
public class HelloControllerTest {

	@Rule
	public final MockitoRule		rule	= MockitoJUnit.rule();

	private MockMvc					mockMvc;

	@Autowired
	private WebApplicationContext	context;

	@InjectMocks
	private HelloController			controller;

	@Before
	public void before() {
		this.mockMvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
	}

	@Test
	public void アプリケーションルートアクセス() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.model().hasNoErrors())
				.andExpect(MockMvcResultMatchers.view().name("index"))
				.andExpect(MockMvcResultMatchers.model().attribute("message", "Hello Spring Boot!!"));
	}

}
