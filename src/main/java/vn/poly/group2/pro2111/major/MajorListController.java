/**
 * 
 */
package vn.poly.group2.pro2111.major;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.major.dto.MajorDto;
import vn.poly.group2.pro2111.major.form.MajorSearchForm;
import vn.poly.group2.pro2111.major.service.MajorService;

/**
 * Major list controller
 * 
 * @author minht
 * 
 */

@Controller
@RequestMapping("/major")
public class MajorListController {
	
    /*=====================================================================================================
     *===== AUTOWIRED PROPERTIES                                                                      =====
     *=====================================================================================================*/
	
	@Autowired
	MajorService majorService;
	
	/*=====================================================================================================
     *===== MAPPING METHOD                                                                            =====
     *=====================================================================================================*/
	
	 /**
     * Generate major list screen
     *
     * @param model
     * @param form
     * 
     * @return Major list screen
     */
	
	@GetMapping
	public String index(@RequestParam(required = false) Long lecturerId, 
						@RequestParam(required = false) String name,
						@RequestParam(defaultValue = "1") Long pn, 
						ModelMap model,
						@SessionAttribute(name = "MAJOR_MESSAGE", required = false) SessionMessageDto sessionMessageDto,
						HttpServletRequest request) {
		
		// Fill data into search form
		MajorSearchForm form = new MajorSearchForm();
		form.setLecturerId(lecturerId);
		form.setName(name);
		model.addAttribute("majorSearchForm", form);

		// Get list data with paging
		ListDataDto<MajorDto> ListDataDto = majorService.list(lecturerId, name, pn);

		// Add list data
		model.addAttribute("listMajor", ListDataDto.getList());
		model.addAttribute("paging", ListDataDto.getPaging());

		// Set data for pulldown lecturers
		model.addAttribute("lecturers", majorService.lecturerDtos(null));

		// Get message
		if (sessionMessageDto != null) {
			model.addAttribute("sessionMessageDto", sessionMessageDto);
			sessionMessageDto = null;
			request.getSession().removeAttribute(CmnConst.MESSAGE_KEY_MAJOR);
		}
		
		 // Return list screen
		return "major/listMajor";
	}
}