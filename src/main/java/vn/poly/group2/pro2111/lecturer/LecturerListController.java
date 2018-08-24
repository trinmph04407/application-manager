package vn.poly.group2.pro2111.lecturer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.lecturer.dto.LecturerDto;
import vn.poly.group2.pro2111.lecturer.form.LecturerSeachForm;
import vn.poly.group2.pro2111.lecturer.service.LecturerService;

@Controller
@RequestMapping("/lecturer")
public class LecturerListController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;

	
	@Autowired
	private LecturerService lecturerService;

	@Autowired
	SessionFactory sessionFactory;

	@GetMapping
	public String index(@RequestParam(required = false) String code, @RequestParam(required = false) String name,
			@RequestParam(defaultValue = "1") Long pn, ModelMap model,
			@SessionAttribute(name = "LECTURER_MESSAGE", required = false) SessionMessageDto sessionMessageDto) {
		
		LecturerSeachForm form = new LecturerSeachForm();
		form.setCode(code);
		form.setName(name);
		model.addAttribute("LecturerSearchForm", form);

		// Get list data with paging
		ListDataDto<LecturerDto> ListDataDto = lecturerService.list(code, name, pn);

		// Add list data
		model.addAttribute("lecturer", ListDataDto.getList());
		model.addAttribute("paging", ListDataDto.getPaging());

		if (sessionMessageDto != null) {
			model.addAttribute("sessionMessageDto", sessionMessageDto);
			sessionMessageDto = null;
			request.getSession().removeAttribute(CmnConst.MESSAGE_KEY_LETURER);
		}

		return "lecturer/listLecturer";
	}
}
