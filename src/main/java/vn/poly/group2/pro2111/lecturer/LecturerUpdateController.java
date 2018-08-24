package vn.poly.group2.pro2111.lecturer;

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

import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;
import vn.poly.group2.pro2111.lecturer.dto.LecturerDto;
import vn.poly.group2.pro2111.lecturer.form.LecturerUpdateForm;
import vn.poly.group2.pro2111.lecturer.service.LecturerService;

@Controller
@RequestMapping("/lecturer")
public class LecturerUpdateController {

	@Autowired
	LecturerService lecturerService;

	@GetMapping("/updateLecturer/{id}")
	public String index(ModelMap map, @PathVariable long id) {
		LecturerDto lecturerDto = lecturerService.getLecturerID(id);
		LecturerUpdateForm form = (LecturerUpdateForm) DataTransformUtil.transform(lecturerDto,
				LecturerUpdateForm.class);
		map.addAttribute("lecturerUpdateForm", form);
		return "lecturer/updateLecturer";
	}

	@PostMapping("/updateLecturer/{id}")
	public String update(ModelMap map, @PathVariable long id, @Valid LecturerUpdateForm form,
			BindingResult bindingResult, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			return "lecturer/updateLecturer";
		}
		LecturerDto lecturerDto = (LecturerDto) DataTransformUtil.transform(form, LecturerDto.class);
		lecturerDto.setId(id);
		lecturerService.editLecturer(lecturerDto);

		SessionMessageDto sessionMessageDto = new SessionMessageDto();
		sessionMessageDto.setMessageCode("message.lecturer.update.success");
		sessionMessageDto.setMessageArgs(lecturerDto.getCode(), lecturerDto.getName());
		request.getSession().setAttribute(CmnConst.MESSAGE_KEY_LETURER, sessionMessageDto);

		return "redirect:/lecturer";
	}
}
