package glit.mongodb.mongoTutorial.repository;

import glit.mongodb.mongoTutorial.model.Drugs;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface DrugRepository extends MongoRepository<Drugs, String> {
    List<Drugs> findAll();

    Optional<Drugs> findById(String id);

    Drugs findByDrugname(String drugname);
}

