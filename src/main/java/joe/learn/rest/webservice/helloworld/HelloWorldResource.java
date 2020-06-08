package joe.learn.rest.webservice.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

// Controller
@RestController
public class HelloWorldResource {

    @Autowired
    private MessageSource messageSource;

    // GET
    // URI - /hello-world
    // method - "Hello World"
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    // hello-world-bean
    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    // hello-world/path-variable/{name}
    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationlized() {
        // after using LocaleContextHolder to getLocale
        // then we do not need to pass the Locale as parameter to this method
        // for example helloWorldInternationlized(@RequestHeader("Accept-Language", require = false) Locale locale)
        return messageSource.getMessage("good.morning.message",null,
                LocaleContextHolder.getLocale());
    }

}
