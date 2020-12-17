package upm.prof.webcrawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import upm.prof.webcrawler.service.CategoryService;
import upm.prof.webcrawler.service.TypeService;
import upm.prof.webcrawler.service.WebsiteService;


@Controller
@RequestMapping(value = "/")
public class ViewController {

    @Autowired
    private WebsiteService websiteService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String home(Model model) {
        return "index";
    }


    @RequestMapping(value = "/queries", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String queries(Model model) {
        model.addAttribute("websiteList", websiteService.getAllDemoWebsites());
        model.addAttribute("categoryList", categoryService.getAllCategories());
        model.addAttribute("typeList", typeService.getAllTypes());
        return "queries";
    }

}
