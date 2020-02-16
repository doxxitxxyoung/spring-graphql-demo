package glit.mongodb.mongoTutorial.service;

import glit.mongodb.mongoTutorial.model.Samples;
import glit.mongodb.mongoTutorial.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SampleServiceImpl implements SampleService {
    @Autowired
    private SampleRepository sampleRepository;

    @Override
    public List<Samples> findAll() { return sampleRepository.findAll(); }

    @Override
    public Optional<Samples> findById(String id) { return sampleRepository.findById(id); }

    @Override
    public List<Samples> findByDrugname(String drugname) { return sampleRepository.findByDrugname(drugname); }
}
