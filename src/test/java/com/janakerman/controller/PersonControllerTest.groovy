package com.janakerman.controller

import com.janakerman.entity.Person
import com.janakerman.service.PersonService
import groovy.mock.interceptor.MockFor
import groovy.mock.interceptor.StubFor
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import static org.hamcrest.Matchers.*
import static org.mockito.Mockito.*
import static com.janakerman.controller.TestUtil.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


@RunWith(SpringJUnit4ClassRunner)
@WebAppConfiguration
class PersonControllerTest {

//    @Mock
    def mock = Mock
    private PersonService personService
    @InjectMocks
    private PersonController controller

    private MockMvc mockMvc

    @Before
    void setup() {
//        personService = (PersonService)new MockFor(PersonService)
        mockMvc = MockMvcBuilders.standaloneSetup(controller/*, personService */).build()
    }

    @Test
    void test_get_valid_person() {
        def person = Util.validPerson()

        MockFor<Person> mock = new MockFor(PersonService)
        mock.demand.getPerson { person }

//        when(personService.get(1)).thenReturn(person)
        mock.use {
            mockMvc.perform(get('/person/1'))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect(jsonPath('$.id', is(1)))
                    .andExpect(jsonPath('$.firstName', is(person.firstName)))
                    .andExpect(jsonPath('$.lastName', is(person.lastName)))
        }


        verify(personService, times(1)).get(1)
        verifyNoMoreInteractions(personService)
    }

    @Test
    void test_post_valid_person() {
        def person = Util.validPerson()

        when(personService.create(any(Person))).thenReturn(person)

        mockMvc.perform(post('/person')
                .content(Util.VALID_PERSON_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath('$.id', is(1)))
            .andExpect(jsonPath('$.firstName', is(person.firstName)))
            .andExpect(jsonPath('$.lastName', is(person.lastName)))

        verify(personService, times(1)).create(eq(person))
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
