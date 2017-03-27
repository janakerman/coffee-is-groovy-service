package com.janakerman.service

import com.janakerman.auth.SecurityService
import com.janakerman.entity.Person
import com.janakerman.repository.PersonRepository
import com.janakerman.repository.RoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository
    private final RoleRepository roleRepository
    private final PasswordEncoder encoder
    private final SecurityService securityService

    @Autowired
    PersonServiceImpl(PersonRepository personRepository, RoleRepository roleRepository,
                      PasswordEncoder encoder, SecurityService securityService) {
        this.personRepository = personRepository
        this.roleRepository = roleRepository
        this.encoder = encoder
        this.securityService = securityService
    }

    @Override
    Person getCurrent() {
        def username = securityService.findLoggedInUsername()
        getPerson username
    }

    @Override
    @Transactional(readOnly = true)
    Person getPerson(Integer id) { personRepository.findOne id }

    @Override
    @Transactional(readOnly = true)
    Person getPerson(String username) { personRepository.findByUsername username}

    @Override
    @Transactional
    Person create(Person person) {
        person.setPassword(encoder.encode(person.getPassword()))
        person.setRoles(new HashSet<>(roleRepository.findAll()))
        personRepository.saveAndFlush(person)
    }

}
