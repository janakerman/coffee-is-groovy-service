package com.janakerman.entity

import com.janakerman.service.PersonService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.ValidationUtils
import org.springframework.validation.Validator

@Component
class PersonValidator implements Validator {

    private final PersonService personService

    PersonValidator(PersonService personService) {
        this.personService = personService
    }

    @Override
    boolean supports(Class<?> aClass) { Person }

    @Override
    void validate(Object o, Errors errors) {
        def person = (Person)o

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, 'username', 'NotEmpty')
        if (person.getUsername().length() < 6 || person.getUsername().length() > 32) {
            errors.rejectValue('username', 'user.username.size')
        }

        def existingPerson
        try {
            existingPerson = personService.getPerson(person.getUsername())
        } catch (UsernameNotFoundException e) {
            existingPerson = null
        }

        if (existingPerson != null) {
            errors.rejectValue('username', 'user.username.duplicate')
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (person.getPassword().length() < 8 || person.getPassword().length() > 32) {
            errors.rejectValue('password', 'user.username.password')
        }
    }

}
