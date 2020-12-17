package upm.prof.webcrawler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import upm.prof.webcrawler.entity.User;
import upm.prof.webcrawler.entity.Website;
import upm.prof.webcrawler.exceptions.AlreadyExistsException;
import upm.prof.webcrawler.exceptions.BadRequestException;
import upm.prof.webcrawler.service.WebsiteService;

@RestController
@RequestMapping(value = "/websites")
public class WebsiteController {
    @Autowired
    private WebsiteService websiteService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Website> obtenerDemoWebsites() {
        return websiteService.getAllDemoWebsites();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Website getWebsite(@PathVariable int id) throws BadRequestException, AlreadyExistsException {
        return websiteService.getWebsiteById(id);

    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWebsite(@PathVariable int id) throws BadRequestException, AlreadyExistsException {
        websiteService.removeWebsiteById(id);
    }
}

