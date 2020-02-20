package glit.mongodb.mongoTutorial.controller;

import glit.mongodb.mongoTutorial.model.Drugs;
import glit.mongodb.mongoTutorial.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drugs")
public class DrugController {
    /*
    @Autowired
    private DrugService drugService;
     */

    private final DrugService drugService;
    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping(value = "/")
    public List<Drugs> getAllDrugs(){
            return drugService.findAll();
    }


    @GetMapping(value = "/byId/{id}")
    public Optional<Drugs> getDrugById(@PathVariable("id") String id) {
        return drugService.findById(id);
    }

    @GetMapping(value = "/byDrugname/{drugname}")
//    public Drugs getDrugByDrugname(@PathVariable("drugname") String drugname) {
    public List<Drugs> getDrugByDrugname(@PathVariable("drugname") String drugname) {
        return drugService.findByDrugname(drugname);
    }

}
