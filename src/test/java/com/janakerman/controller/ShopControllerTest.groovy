package com.janakerman.controller
import com.janakerman.entity.Person
import com.janakerman.entity.Shop
import com.janakerman.service.PersonService
import com.janakerman.service.ShopService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import static org.hamcrest.Matchers.*
import static org.mockito.Mockito.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@RunWith(SpringJUnit4ClassRunner)
@WebAppConfiguration
class ShopControllerTest {

    @Mock
    private ShopService personService
    @InjectMocks
    private ShopController controller

    private MockMvc mockMvc

    @Before
    void setup() {
        MockitoAnnotations.initMocks(this)
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build()
    }

//    @Test
//    void test_get_valid_shop() {
//        Shop shop = new shop(
//                id: 1,
//                firstName: 'Joe',
//                lastName: 'Blogs'
//        )
//
//        when(personService.get(1)).thenReturn(person)
//
//        mockMvc.perform(get('/person/1'))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
//                .andExpect(jsonPath('$.id', is(1)))
//                .andExpect(jsonPath('$.firstName', is(person.firstName)))
//                .andExpect(jsonPath('$.lastName', is(person.lastName)))
//
//        verify(personService, times(1)).get(1)
//        verifyNoMoreInteractions(personService)
//    }

}
