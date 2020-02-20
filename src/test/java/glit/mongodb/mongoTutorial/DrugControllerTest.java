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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
        MvcResult res = mockMvc.perform(get("/drugs/byId/5e29424930b8214d01b27481"))

                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.drugname",
                        is("irbesartan")))
                .andReturn();

//        String content = res.getResponse().getContentAsString();
//        System.out.println(content);
    }

    @Test
    public void getDrugByDrugname() throws Exception {
        mockMvc.perform(get("/drugs/byDrugname/irbesartan"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].smiles",
                        is("CCCCC1=NC2(CCCC2)C(=O)N1CC3=CC=C(C=C3)C4=CC=CC=C4C5=NNN=N5")));
    }

    @Test
    public void getSampleById() throws Exception {
        mockMvc.perform(get("/samples/byId/5e29424930b8214d01b272e3"))
                .andExpect((status().isOk()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.drugname",
                        is("alaproclate")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cellline",
                        is("A375")));
    }

    @Test
    public void getSampleByDrugname() throws Exception {
        mockMvc.perform(get("/samples/byDrugname/alaproclate"))
                .andExpect((status().isOk()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].smiles",
                        is("CC(C(=O)OC(C)(C)CC1=CC=C(C=C1)Cl)N")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cellline",
                        is("A375")));
    }
    /*
    @Test
    public void getDrugById() throws Exception {
        mockMvc.perform(get("/drugs/byId/5e293d961012a618095f9965"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$[0]['drugname']", is(equalTo("diphenhydramine"))));

//                .andExpect((ResultMatcher) content().contentType(APPLICATION_JSON));
                .andExpect((ResultMatcher) jsonPath("$", iterableWithSize(1)))

                .andExpect((ResultMatcher) jsonPath("$[0]['drugname']", is(equalTo("diphenhydramine"))));
    }
     */

    //  Ref: https://stackoverflow.com/questions/18336277/how-to-check-string-in-response-body-with-mockmvc


    /*
    //  Ref: https://cnpnote.tistory.com/entry/SPRING-mockMvc%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC-%EC%9D%91%EB%8B%B5-%EB%B3%B8%EB%AC%B8%EC%97%90%EC%84%9C-JSON%EC%9D%84-%ED%99%95%EC%9D%B8%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95
    @Test
    public void getDrugById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/drugs/byId/5e293d961012a618095f9965"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":1, "flavor":"Butterscotch"}")

        )
    }
    */



}

/*
//  Ref: https://stackoverflow.com/questions/43691094/spring-boot-integration-test-responding-with-empty-body-mockmvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SearchService service;

    @Before
    public void setUp(){
        when(service.someMethod(any()))
                .thenReturn(SomeResponse);
    }

    @Test
    public void getSearchResults() throws Exception{
        //this.mockMvc.perform(get("/something/search").header("header1","1").header("header2","2")
        mockMvc.perform(get("/drugs/byId/5e293d961012a618095f9965"))
                .andExpect(status().isOk())
                .andDo(mvcResult -> {
                   sys
                });

                /*
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(mvcResult -> {
                    //Verrify Response here
                });
    }
}
*/



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