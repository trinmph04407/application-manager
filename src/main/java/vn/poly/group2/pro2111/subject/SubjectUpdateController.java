/**
 * 
 */
package vn.poly.group2.pro2111.subject;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;
import vn.poly.group2.pro2111.subject.dto.SubjectDto;
import vn.poly.group2.pro2111.subject.form.SubjectUpdateForm;
import vn.poly.group2.pro2111.subject.service.SubjectService;

/**
 * Subject update controller
 * 
 * @author minht
 * 
 */

@Controller
@RequestMapping("/subject")
public class SubjectUpdateController {
	
	/*=====================================================================================================
     *===== AUTOWIRED PROPERTIES                                                                      =====
     *=====================================================================================================*/
	
	@Autowired
    SubjectService subjectService;
	
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
	
	@GetMapping("/updateSubject/{id}")
	 public String input(ModelMap model,
			 			 @PathVariable Long id) {
		// Get data
        SubjectDto subjectDto = subjectService.detail(id);
        
        // Create new form
        SubjectUpdateForm form = (SubjectUpdateForm) DataTransformUtil.transform(subjectDto, SubjectUpdateForm.class);
        model.addAttribute("subjectUpdateForm", form);
        
        // Set data for pulldown lecturers
        model.addAttribute("lecturers", subjectService.lecturerDtos(null));
        
        // Set data for pulldown majors
        model.addAttribute("majors", subjectService.majorDtos(null));  
        
        // Generate update screen
        return "/subject/updateSubject";
    }
	
	/**
     * Update new subject
     *
     * @param model
     * @param form
     * @param bindingResult
     *
     * @return  Success: List subject screen
     *          Errors: Update input screen
     */
	
	@PostMapping("/updateSubject/{id}")
    public String submit(ModelMap model,@PathVariable Long id,
    					@Valid SubjectUpdateForm subjectUpdateForm,
                        BindingResult bindingResult, 
                        @RequestParam(required = false) MultipartFile file,
                        HttpServletRequest request) {
		
		 	// Check errors
		 	if (bindingResult.hasErrors()) {
		 		
		 		 // Set data for pulldown lecturers
	        	 model.addAttribute("lecturers", subjectService.lecturerDtos(null));
	        	 
	        	 // Set data for pulldown majors
	             model.addAttribute("majors", subjectService.majorDtos(null));
	            return "subject/updateSubject";	            
	        }
	        
		 	// Cast DTO to Form
	        SubjectDto subjectDto = (SubjectDto) DataTransformUtil.transform(subjectUpdateForm,SubjectDto.class);        
	        subjectDto.setId(id);
	        
	        // Call service to update subject
	        subjectService.update(subjectDto);
	        
	        //message success
	        SessionMessageDto sessionMessageDto = new SessionMessageDto();
	        sessionMessageDto.setMessageCode("message.subject.update.success");
	        sessionMessageDto.setMessageArgs(subjectDto.getName());
	        request.getSession().setAttribute(CmnConst.MESSAGE_KEY_SUBJECT, sessionMessageDto);
	        
	        // List subject screen
	        return "redirect:/subject";     
    }
}
