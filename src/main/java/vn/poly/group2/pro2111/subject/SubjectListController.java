package vn.poly.group2.pro2111.subject;

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
import vn.poly.group2.pro2111.subject.dto.SubjectDto;
import vn.poly.group2.pro2111.subject.form.SubjectSearchForm;
import vn.poly.group2.pro2111.subject.service.SubjectService;

/**
 * Subject list controller
 * 
 * @author minht
 * 
 */

@Controller
@RequestMapping("/subject")
public class SubjectListController {
	
    /*=====================================================================================================
     *===== AUTOWIRED PROPERTIES                                                                      =====
     *=====================================================================================================*/
	
	@Autowired
	SubjectService subjectService;
	
	/*=====================================================================================================
     *===== MAPPING METHOD                                                                            =====
     *=====================================================================================================*/
	
	 /**
     * Generate subject list screen
     *
     * @param model
     * @param form
     * 
     * @return Major list screen
     */
	
	 @GetMapping
	    public String index(ModelMap model, @RequestParam(required = false) Long majorId,
	                                        @RequestParam(required = false) Long lecturerId,
	                                        @RequestParam(required = false) String name,
	                                        @RequestParam(defaultValue = "1") Long pn,
	                                        @SessionAttribute(name = "SUBJECT_MESSAGE", required = false) SessionMessageDto sessionMessageDto,
	                                        HttpServletRequest request) {

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

	        // Set data for pulldown majors
	        model.addAttribute("majors", subjectService.majorDtos(null));
	        
	        // Set data for pulldown lecturers
	        model.addAttribute("lecturers", subjectService.lecturerDtos(null));
	        
	        // Get message
	        if (sessionMessageDto != null) {
	            model.addAttribute("sessionMessageDto", sessionMessageDto);
	            sessionMessageDto = null;
	            request.getSession().removeAttribute(CmnConst.MESSAGE_KEY_SUBJECT);
	        }

	        // Return list screen
	        return "/subject/listSubject";
	    }
}
