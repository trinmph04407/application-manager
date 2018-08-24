package vn.poly.group2.pro2111.rolelec.subjectlec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.subject.dto.SubjectDto;
import vn.poly.group2.pro2111.subject.form.SubjectSearchForm;
import vn.poly.group2.pro2111.subject.service.SubjectService;

@Controller
@RequestMapping("/viewslectuner/subjectlec")
public class SubjectListControllerLec {

	@Autowired
	SubjectService subjectService;

	@GetMapping
	public String index(ModelMap model, @RequestParam(required = false) Long majorId,
			@RequestParam(required = false) Long lecturerId, @RequestParam(required = false) String name,
			@RequestParam(defaultValue = "1") Long pn) {

		// Fill data into search form
		SubjectSearchForm form = new SubjectSearchForm();
		form.setLecturerId(lecturerId);
		form.setMajorId(majorId);
		form.setName(name);
		model.addAttribute("subjectSearchForm", form);

		// Get list data with paging
		ListDataDto<SubjectDto> ListDataDto = subjectService.list(majorId, lecturerId, name, pn);

		// Add list data
		model.addAttribute("listSubject", ListDataDto.getList());
		model.addAttribute("paging", ListDataDto.getPaging());

		// List select
		model.addAttribute("majors", subjectService.majorDtos(null));
		model.addAttribute("lecturers", subjectService.lecturerDtos(null));

		// Return list screen
		return "/viewslectuner/subjectlec/listSubjectLec";
	}

}
