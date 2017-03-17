package com.janakerman.service

import com.janakerman.entity.Person
import com.janakerman.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository

    @Override
    @Transactional
    Person getPerson(Integer id) { personRepository.findOne id }

    @Override
    @Transactional
    Person create(Person person) { personRepository.saveAndFlush(person)}
}
