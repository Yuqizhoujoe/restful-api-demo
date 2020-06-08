package joe.learn.rest.webservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    // USING THE BASIC PATH VALUE - uri versioning
    @GetMapping("/v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Yuqi Zhou");
    }

    @GetMapping("/v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Yumi", "Kuang"));
    }

    // USING PARAMS - request parameter versioning
    @GetMapping(value="/person/param", params = "version=1")
    public PersonV1 paramV1() {
        return new PersonV1("Yumi Kuang");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramV2() {
        return new PersonV2(new Name("Yumi", "Kuang"));
    }

    // USING HEADER - header versioning
    @GetMapping(value="/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1() {
        return new PersonV1("Yumi Kuang");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2() {
        return new PersonV2(new Name("Yumi", "Kuang"));
    }

    // USING PRODUCES - it also called Accept Header Versioning
    // produces means that the method will produce the specified MIME type back to client
    @GetMapping(value="/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1() {
        return new PersonV1("Yumi Kuang");
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2() {
        return new PersonV2(new Name("Yumi", "Kuang"));
    }

}
