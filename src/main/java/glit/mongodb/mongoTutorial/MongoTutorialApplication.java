package glit.mongodb.mongoTutorial;

import glit.mongodb.mongoTutorial.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoTutorialApplication.class, args);
	}

}

/*
//	check connection with Atlas DB First
@SpringBootApplication
public class MongoTutorialApplication implements CommandLineRunner {

	@Autowired
	DrugRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MongoTutorialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		listAll();
	}

	public void listAll() {
		System.out.println("Listing data");
		repository.findAll().forEach(u -> System.out.println(u));
		repository.findOne()
	}
}
*/
