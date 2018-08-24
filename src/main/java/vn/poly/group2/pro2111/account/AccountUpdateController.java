package vn.poly.group2.pro2111.account;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.poly.group2.pro2111.account.dto.AccountDto;
import vn.poly.group2.pro2111.account.form.AccountUpdateForm;
import vn.poly.group2.pro2111.account.service.AccountService;
import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;

@Controller
@RequestMapping("/account")
public class AccountUpdateController {
	@Autowired
	AccountService accountService;
	@Autowired
	HttpServletRequest rq;
	
	
	@GetMapping("/updateAccount/{id}")
	public String insert(ModelMap model, @PathVariable Long id) {
		AccountDto accountDto = accountService.getIdAccount(id);
		AccountUpdateForm form = (AccountUpdateForm) DataTransformUtil.transform(accountDto, AccountUpdateForm.class);
		model.addAttribute("lecturers", accountService.lecturers(null));
		model.addAttribute("accountUpdateForm", form);
		return "account/updateAccount";
	}

	@PostMapping(value = "/updateAccount/{id}")
	public String updateRecord(ModelMap model, @PathVariable Long id, @Valid AccountUpdateForm form, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("lecturers", accountService.lecturers(null));
			return "account/updateAccount";
		}

		AccountDto accountDto = (AccountDto) DataTransformUtil.transform(form, AccountDto.class);
		accountDto.setId(id);
		accountService.update(accountDto);

		SessionMessageDto sessionMessageDto = new SessionMessageDto();
		sessionMessageDto.setMessageCode("message.account.update.success");
		sessionMessageDto.setMessageArgs(accountDto.getUsername());
		rq.getSession().setAttribute(CmnConst.MESSAGE_KEY_ACCOUNT, sessionMessageDto);

		return "redirect:/account";

	}
}
