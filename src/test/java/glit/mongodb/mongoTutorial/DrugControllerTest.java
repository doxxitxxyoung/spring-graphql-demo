package glit.mongodb.mongoTutorial;

import glit.mongodb.mongoTutorial.controller.DrugController;
//import org.junit.jupiter.api.Test;
import glit.mongodb.mongoTutorial.model.Drugs;
import glit.mongodb.mongoTutorial.model.Samples;
import glit.mongodb.mongoTutorial.service.DrugServiceImpl;
import glit.mongodb.mongoTutorial.service.SampleService;
import glit.mongodb.mongoTutorial.service.SampleServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.springframework.http.MediaType;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//  Ref: https://engkimbs.tistory.com/768
//  Mainly using MockMVC
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class DrugControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void getDrugById() throws Exception {
        mockMvc.perform(get("/drugs/byId/5e293d961012a618095f9965"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON));
                /*
                .andExpect((ResultMatcher) jsonPath("$", iterableWithSize(1)))
                .andExpect((ResultMatcher) jsonPath("$[0]['drugname']", is(equalTo("diphenhydramine"))));

                 */
    }
}

/*
// Ref: https://brunch.co.kr/@springboot/207

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrugControllerTest {

    @Autowired
    private DrugServiceImpl drugService;

    @Test
    public void findDrugByDrugname() {
        Drugs drug = drugService.findByDrugname("diphenhydramine");
        String printed = drug.getDrugname();
        System.out.println(printed);
//        System.out.println(drug.getDrugname());
//        assertEquals(" CN(C)CCOC(C1=CC=CC=C1)C1=CC=CC=C1", drug.getSmiles());
//        assertEquals("diphenhydramine", drug.getDrugname());

    }
}
 */

/*

//	Ref: https://cornswrold.tistory.com/338

@RunWith(SpringRunner.class)
@WebMvcTest(DrugController.class)
public class DrugControllerTest {
	@Autowired
	private MockMvc mockMvc;
	private DrugServiceImpl drugService;

	@Test
	public void getAllDrugs() throws Exception {
		mockMvc.perform(get("/drugs/"))
				.andExpect(status().isOk())
				.andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
				.andExpect((ResultMatcher) jsonPath("$", iterableWithSize(7)))
				.andExpect((ResultMatcher) jsonPath("$[0]['drugname']", is(equalTo("diphenhydramine"))));
	}

	@Test
	public void getDrugById() throws Exception {
		mockMvc.perform(get("/drugs/byId/5e293d961012a618095f9965"))
				.andExpect(status().isOk())
				.andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
				.andExpect((ResultMatcher) jsonPath("$", iterableWithSize(1)))
				.andExpect((ResultMatcher) jsonPath("$[0]['drugname']", is(equalTo("diphenhydramine"))));
	}

	@Test
	public void getDrugByDrugname() throws Exception {
		mockMvc.perform(get("/drugs/byDrugname/Ciprofloxacin"))
				.andExpect(status().isOk())
				.andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
				.andExpect((ResultMatcher) jsonPath("$", iterableWithSize(1)))
				.andExpect((ResultMatcher) jsonPath("$[0]['smiles']", is(equalTo("C1CC1N2C=C(C(=O)C3=CC(=C(C=C32)N4CCNCC4)F)C(=O)O"))));
	}


}
*/