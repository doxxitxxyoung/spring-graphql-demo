package glit.mongodb.mongoTutorial.service;

import glit.mongodb.mongoTutorial.model.Drugs;

import java.util.List;
import java.util.Optional;

public interface DrugService {
    List<Drugs> findAll();

    Optional<Drugs> findById(String id);

    Drugs findByDrugname(String drugname);

}
