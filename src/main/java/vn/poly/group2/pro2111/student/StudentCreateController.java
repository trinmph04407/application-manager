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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.poly.group2.pro2111.classes.dto.ClassDto;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.major.dto.MajorDto;
import vn.poly.group2.pro2111.student.dto.StudentDto;
import vn.poly.group2.pro2111.student.form.StudentCreateForm;
import vn.poly.group2.pro2111.student.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentCreateController {

	@Autowired
	private StudentService studentService;

	@Autowired
	HttpServletRequest request;

	@GetMapping("/createStudent")
	public String index(ModelMap model) {
		model.addAttribute("studentCreateForm", new StudentCreateForm());
		return "student/createStudent";
	}

	@ModelAttribute("listClass")
	public List<ClassDto> listClass() {
		return studentService.listClass();
	}

	@ModelAttribute("listMajor")
	public List<MajorDto> listMajor() {
		return studentService.listMajor();
	}

	@PostMapping("/createStudent")
	public String submit(ModelMap map, @Valid StudentCreateForm form, BindingResult bindingResult,
			@RequestParam(required = false) MultipartFile file) {

		String code = request.getParameter("code");
		if (studentService.checkId(code)) {
			bindingResult.rejectValue("code", "code", "Mã đã tồn tại");
			return "student/createStudent";
		} else if (bindingResult.hasErrors()) {
			return "student/createStudent";
		}
		StudentDto studentDto = new StudentDto();
		studentDto.setId(form.getId());
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
		studentService.insertStudent(studentDto);

		SessionMessageDto sessionMessageDto = new SessionMessageDto();
		sessionMessageDto.setMessageCode("message.student.create.success");
		sessionMessageDto.setMessageArgs(studentDto.getCode());
		request.getSession().setAttribute("STUDENT_MESSAGE", sessionMessageDto);

		return "redirect:/student";
	}
}
