package vn.poly.group2.pro2111.rolelec.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.poly.group2.pro2111.account.dto.AccountDto;
import vn.poly.group2.pro2111.account.form.AccountSearchForm;
import vn.poly.group2.pro2111.account.service.AccountService;
import vn.poly.group2.pro2111.common.dto.ListDataDto;

@Controller
@RequestMapping("/viewslectuner/accountlec")
public class AccountListControllerLecturer {

	@Autowired
	private AccountService accountService;

	@GetMapping
	public String index(@RequestParam(required = false) Long lecturerId,
			@RequestParam(required = false) String username, @RequestParam(defaultValue = "1") Long pn,
			ModelMap model) {

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

		return "/viewslectuner/accountlec/listAccountLec";
	}
}
