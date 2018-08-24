package vn.poly.group2.pro2111.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.poly.group2.pro2111.classes.dto.ClassDto;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;
import vn.poly.group2.pro2111.major.dto.MajorDto;
import vn.poly.group2.pro2111.student.dto.StudentDto;
import vn.poly.group2.pro2111.student.form.StudentUpdateForm;
import vn.poly.group2.pro2111.student.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentUpdateController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/updateStudent/{id}")
	public String index(ModelMap map, @PathVariable Long id) {
		StudentDto studentDto = studentService.detail(id);
		StudentUpdateForm form = (StudentUpdateForm) DataTransformUtil.transform(studentDto, StudentUpdateForm.class);
		map.addAttribute("studentUpdateForm", form);
		return "student/updateStudent";
	}

	@ModelAttribute("listClass")
	public List<ClassDto> listClass() {
		return studentService.listClass();
	}

	@ModelAttribute("listMajor")
	public List<MajorDto> listMajor() {
		return studentService.listMajor();
	}

	@PostMapping("/updateStudent/{id}")
	public String update(ModelMap map, @PathVariable Long id, @Valid StudentUpdateForm form,
			BindingResult bindingResult, HttpServletRequest request,
			@RequestParam(required = false) MultipartFile file) {
		if (bindingResult.hasErrors()) {
			return "student/updateStudent";
		}
		StudentDto studentDto = new StudentDto();
		studentDto.setId(id);
		studentDto.setCode(form.getCode());
		studentDto.setName(form.getName());
		studentDto.setPhone(form.getPhone());
		studentDto.setEmail(form.getEmail());
		studentDto.setNote(form.getNote());
		studentDto.setClassid(form.getClassid());
		studentDto.setMajorid(form.getMajorid());
		// Save image
		if (file != null && !file.isEmpty()) {
			studentDto.setPhoto(studentService.saveImage(form.getCode(), file));
		}
		studentService.editStudnet(studentDto);

		SessionMessageDto sessionMessageDto = new SessionMessageDto();
		sessionMessageDto.setMessageCode("message.class.update.success");
		sessionMessageDto.setMessageArgs(studentDto.getCode(), studentDto.getName());
		request.getSession().setAttribute("STUDENT_MESSAGE", sessionMessageDto);

		return "redirect:/student";
	}
}
