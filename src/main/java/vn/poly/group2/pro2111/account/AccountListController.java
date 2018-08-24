package vn.poly.group2.pro2111.account;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import vn.poly.group2.pro2111.account.dto.AccountDto;
import vn.poly.group2.pro2111.account.form.AccountSearchForm;
import vn.poly.group2.pro2111.account.service.AccountService;
import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;

@Controller
@RequestMapping("/account")
public class AccountListController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private HttpServletRequest rq;
	@GetMapping
	public String index(@RequestParam(required = false) Long lecturerId, @RequestParam(required = false) String username,
			@RequestParam(defaultValue = "1") Long pn, ModelMap model,
			@SessionAttribute(name = "ACCOUNT_MESSAGE", required = false) SessionMessageDto sessionMessageDto){
		
		AccountSearchForm form = new AccountSearchForm();
		form.setLecturerId(lecturerId);
		form.setUsername(username);
		model.addAttribute("accountSearchForm", form);

		// Get list data with paging
		ListDataDto<AccountDto> ListDataDto = accountService.getListAccount(lecturerId, username, pn);
		
		 
		// Add list data
		model.addAttribute("listAccount", ListDataDto.getList());
		model.addAttribute("paging", ListDataDto.getPaging());
		
		 model.addAttribute("lecturers", accountService.lecturers(null));
		 
		 
		 if (sessionMessageDto != null) {
	            model.addAttribute("sessionMessageDto", sessionMessageDto);
	            sessionMessageDto = null;
	            rq.getSession().removeAttribute(CmnConst.MESSAGE_KEY_ACCOUNT);
	        }
		 
		return "/account/listAccount";
	}
}
