package glit.mongodb.mongoTutorial.controller;

import glit.mongodb.mongoTutorial.model.Samples;
import glit.mongodb.mongoTutorial.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/samples")
public class SampleController {

    /*
    @Autowired
    private SampleService sampleService;
     */

    private final SampleService sampleService;
    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping(value = "/")
    public List<Samples> getAllSamples() {
        return sampleService.findAll();
    }

    @GetMapping(value = "/byId/{id}")
    public Optional<Samples> getSampleById(@PathVariable("id") String id) {
        return sampleService.findById(id);
    }

    @GetMapping(value= "byDrugname/{drugname}")
    public List<Samples> getSampleByDrugname(@PathVariable("drugname") String drugname) {
        return sampleService.findByDrugname(drugname);
    }

}
