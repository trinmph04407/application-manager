
package vn.poly.group2.pro2111.auth;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.poly.group2.pro2111.account.MD5;
import vn.poly.group2.pro2111.auth.form.LoginForm;
import vn.poly.group2.pro2111.auth.service.LoginService;
import vn.poly.group2.pro2111.common.bases.BaseController;
import vn.poly.group2.pro2111.common.dto.LoginUserDto;
import vn.poly.group2.pro2111.common.entities.Account;

@Controller
@RequestMapping("/auth")
public class LoginController extends BaseController {
	@Autowired
	LoginService loginService;

	@GetMapping("/login")
	public String input(ModelMap model, LoginForm loginForm) {
		model.addAttribute("account", loginForm);
		return "/auth/login";
	}

	@PostMapping("login")
	public String loged(ModelMap model, @Valid LoginForm loginForm,
			@SessionAttribute("LOGGED_IN_USER_DTO") LoginUserDto loginUserDto, RedirectAttributes redirectAttributes,
			HttpSession session, @ModelAttribute Account users) {
		// Check errors
		if (users.getUsername() == null || users.getPassword() == null) {
			redirectAttributes.addFlashAttribute("message", "Đăng nhập thất bại");
			return "redirect:/auth/login";
		}
		if (loginService.checkAdmin(users.getUsername(), users.getPassword(), users.getRole())) {
			loginUserDto.setUsername(loginForm.getUsername());
			return "redirect:/lecturer";
		} else if (loginService.checkLecturer(users.getUsername(), MD5.convert(users.getPassword()), users.getRole())) {
			loginUserDto.setUsername(loginForm.getUsername());
			return "redirect:/viewslectuner/classlec";
		}

		redirectAttributes.addFlashAttribute("message", "Đăng nhập thất bại");
		// Return home page
		return "redirect:/auth/login";

	}

}
