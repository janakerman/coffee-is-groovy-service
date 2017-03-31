package com.janakerman.controller

import com.janakerman.auth.UserCredentialsService
import com.janakerman.dto.PersonDTO
import com.janakerman.dto.TripDTO
import com.janakerman.entity.Person
import com.janakerman.entity.PersonValidator
import com.janakerman.service.PersonService
import com.janakerman.auth.SecurityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

/**
 * A controller for Person entities.
 * Created by jakerman on 15/03/2017.
 */
@RestController
class PersonController {

    private final PersonService service
    private final PersonValidator validator
    private final SecurityService securityService

    @Autowired
    PersonController(PersonService service, PersonValidator validator, SecurityService securityService) {
        this.service = service
        this.validator = validator
        this.securityService = securityService
    }

    @GetMapping(value="/person")
    PersonDTO getCurrent() {
        new PersonDTO(service.getPerson(getUsername()))
    }

    @PostMapping(value = "/register")
    @ResponseBody
    PersonDTO post(@RequestBody Person person, BindingResult bindingResult) {
        validator.validate(person, bindingResult)

        if (bindingResult.hasErrors()) {
            // TODO: Update to return specific errors. Check out REST validation - this might be templating only.
            return
        }

        new PersonDTO(service.create(person))
    }

    private getUsername() { this.securityService.findLoggedInUsername() }

}
