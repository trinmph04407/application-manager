package vn.poly.group2.pro2111.lecturer;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;
import vn.poly.group2.pro2111.lecturer.dto.LecturerDto;
import vn.poly.group2.pro2111.lecturer.form.LecturerCreateForm;
import vn.poly.group2.pro2111.lecturer.service.LecturerService;

@Controller
@RequestMapping("/lecturer")
public class LecturerCreateController {

	@Autowired
	private LecturerService lecturerService;

	@Autowired
	HttpServletRequest request;

	@GetMapping("/createLecturer")
	public String insertLecturer(ModelMap model) {
		model.addAttribute("lecturerCreateForm", new LecturerCreateForm());
		return "lecturer/createLecturer";
	}

	@PostMapping("/createLecturer")
	public String insertForm(ModelMap map, @Valid LecturerCreateForm form, BindingResult bindingResult) {
		try {
			String code = request.getParameter("code");
			if (lecturerService.checkId(code) == true) {
				bindingResult.rejectValue("code", "errors.duplicate");
				return "lecturer/createLecturer";
			} else if (bindingResult.hasErrors()) {
				return "lecturer/createLecturer";
			}
			LecturerDto lecturerDto = (LecturerDto) DataTransformUtil.transform(form, LecturerDto.class);
			lecturerService.insertLecturer(lecturerDto);

			SessionMessageDto sessionMessageDto = new SessionMessageDto();
			sessionMessageDto.setMessageCode("message.lecturer.create.success");
			sessionMessageDto.setMessageArgs(lecturerDto.getCode(), lecturerDto.getName());
			request.getSession().setAttribute(CmnConst.MESSAGE_KEY_LETURER, sessionMessageDto);

			return "redirect:/lecturer";
		} catch (Exception e) {
			return "lecturer/createLecturer";
		}
	}
}
