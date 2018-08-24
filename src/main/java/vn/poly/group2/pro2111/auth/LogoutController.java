package vn.poly.group2.pro2111.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth/logout")
public class LogoutController {
	@GetMapping
	public String index() {

		return "redirect:/";
	}
}
