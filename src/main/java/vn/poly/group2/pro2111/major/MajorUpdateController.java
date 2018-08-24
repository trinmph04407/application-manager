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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;
import vn.poly.group2.pro2111.major.dto.MajorDto;
import vn.poly.group2.pro2111.major.form.MajorUpdateForm;
import vn.poly.group2.pro2111.major.service.MajorService;

/**
 * Major update controller
 * 
 * @author minht
 * 
 */


@Controller
@RequestMapping("/major")
public class MajorUpdateController {
	
    /*=====================================================================================================
     *===== AUTOWIRED PROPERTIES                                                                      =====
     *=====================================================================================================*/
	
	@Autowired
	MajorService majorService;
	
    /*=====================================================================================================
     *===== MAPPING METHOD			                                                                  =====
     *=====================================================================================================*/
	
	/**
     * Generate update screen
     *
     * @param model
     * @param form
     *
     * @return Ereate screen
     */
	
	@GetMapping("/updateMajor/{id}")
	public String index(ModelMap map,
						@PathVariable long id) {
		
		// Get data
		MajorDto majorDto = majorService.detail(id);
		
		// Create new form
		MajorUpdateForm form = (MajorUpdateForm) DataTransformUtil.transform(majorDto, MajorUpdateForm.class);
		map.addAttribute("majorUpdateForm", form);
		
		// Set data for pulldown lecturers
		map.addAttribute("lecturers", majorService.lecturerDtos(null));
		
		// Generate update screen
		return "major/updateMajor";
	}
	
	/**
     * Update new major
     *
     * @param model
     * @param form
     * @param bindingResult
     *
     * @return  Success: List major screen
     *          Errors: Update input screen
     */
	
	@PostMapping("/updateMajor/{id}")
	public String update(ModelMap map, 
						@PathVariable long id, 
						@Valid MajorUpdateForm form,
						BindingResult bindingResult,
						HttpServletRequest request) {
		
		// Check errors
		if (bindingResult.hasErrors()) {
			
			// Set data for pulldown lecturers
			map.addAttribute("lecturers", majorService.lecturerDtos(null));
			
			// Generate update screen
			return "major/updateMajor";
		}
		
		// Cast DTO to Form
		MajorDto majorDto = (MajorDto) DataTransformUtil.transform(form, MajorDto.class);
		majorDto.setId(id);
		
		// Call service to update major
		majorService.update(majorDto);
		
		// message success
		SessionMessageDto sessionMessageDto = new SessionMessageDto();
        sessionMessageDto.setMessageCode("message.major.update.success");
        sessionMessageDto.setMessageArgs(majorDto.getName());
        request.getSession().setAttribute(CmnConst.MESSAGE_KEY_MAJOR, sessionMessageDto);
		
        // List major screen
		return "redirect:/major";
	}
	
}
