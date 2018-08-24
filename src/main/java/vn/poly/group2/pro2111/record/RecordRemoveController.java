package vn.poly.group2.pro2111.record;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.record.service.RecordService;

@Controller
@RequestMapping("/record")
public class RecordRemoveController {
	
	@Autowired
	RecordService recordService;
	@Autowired
	HttpServletRequest rq;
	
	@GetMapping("/deleteRecord/{id}")
	public String remove( @PathVariable Long id,HttpServletRequest request) {
		try {
			recordService.remove(id);
			SessionMessageDto sessionMessageDto = new SessionMessageDto();
	        sessionMessageDto.setMessageCode("message.record.delete.success");
	        sessionMessageDto.setMessageArgs(id);
	        rq.getSession().setAttribute(CmnConst.MESSAGE_KEY_RECORD, sessionMessageDto); 
		} catch (Exception e) {
			SessionMessageDto sessionMessageDto = new SessionMessageDto();
	        sessionMessageDto.setMessageCode("message.record.delete.fail");
	        sessionMessageDto.setMessageArgs(id);
	        rq.getSession().setAttribute(CmnConst.MESSAGE_KEY_RECORD, sessionMessageDto); 
		}
		
	
		return "redirect:/record";
	}

}
