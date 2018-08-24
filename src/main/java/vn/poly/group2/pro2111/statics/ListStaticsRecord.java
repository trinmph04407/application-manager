/*
 * (C) Copyright 2018
 *
 * @auth Nguyen Van Doan
 * @date Aug 14, 2018
 */
package vn.poly.group2.pro2111.statics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.poly.group2.pro2111.common.bases.BaseController;
import vn.poly.group2.pro2111.statics.service.StaticsService;

@Controller
@RequestMapping("/statics")
public class ListStaticsRecord extends BaseController {
	@Autowired
	StaticsService staticService;

	@GetMapping
	public String ListStatics(ModelMap model) {
		model.addAttribute("arrays", staticService.listStatics());
		return "statics/index";
	}
}
