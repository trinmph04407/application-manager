package vn.poly.group2.pro2111.rolelec.classeslec;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.poly.group2.pro2111.classes.dto.ClassDto;
import vn.poly.group2.pro2111.classes.form.ClassSearchForm;
import vn.poly.group2.pro2111.classes.service.ClassService;
import vn.poly.group2.pro2111.common.dto.ListDataDto;

@Controller
@RequestMapping("/viewslectuner/classlec")
public class ClassListControllerLec {

	@Autowired
	HttpServletRequest request;

	@Autowired
	ClassService classService;

	@GetMapping
	public String index(ModelMap model, @RequestParam(required = false) Long majorid,
			@RequestParam(required = false) Long lecturerid, @RequestParam(defaultValue = "1") Long pn) {

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

		return "/viewslectuner/classlec/listClassLec";
	}
}
