package glit.mongodb.mongoTutorial.service;

import glit.mongodb.mongoTutorial.model.Samples;

import java.util.List;
import java.util.Optional;

public interface SampleService {
    List<Samples> findAll();

    Optional<Samples> findById(String id);

    List<Samples> findByDrugname(String drugname);
}
