package glit.mongodb.mongoTutorial.unitTest;

import glit.mongodb.mongoTutorial.model.Drugs;
import glit.mongodb.mongoTutorial.repository.DrugRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootApplication()
public class DrugRepositoryTest {
    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void saveAndSearch() throws Exception {
        Drugs drug = new Drugs("drugname", 1, "smiles");
        drugRepository.save(drug);
        assertEquals(drug, drugRepository.findByDrugname("drugname"));
        drugRepository.delete(drug);
    }

}
