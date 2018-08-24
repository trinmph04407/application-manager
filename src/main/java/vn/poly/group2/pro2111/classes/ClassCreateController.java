package vn.poly.group2.pro2111.classes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.poly.group2.pro2111.classes.dto.ClassDto;
import vn.poly.group2.pro2111.classes.form.ClassCreateForm;
import vn.poly.group2.pro2111.classes.service.ClassService;
import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;

@Controller
@RequestMapping("/class")
public class ClassCreateController {

	@Autowired
	private ClassService classService;

	@Autowired
	HttpServletRequest request;

	@GetMapping("/createClass")
	public String index(ModelMap model) {
		model.addAttribute("classCreateForm", new ClassCreateForm());

		model.addAttribute("majors1", classService.majorDtos(null));
		model.addAttribute("lecturers1", classService.lecturerDtos(null));

		return "/class/createClass";
	}

	@PostMapping("/createClass")
	public String insertForm(ModelMap map, @Valid ClassCreateForm form, BindingResult bindingResult) {

		String code = request.getParameter("code");
		if (classService.checkId(code) == true) {
			bindingResult.rejectValue("code", "errors.duplicate");
			map.addAttribute("majors1", classService.majorDtos(null));
			map.addAttribute("lecturers1", classService.lecturerDtos(null));
			return "class/createClass";
		} else if (bindingResult.hasErrors()) {
			map.addAttribute("majors1", classService.majorDtos(null));
			map.addAttribute("lecturers1", classService.lecturerDtos(null));
			return "class/createClass";
		}
		ClassDto classDto = (ClassDto) DataTransformUtil.transform(form, ClassDto.class);
		classService.insertClass(classDto);

		SessionMessageDto sessionMessageDto = new SessionMessageDto();
		sessionMessageDto.setMessageCode("message.class.create.success");
		sessionMessageDto.setMessageArgs(classDto.getCode(), classDto.getLecturerName1());
		request.getSession().setAttribute(CmnConst.MESSAGE_KEY_CLASS, sessionMessageDto);

		return "redirect:/class";

	}
}
