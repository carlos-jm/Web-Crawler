package upm.prof.webcrawler.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "webcrawler/view")
public class ViewController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String view(Model model) {
		return "index";
	}
	
}
