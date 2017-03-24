package com.janakerman.controller

import com.janakerman.dto.LoginValues
import com.janakerman.dto.PersonDTO
import com.janakerman.entity.Person
import com.janakerman.entity.PersonValidator
import com.janakerman.service.PersonService
import com.janakerman.service.SecurityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

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

    @GetMapping(value="/person/{id}")
    PersonDTO get(@PathVariable Integer id) { new PersonDTO(service.getPerson(id)) }

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

}
