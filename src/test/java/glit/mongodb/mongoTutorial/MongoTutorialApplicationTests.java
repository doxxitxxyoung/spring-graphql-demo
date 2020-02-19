package glit.mongodb.mongoTutorial;

import glit.mongodb.mongoTutorial.controller.DrugController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import javax.swing.*;

import static org.hamcrest.Matchers.*;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
class MongoTutorialApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}
}

	/*
	Drug controller

    @GetMapping(value = "/")
    @GetMapping(value = "/byId/{id}")
    @GetMapping(value = "/byDrugname/{drugname}")

	Sample Controller

    @GetMapping(value = "/")
    @GetMapping(value = "/byId/{id}")
    @GetMapping(value= "byDrugname/{drugname}")
	 */

