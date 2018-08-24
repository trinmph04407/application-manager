package vn.poly.group2.pro2111.classes;



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
import org.springframework.web.bind.annotation.RequestParam;

import vn.poly.group2.pro2111.classes.dto.ClassDto;
import vn.poly.group2.pro2111.classes.form.ClassUpdateForm;
import vn.poly.group2.pro2111.classes.service.ClassService;
import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;
import vn.poly.group2.pro2111.student.service.StudentService;

@Controller
@RequestMapping("/class")
public class ClassUpdateController {

	@Autowired
	ClassService classService;

	@Autowired
	StudentService studentService;

	@GetMapping("/updateClass/{id}")
	public String index(ModelMap map, @PathVariable long id, @RequestParam(required = false) String code,
			@RequestParam(required = false) String name, @RequestParam(defaultValue = "1") Long pn) {

		ClassDto classDto = classService.detail(id);

		ClassUpdateForm form = (ClassUpdateForm) DataTransformUtil.transform(classDto, ClassUpdateForm.class);
		map.addAttribute("classUpdateForm", form);

		map.addAttribute("majors1", classService.majorDtos(null));
		map.addAttribute("lecturers1", classService.lecturerDtos(null));

		return "/class/updateClass";
	}

	@PostMapping("/updateClass/{id}")
	public String update(ModelMap map, @PathVariable long id, @Valid ClassUpdateForm form, BindingResult bindingResult,
			HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			return "class/updateClass";
		}
		ClassDto classDto = (ClassDto) DataTransformUtil.transform(form, ClassDto.class);
		classDto.setId(id);
		classService.editClass(classDto);

		SessionMessageDto sessionMessageDto = new SessionMessageDto();
		sessionMessageDto.setMessageCode("message.class.update.success");
		sessionMessageDto.setMessageArgs(classDto.getCode());
		request.getSession().setAttribute(CmnConst.MESSAGE_KEY_CLASS, sessionMessageDto);

		return "redirect:/class";
	}
	
	
}
