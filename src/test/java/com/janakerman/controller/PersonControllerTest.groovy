package com.janakerman.controller

import com.janakerman.entity.Person
import com.janakerman.service.PersonService
import groovy.json.JsonSlurper
import org.springframework.http.MediaType

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import spock.lang.Specification

class PersonControllerTest extends Specification {

    def personService = Mock(PersonService)
    def personController = new PersonController(personService)
    def mockMvc = standaloneSetup(personController).build()

    def "getting a valid person"() {
        given: 'an existing person'
        def person = Util.validPerson()
        1 * personService.getPerson(1) >> person

        when: 'request is made'
        def request = mockMvc.perform(get('/person/1'))
        def content = new JsonSlurper().parseText(request.andReturn().response.contentAsString)


        then: 'response is correct json'
        assert content?.id == 1
        assert content?.firstName == person.firstName
        assert content?.lastName == person.lastName
    }

    def "creating a valid person"() {
        given: 'a valid person'
        def person = Util.validPerson()
        1 * personService.create(_) >> person

        when: 'person is posted'
        def request = mockMvc.perform(post('/person')
                .content(Util.VALID_PERSON_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
        def content = new JsonSlurper().parseText(request.andReturn().response.contentAsString)

        then: 'response is correct json'
        assert content?.id == 1
        assert content?.firstName == person.firstName
        assert content?.lastName == person.lastName
    }

    private static class Util {
        static final String VALID_PERSON_JSON = """{"id":1, "firstName":"Joe", "lastName":"Blogs"}"""

        static Person validPerson() {
            return new Person(
                    id: 1,
                    firstName: 'Joe',
                    lastName: 'Blogs'
            )
        }
    }

}
