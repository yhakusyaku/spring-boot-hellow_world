package yhakusyaku.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping("/")
    public ModelAndView sayHello(ModelAndView model) {
    	model.setViewName("index");
    	model.addObject("message", "Hello Spring Boot!!");
        return model;
    }
}