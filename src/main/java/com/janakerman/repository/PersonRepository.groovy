package com.janakerman.repository;

import com.janakerman.entity.Person
import com.janakerman.entity.Shop
import org.springframework.stereotype.Repository

import java.util.concurrent.ThreadLocalRandom

/**
 * A repository for Persons.
 * Created by jakerman on 15/03/2017.
 */
@Repository
class PersonRepository implements IRepository<Person>, TRepository<Person> {

    final Map<Integer, Shop> storage = new HashMap<>()

    PersonRepository() {
        this.saveAll(generateMocks())
    }

    private static List<Person> generateMocks() {
        def people = []

        (1..20).each { i ->
            people.add new Person(
                    id: i,
                    firstName: randomFirstName(),
                    lastName: randomLastName()
            )
        }
        return people
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
