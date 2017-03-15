package com.janakerman.java.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for greetings.
 * Created by jakerman on 15/03/2017.
 */
@RestController
class GreetingController {

    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        return "Hi, " + name;
    }

}
