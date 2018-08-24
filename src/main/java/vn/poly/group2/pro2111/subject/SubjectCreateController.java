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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;
import vn.poly.group2.pro2111.subject.dto.SubjectDto;
import vn.poly.group2.pro2111.subject.form.SubjectCreateForm;
import vn.poly.group2.pro2111.subject.service.SubjectService;

/**
 * Subject create controller
 * 
 * @author minht
 * 
 */

@Controller
@RequestMapping("/subject")
public class SubjectCreateController {
	
	/*=====================================================================================================
     *===== AUTOWIRED PROPERTIES                                                                      =====
     *=====================================================================================================*/
	
	@Autowired
    SubjectService subjectService;
	
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
	
	@GetMapping("/createSubject")
    public String input(ModelMap model,
    					SubjectCreateForm subjectCreateForm) {
		
		// Set data for pulldown lecturers
        model.addAttribute("lecturers", subjectService.lecturerDtos(null));
        
        // Set data for pulldown majors
        model.addAttribute("majors", subjectService.majorDtos(null));
        
        // Generate create screen
        return "/subject/createSubject";
    }
	
	 /**
     * Create new subject
     *
     * @param model
     * @param form
     * @param bindingResult
     *
     * @return  Success: List subject screen
     *          Errors: Create input screen
     */
	
	@PostMapping("/createSubject")
	    public String submit(ModelMap model,
	    					@Valid SubjectCreateForm subjectCreateForm,
	                        BindingResult bindingResult, 
	                        @RequestParam(required = false) MultipartFile file,
	                        HttpServletRequest request) {
			 //Check code
			 String code = request.getParameter("code");
			 
				if (subjectService.check(code) == true) {
					bindingResult.rejectValue("code", "errors.duplicate");
					
					// Set data for pulldown lecturers
					model.addAttribute("lecturers", subjectService.lecturerDtos(null));
					
					// Set data for pulldown majors
		            model.addAttribute("majors", subjectService.majorDtos(null));
		            
		            // Generate create screen
					return "subject/createSubject";
				}
				
				// Check errors  
				else if (bindingResult.hasErrors()) {
					
					// Set data for pulldown lecturers 
		        	model.addAttribute("lecturers", subjectService.lecturerDtos(null));
		        	
		        	// Set data for pulldown majors
		            model.addAttribute("majors", subjectService.majorDtos(null));
		            
		            // Generate create screen
		            return "subject/createSubject";	            
		        }
				 // Cast DTO to Form
		        SubjectDto subjectDto = (SubjectDto) DataTransformUtil.transform(subjectCreateForm,SubjectDto.class);		        
		        subjectDto.setCode(subjectCreateForm.getCode());
		        subjectDto.setName(subjectCreateForm.getName());
		        subjectDto.setMajorId(subjectCreateForm.getMajorId());
		        subjectDto.setLecturerId(subjectCreateForm.getLecturerId());
		        
		        // Call service to insert new subject
		        subjectService.create(subjectDto);
		        
		        //message success
		        SessionMessageDto sessionMessageDto = new SessionMessageDto();
		        sessionMessageDto.setMessageCode("message.subject.create.success");
		        sessionMessageDto.setMessageArgs(subjectDto.getName());
		        request.getSession().setAttribute(CmnConst.MESSAGE_KEY_SUBJECT, sessionMessageDto);
		        
		        // List major screen
		        return "redirect:/subject";	       
	    }

}
