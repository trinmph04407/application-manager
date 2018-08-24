package vn.poly.group2.pro2111.lecturer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.lecturer.service.LecturerService;

@Controller
@RequestMapping("/lecturer")
public class LecturerRemoveController {

	@Autowired
	LecturerService lecturerService;

	@GetMapping("/deleteLecturer/{id}")
	public String user(@PathVariable Long id, HttpServletRequest request) {
		try {

			lecturerService.deleteLecturer(id);
			SessionMessageDto sessionMessageDto = new SessionMessageDto();
			sessionMessageDto.setMessageCode("message.lecturer.delete.success");
			sessionMessageDto.setMessageArgs(id);
			request.getSession().setAttribute(CmnConst.MESSAGE_KEY_LETURER, sessionMessageDto);

			return "redirect:/lecturer";
		} catch (Exception e) {
			SessionMessageDto sessionMessageDto = new SessionMessageDto();
			sessionMessageDto.setMessageCode("message.lecturer.delete.faill");
			sessionMessageDto.setMessageArgs(id);
			request.getSession().setAttribute(CmnConst.MESSAGE_KEY_LETURER, sessionMessageDto);
			return "redirect:/lecturer";
		}
	}
}
