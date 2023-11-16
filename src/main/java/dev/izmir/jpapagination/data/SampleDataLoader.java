package dev.izmir.jpapagination.data;

import com.github.javafaker.Faker;
import dev.izmir.jpapagination.model.Address;
import dev.izmir.jpapagination.model.Person;
import dev.izmir.jpapagination.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private Logger LOGGER = LoggerFactory.getLogger(SampleDataLoader.class);
    private final Faker faker;
    private final PersonRepository personRepository;

    public SampleDataLoader(Faker faker, PersonRepository personRepository) {
        this.faker = faker;
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Loadding Faker...");
        // Create 100 person in database with Faker

        List<Person> people = IntStream.rangeClosed(1, 100)
                .mapToObj(person -> new Person(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.phoneNumber().cellPhone(),
                        faker.internet().emailAddress(),
                        new Address(
                                faker.address().streetAddress(),
                                faker.address().city(),
                                faker.address().state(),
                                faker.address().zipCode()
                        )
                ))
                .toList();
        personRepository.saveAll(people);
    }
}
