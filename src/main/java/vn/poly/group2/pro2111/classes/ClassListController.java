package vn.poly.group2.pro2111.classes;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import vn.poly.group2.pro2111.classes.dto.ClassDto;
import vn.poly.group2.pro2111.classes.form.ClassSearchForm;
import vn.poly.group2.pro2111.classes.service.ClassService;
import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;

@Controller
@RequestMapping("/class")
public class ClassListController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	ClassService classService;

	@GetMapping
	public String index(ModelMap model, @RequestParam(required = false) Long majorid,
			@RequestParam(required = false) Long lecturerid, @RequestParam(defaultValue = "1") Long pn,
			@SessionAttribute(name = "CLASS_MESSAGE", required = false) SessionMessageDto sessionMessageDto) {

		// Fill data into search form
		ClassSearchForm form = new ClassSearchForm();
		form.setLecturerid(lecturerid);
		form.setMajorid(majorid);
		model.addAttribute("clasessSearchForm", form);

		// Get list data with paging
		ListDataDto<ClassDto> ListDataDto = classService.list(majorid, lecturerid, pn);

		model.addAttribute("listClass", ListDataDto.getList());
		model.addAttribute("paging", ListDataDto.getPaging());

		model.addAttribute("majors1", classService.majorDtos(null));
		model.addAttribute("lecturers1", classService.lecturerDtos(null));

		if (sessionMessageDto != null) {
			model.addAttribute("sessionMessageDto", sessionMessageDto);
			sessionMessageDto = null;
			request.getSession().removeAttribute(CmnConst.MESSAGE_KEY_CLASS);
		}

		return "/class/listClass";
	}
}
