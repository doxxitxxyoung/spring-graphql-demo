package glit.mongodb.mongoTutorial.service;

import glit.mongodb.mongoTutorial.model.Drugs;
import glit.mongodb.mongoTutorial.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugRepository drugRepository;

    @Override
    public List<Drugs> findAll() {
        return drugRepository.findAll();
    }

    @Override
    public Optional<Drugs> findById(String id) {
        return drugRepository.findById(id);
    }

    @Override
    public Drugs findByDrugname(String drugname) {
        return drugRepository.findByDrugname(drugname);
    }

}
