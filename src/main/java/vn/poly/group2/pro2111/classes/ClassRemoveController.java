package vn.poly.group2.pro2111.classes;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.poly.group2.pro2111.classes.service.ClassService;
import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;

@Controller
@RequestMapping("/class")
public class ClassRemoveController {

	@Autowired
	ClassService classService;

	@GetMapping("/deleteClass/{id}")
	public String user(@PathVariable Long id, HttpServletRequest request) {
		try {

			classService.deleteCLass(id);
			SessionMessageDto sessionMessageDto = new SessionMessageDto();
			sessionMessageDto.setMessageCode("message.class.delete.success");
			sessionMessageDto.setMessageArgs(id);
			request.getSession().setAttribute(CmnConst.MESSAGE_KEY_CLASS, sessionMessageDto);
			return "redirect:/class";
		} catch (Exception e) {
			SessionMessageDto sessionMessageDto = new SessionMessageDto();
			sessionMessageDto.setMessageCode("message.class.delete.faill");
			sessionMessageDto.setMessageArgs(id);
			request.getSession().setAttribute(CmnConst.MESSAGE_KEY_CLASS, sessionMessageDto);
			return "redirect:/class";
		}
	}
}
