package com.janakerman.service

import com.janakerman.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserCredentialsService implements UserDetailsService {

    private final PersonRepository personRepository

    @Autowired
    UserCredentialsService(PersonRepository personRepository) {
        this.personRepository = personRepository
    }

    @Override
    @Transactional(readOnly = true)
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        def person = personRepository.findByUsername(username)

        if (person == null) {
            throw new UsernameNotFoundException("Username $username not found.")
        }

        return new User(person.getUsername(), person.getPassword(), [new SimpleGrantedAuthority('user')])
    }

}
