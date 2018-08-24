package vn.poly.group2.pro2111.account;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.poly.group2.pro2111.account.dto.AccountDto;
import vn.poly.group2.pro2111.account.form.AccountSearchForm;
import vn.poly.group2.pro2111.account.form.AccountUpdateForm;
import vn.poly.group2.pro2111.account.service.AccountService;
import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;

@Controller
@RequestMapping("/account")
public class AccountRemoveController {
	@Autowired
	AccountService accountService;
	@Autowired
	HttpServletRequest rq;
	@GetMapping("/deleteAccount/{username}")
	public String remove( @PathVariable String username,@Valid AccountSearchForm accountCreateForm
		) {
		
		try {
			accountService.removeUsername(username);
			AccountDto accountDto = (AccountDto) DataTransformUtil.transform(accountCreateForm, AccountDto.class);
			
			SessionMessageDto sessionMessageDto = new SessionMessageDto();
	        sessionMessageDto.setMessageCode("message.account.delete.success");
	        sessionMessageDto.setMessageArgs(accountDto.getUsername());
	        rq.getSession().setAttribute(CmnConst.MESSAGE_KEY_ACCOUNT, sessionMessageDto); 
		} catch (Exception e) {
			AccountDto accountDto = (AccountDto) DataTransformUtil.transform(accountCreateForm, AccountDto.class);
			accountDto.setUsername(accountCreateForm.getUsername());
			SessionMessageDto sessionMessageDto = new SessionMessageDto();
	        sessionMessageDto.setMessageCode("message.account.delete.fail");
	        sessionMessageDto.setMessageArgs(username);
	        rq.getSession().setAttribute(CmnConst.MESSAGE_KEY_ACCOUNT, sessionMessageDto); 
		} 
		return "redirect:/account";
	}
	
	@GetMapping("/resetAccount/{id}")
	public String reset(@Valid AccountUpdateForm form) {
		AccountDto accountDto = (AccountDto) DataTransformUtil.transform(form, AccountDto.class);
		accountService.reset(accountDto);
		accountService.sendEmail("trinmph04407@fpt.edu.vn");
				 
		
		SessionMessageDto sessionMessageDto = new SessionMessageDto();
        sessionMessageDto.setMessageCode("message.account.reset.success");
        rq.getSession().setAttribute(CmnConst.MESSAGE_KEY_ACCOUNT, sessionMessageDto); 
		return "redirect:/account";
	}
}
