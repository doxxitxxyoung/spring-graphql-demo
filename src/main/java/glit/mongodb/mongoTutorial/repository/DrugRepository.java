package glit.mongodb.mongoTutorial.repository;

import glit.mongodb.mongoTutorial.model.Drugs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DrugRepository extends MongoRepository<Drugs, String> {
    List<Drugs> findAll();

    Optional<Drugs> findById(String id);

    Drugs findByDrugname(String drugname);
}

