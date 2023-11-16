package dev.izmir.jpapagination.repository;

import dev.izmir.jpapagination.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {
}
