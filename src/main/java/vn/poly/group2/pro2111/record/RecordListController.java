package vn.poly.group2.pro2111.record;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import vn.poly.group2.pro2111.common.bases.BaseController;
import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.record.dto.RecordDto;
import vn.poly.group2.pro2111.record.form.RecordSearchForm;
import vn.poly.group2.pro2111.record.service.RecordService;

@Controller
@RequestMapping("/record")
public class RecordListController extends BaseController {
	@Autowired
	private RecordService recordService;
	@Autowired
	HttpServletRequest rq;
	
	@GetMapping
	public String index(@RequestParam(required = false) Long lecturerId, @RequestParam(required = false) String typeRecord,
			@RequestParam(defaultValue = "1") Long pn, ModelMap model,	@SessionAttribute(name = "RECORD_MESSAGE", 
			required = false) SessionMessageDto sessionMessageDto) {
		
		RecordSearchForm form = new RecordSearchForm();
		form.setLecturerId(lecturerId);
		form.setTypeRecord(typeRecord);
		model.addAttribute("recordSearchForm", form);

		// Get list data with paging
		ListDataDto<RecordDto> ListDataDto = recordService.getListRecord(lecturerId, typeRecord, pn);
		
		 
		// Add list data
		model.addAttribute("listRecord", ListDataDto.getList());
		model.addAttribute("paging", ListDataDto.getPaging());
		
		model.addAttribute("lecturers", recordService.lecturers(null));
		 
		if (sessionMessageDto != null) {
            model.addAttribute("sessionMessageDto", sessionMessageDto);
            sessionMessageDto = null;
            rq.getSession().removeAttribute(CmnConst.MESSAGE_KEY_RECORD);
        }
		
		return "/record/listRecord";
	}
}
