package glit.mongodb.mongoTutorial;

import glit.mongodb.mongoTutorial.model.Drugs;
import glit.mongodb.mongoTutorial.model.Samples;
import glit.mongodb.mongoTutorial.repository.DrugRepository;
import glit.mongodb.mongoTutorial.repository.SampleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@DataMongoTest
public class SpringBootMongodbAppTest {
    @Autowired
    DrugRepository drugRepository;
    SampleRepository sampleRepository;

    @Test
    public void findDrugs() {
        List<Drugs> drugs = drugRepository.findAll();
        System.out.println(drugs);
    }

    @Test
    public void findSamples() {
        List<Samples> samples = sampleRepository.findAll();
        System.out.println(samples.size());
    }

    @Test
    public void findDrugByDrugname() {
        List<Drugs> drug = drugRepository.findByDrugname("albendazole");
        System.out.println(drug);
        assertFalse(drug.isEmpty());
        Assert.assertEquals(drug.get(0).getSmiles().toString(), is(equalTo("CCCSC1=CC2=C(C=C1)N=C(N2)NC(=O)OC")));
    }

    @Test
    public void findDrugById() {
        Optional<Drugs> drug = drugRepository.findById("5e29424930b8214d01b272e4");
//        Assert.assertEquals(drug, is());
        System.out.println(drug);
        Assert.assertTrue(drug.isPresent());
        Assert.assertThat(drug.get().getDrugname().toString(), is(equalTo("albendazole")));
    }
}
