package vn.poly.group2.pro2111.student;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.student.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentRemoveController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/deleteStudent/{id}")
	public String delete(@PathVariable Long id, HttpServletRequest request) {
		try {
			studentService.deleteStudent(id);
			SessionMessageDto sessionMessageDto = new SessionMessageDto();
			sessionMessageDto.setMessageCode("message.student.delete.success");
			sessionMessageDto.setMessageArgs(id);
			request.getSession().setAttribute("STUDENT_MESSAGE", sessionMessageDto);
			return "redirect:/student";
		} catch (Exception e) {
			SessionMessageDto sessionMessageDto = new SessionMessageDto();
			sessionMessageDto.setMessageCode("message.student.delete.faill");
			sessionMessageDto.setMessageArgs(id);
			request.getSession().setAttribute("STUDENT_MESSAGE", sessionMessageDto);
			return "redirect:/student";
		}
	}
}
