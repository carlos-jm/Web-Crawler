package upm.prof.webcrawler.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/")
public class ViewController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String home(Model model) {
        return "index";
    }


    @RequestMapping(value = "/queries", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String queries(Model model) {
        return "queries";
    }

}
