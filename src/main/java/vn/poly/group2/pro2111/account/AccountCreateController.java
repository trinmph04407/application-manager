package vn.poly.group2.pro2111.account;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.poly.group2.pro2111.account.dto.AccountDto;
import vn.poly.group2.pro2111.account.form.AccountCreateForm;
import vn.poly.group2.pro2111.account.service.AccountService;
import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;

@Controller
@RequestMapping("/account")
public class AccountCreateController {
	@Autowired
	AccountService accountService;
	@Autowired
	HttpServletRequest rq;

	@GetMapping("/createAccount")
	public String insert(ModelMap model) {
		model.addAttribute("accountCreateForm", new AccountCreateForm());
		model.addAttribute("lecturers", accountService.lecturers(null));
		return "account/createAccount";
	}

	@PostMapping("/createAccount")
	public String submit(ModelMap model, @Valid AccountCreateForm accountCreateForm, BindingResult bindingResult) {

		Long id = Long.parseLong(rq.getParameter("lecturerId"));
		if (accountService.checkId(id) == true) {
			model.addAttribute("exist", "Người dùng này đã có tài khoản");
			model.addAttribute("lecturers", accountService.lecturers(null));
			return "account/createAccount";
		}
		// Validate data
		validateFormData(bindingResult);

		// Check errors
		if (bindingResult.hasErrors()) {
			model.addAttribute("lecturers", accountService.lecturers(null));
			return "account/createAccount";
		}

		// dto cast with form
		AccountDto accountDto = (AccountDto) DataTransformUtil.transform(accountCreateForm, AccountDto.class);
		accountDto.setLecturerId(accountCreateForm.getLecturerId());
		accountDto.setUsername(accountCreateForm.getUsername());
		accountDto.setPassword(MD5.convert(accountCreateForm.getPassword()));
		accountDto.setRole(accountCreateForm.getRole());
		accountService.create(accountDto);

		// message success
		SessionMessageDto sessionMessageDto = new SessionMessageDto();
		sessionMessageDto.setMessageCode("message.account.create.success");
		sessionMessageDto.setMessageArgs(accountDto.getUsername());
		rq.getSession().setAttribute(CmnConst.MESSAGE_KEY_ACCOUNT, sessionMessageDto);

		return "redirect:/account";
	}

	protected void validateFormData(BindingResult bindingResult) {
		String username = rq.getParameter("username");
		if (accountService.checkUsername(username) == true) {
			bindingResult.rejectValue("username", "account.username.exist");
		}
	}

	
}
