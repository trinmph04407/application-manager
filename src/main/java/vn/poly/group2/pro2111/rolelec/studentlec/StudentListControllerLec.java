package vn.poly.group2.pro2111.rolelec.studentlec;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.student.dto.StudentDto;
import vn.poly.group2.pro2111.student.form.StudentSearchForm;
import vn.poly.group2.pro2111.student.service.StudentService;

@Controller
@RequestMapping("/viewslectuner/studentlec")
public class StudentListControllerLec {
	@Autowired
	HttpServletRequest request;
	@Autowired
	StudentService studentService;

	@GetMapping
	public String index(ModelMap model, @RequestParam(required = false) String code,
			@RequestParam(required = false) String name, @RequestParam(defaultValue = "1") Long pn) {
		// Fill data into search form
		StudentSearchForm form = new StudentSearchForm();
		form.setCode(code);
		form.setName(name);
		model.addAttribute("studentSearchForm", form);

		// Get list data with paging
		ListDataDto<StudentDto> ListDataDto = studentService.list(code, name, pn);

		model.addAttribute("listStudent", ListDataDto.getList());
		model.addAttribute("paging", ListDataDto.getPaging());

		return "/viewslectuner/studentlec/listStudentLec";
	}
}
