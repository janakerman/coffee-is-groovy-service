package com.janakerman.repository;

import com.janakerman.entity.Person
import org.springframework.stereotype.Repository

import java.util.concurrent.ThreadLocalRandom
import java.util.function.Function
import java.util.stream.Collectors

/**
 * A repository for Persons.
 * Created by jakerman on 15/03/2017.
 */
@Repository
class PersonRepository {

    private Map<Integer, Person> people = generateMocks()

    Person find(Integer id) { people[id] }

    private static Map<Integer, Person> generateMocks() {
        def people = []

        (1..20).each { i ->
            people.add new Person(
                    id: i,
                    firstName: randomFirstName(),
                    lastName: randomLastName()
            )
        }

        return people.stream()
                .collect(Collectors.toMap((Function){ p -> p.getId() }, (Function){ p -> p}))
    }

    private static randomFirstName() {
        def names = [
                "Bill",
                "Bob",
                "Benny",
                "Charlie",
                "Charlotte",
                "Sally",
                "Helen",
                "Tessa"
        ]
        names[ThreadLocalRandom.current().nextInt(0, names.size())]
    }

    private static randomLastName() {
        def names = [
                "Billson",
                "Bobson",
                "Benson",
                "Charson",
                "Salson",
                "Helson",
                "Tesson"
        ]
        names[ThreadLocalRandom.current().nextInt(0, names.size())]
    }
}
