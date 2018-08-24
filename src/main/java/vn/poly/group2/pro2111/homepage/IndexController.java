package vn.poly.group2.pro2111.homepage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.poly.group2.pro2111.homepage.Service.IndexService;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private IndexService indexService;

	@GetMapping
	public String index(ModelMap map) {
		map.addAttribute("home", indexService.listTop());
		return "/homepage/index";
	}
}