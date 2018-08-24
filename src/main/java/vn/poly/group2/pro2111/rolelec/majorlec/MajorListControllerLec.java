package vn.poly.group2.pro2111.rolelec.majorlec;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.major.dto.MajorDto;
import vn.poly.group2.pro2111.major.form.MajorSearchForm;
import vn.poly.group2.pro2111.major.service.MajorService;

@Controller
@RequestMapping("/viewslectuner/majorlec")
public class MajorListControllerLec {

	@Autowired
	MajorService majorService;

	@GetMapping
	public String index(@RequestParam(required = false) Long lecturerId, @RequestParam(required = false) String name,
			@RequestParam(defaultValue = "1") Long pn, ModelMap model) {

		MajorSearchForm form = new MajorSearchForm();
		form.setLecturerId(lecturerId);
		form.setName(name);
		model.addAttribute("majorSearchForm", form);

		// Get list data with paging
		ListDataDto<MajorDto> ListDataDto = majorService.list(lecturerId, name, pn);

		// Add list data
		model.addAttribute("listMajor", ListDataDto.getList());
		model.addAttribute("paging", ListDataDto.getPaging());

		// List select
		model.addAttribute("lecturers", majorService.lecturerDtos(null));

		return "/viewslectuner/majorlec/listMajorLec";
	}
}