package com.janakerman.service

import com.janakerman.entity.Person
import com.janakerman.repository.PersonRepository
import com.janakerman.repository.RoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository
    private final RoleRepository roleRepository
    private final BCryptPasswordEncoder encoder

    @Autowired
    PersonServiceImpl(PersonRepository personRepository, RoleRepository roleRepository, BCryptPasswordEncoder encoder) {
        this.personRepository = personRepository
        this.roleRepository = roleRepository
        this.encoder = encoder
    }

    @Override
    @Transactional(readOnly = true)
    Person getPerson(Integer id) { personRepository.findOne id }

    @Override
    Person getPerson(String username) { personRepository.findByUsername username}

    @Override
    @Transactional
    Person create(Person person) {
        person.setPassword(encoder.encode(person.getPassword()))
        person.setRoles(new HashSet<>(roleRepository.findAll()))
        personRepository.saveAndFlush(person)
    }

}
