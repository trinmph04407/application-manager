/**
 * 
 */
package vn.poly.group2.pro2111.subject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.subject.dto.SubjectDto;
import vn.poly.group2.pro2111.subject.service.SubjectService;

/**
 * Subject remove controller
 * 
 * @author minht
 * 
 */

@Controller
@RequestMapping("/subject")
public class SubjectRemoveController {
	
	/*=====================================================================================================
     *===== AUTOWIRED PROPERTIES                                                                      =====
     *=====================================================================================================*/
	
	@Autowired
    SubjectService subjectService;
	
	 /*=====================================================================================================
     *===== MAPPING METHOD			                                                                  =====
     *=====================================================================================================*/
	
	 /**
     * Remove subject
     *
     * @param HttpServletRequest
     *
     * @return  Success: List subject screen
     *          Errors: List suject screen
     */
	
	@GetMapping("/deleteSubject/{id}")
	public String index( @PathVariable Long id,
						 HttpServletRequest request,
						 SubjectDto subjectDto) {
		try {
			
			// Call service to remove major
			subjectService.remove(id);
			
			 //message success
	        SessionMessageDto sessionMessageDto = new SessionMessageDto();
	        sessionMessageDto.setMessageCode("message.subject.delete.success");
	        sessionMessageDto.setMessageArgs(subjectDto.getId());
	        request.getSession().setAttribute(CmnConst.MESSAGE_KEY_SUBJECT, sessionMessageDto);
			
	        // List subject screen
			return "redirect:/subject";
		} catch (Exception e) {
			
			//message fail
	        SessionMessageDto sessionMessageDto = new SessionMessageDto();
	        sessionMessageDto.setMessageCode("message.subject.delete.faill");
	        sessionMessageDto.setMessageArgs(subjectDto.getId());
	        request.getSession().setAttribute(CmnConst.MESSAGE_KEY_SUBJECT, sessionMessageDto);
	        
	        // List subject screen
			return "redirect:/subject";
		}
	}
}
