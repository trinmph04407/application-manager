package vn.poly.group2.pro2111.record;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;
import vn.poly.group2.pro2111.lecturer.dto.LecturerDto;
import vn.poly.group2.pro2111.record.dto.RecordDto;
import vn.poly.group2.pro2111.record.form.RecordUpdateForm;
import vn.poly.group2.pro2111.record.service.RecordService;

@Controller
@RequestMapping("/record")
public class RecordUpdateController {
	@Autowired
	RecordService recordService;
	@Autowired
	HttpServletRequest rq;
	@GetMapping("/updateRecord/{id}")
	public String insert(ModelMap model,@PathVariable Long id) {
		RecordDto recordDto = recordService.getIdRecord(id);
		RecordUpdateForm form = (RecordUpdateForm) DataTransformUtil.transform(recordDto, RecordUpdateForm.class);
		model.addAttribute("lecturers", recordService.lecturers(null));
		model.addAttribute("recordUpdateForm", form);
		return "record/updateRecord";
	}
	
	
	@PostMapping(value="/updateRecord/{id}")
	public String updateRecord(ModelMap model,@Valid RecordUpdateForm form, BindingResult bindingResult) {
		
	if(bindingResult.hasErrors()) {
			model.addAttribute("lecturers", recordService.lecturers(null));
			return "/recordForm/updateRecord";
		}
		
		RecordDto recordDto = (RecordDto) DataTransformUtil.transform(form, RecordDto.class);
		recordService.updateRecord(recordDto);
		

		SessionMessageDto sessionMessageDto = new SessionMessageDto();
		sessionMessageDto.setMessageCode("message.record.update.success");
		sessionMessageDto.setMessageArgs(recordDto.getId());
		rq.getSession().setAttribute(CmnConst.MESSAGE_KEY_RECORD, sessionMessageDto);

		
		return "redirect:/record";
		
	}
	

	
}
