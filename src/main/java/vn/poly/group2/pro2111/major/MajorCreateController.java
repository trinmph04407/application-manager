/**
 * 
 */
package vn.poly.group2.pro2111.major;

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
import vn.poly.group2.pro2111.major.dto.MajorDto;
import vn.poly.group2.pro2111.major.form.MajorCreateForm;
import vn.poly.group2.pro2111.major.service.MajorService;

/**
 * Major create controller
 * 
 * @author minht
 * 
 */

@Controller
@RequestMapping("/major")
public class MajorCreateController {
	
    /*=====================================================================================================
     *===== AUTOWIRED PROPERTIES                                                                      =====
     *=====================================================================================================*/

	@Autowired
	MajorService majorService;
	
    /*=====================================================================================================
     *===== MAPPING METHOD			                                                                  =====
     *=====================================================================================================*/
	
	/**
     * Generate create screen
     *
     * @param model
     * @param form
     *
     * @return Ereate screen
     */	
	
	@GetMapping("/createMajor")
	public String index(ModelMap map,
						MajorCreateForm majorCreateForm) {
		
		// Set data for pulldown lecturers
		map.addAttribute("lecturers", majorService.lecturerDtos(null));
		
		// Generate create screen
		return "major/createMajor";
	}
	
	 /**
     * Create new major
     *
     * @param model
     * @param form
     * @param bindingResult
     *
     * @return  Success: List major screen
     *          Errors: Create input screen
     */
	
	@PostMapping("/createMajor")
	public String create(ModelMap map, 
						 @Valid MajorCreateForm majorCreateForm, 
						 BindingResult bindingResult,
						 HttpServletRequest request) {
		
		// Check code
		String code = request.getParameter("code");

		if (majorService.check(code) == true) {
			bindingResult.rejectValue("code", "errors.duplicate");
			
			// Set data for pulldown lecturers
			map.addAttribute("lecturers", majorService.lecturerDtos(null));
			
			// Generate create screen
			return "major/createMajor";
		}

		// Check errors
		else if (bindingResult.hasErrors()) {
			
			// Set data for pulldown lecturers
			map.addAttribute("lecturers", majorService.lecturerDtos(null));
			
			// Generate create screen
			return "major/createMajor";
		}

		 // Cast DTO to Form
		MajorDto majorDto = (MajorDto) DataTransformUtil.transform(majorCreateForm, MajorDto.class);
		majorDto.setCode(majorCreateForm.getCode());
		majorDto.setName(majorCreateForm.getName());
		majorDto.setLecturerId(majorCreateForm.getLecturerId());
		
		// Call service to insert new major
		majorService.create(majorDto);

		// message success
		SessionMessageDto sessionMessageDto = new SessionMessageDto();
		sessionMessageDto.setMessageCode("message.major.create.success");
		sessionMessageDto.setMessageArgs(majorDto.getName());
		request.getSession().setAttribute(CmnConst.MESSAGE_KEY_MAJOR, sessionMessageDto);
		
		// List major screen
		return "redirect:/major";
	}
}
