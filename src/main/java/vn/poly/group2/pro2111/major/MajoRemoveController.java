/**
 * 
 */
package vn.poly.group2.pro2111.major;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.major.dto.MajorDto;
import vn.poly.group2.pro2111.major.service.MajorService;

/**
 * Major remove controller
 * 
 * @author minht
 * 
 */

@Controller
@RequestMapping("/major")
public class MajoRemoveController {
	
    /*=====================================================================================================
     *===== AUTOWIRED PROPERTIES                                                                      =====
     *=====================================================================================================*/
	
	@Autowired
	MajorService majorService;
	
    /*=====================================================================================================
     *===== MAPPING METHOD			                                                                  =====
     *=====================================================================================================*/
	
	 /**
     * Remove major
     *
     * @param HttpServletRequest
     *
     * @return  Success: List major screen
     *          Errors: List major screen
     */
	
	@GetMapping("/deleteMajor/{id}")
	public String user(@PathVariable Long id, 
					   HttpServletRequest request,
					   MajorDto majorDto) {
		try {
			// Call service to remove major
			majorService.remove(id);

			// message success
			SessionMessageDto sessionMessageDto = new SessionMessageDto();
			sessionMessageDto.setMessageCode("message.major.delete.success");
			sessionMessageDto.setMessageArgs(majorDto.getId());
			request.getSession().setAttribute(CmnConst.MESSAGE_KEY_MAJOR, sessionMessageDto);
			
			// List major screen
			return "redirect:/major";
			
		} catch (Exception e) {

			// message fail
			SessionMessageDto sessionMessageDto = new SessionMessageDto();
			sessionMessageDto.setMessageCode("message.major.delete.faill");
			sessionMessageDto.setMessageArgs(majorDto.getId());
			request.getSession().setAttribute(CmnConst.MESSAGE_KEY_MAJOR, sessionMessageDto);
			
			// List major screen
			return "redirect:/major";
		}
	}
}
