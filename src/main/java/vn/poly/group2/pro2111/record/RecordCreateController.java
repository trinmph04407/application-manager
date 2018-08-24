package vn.poly.group2.pro2111.record;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.poly.group2.pro2111.common.constant.CmnConst;
import vn.poly.group2.pro2111.common.dto.SessionMessageDto;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;
import vn.poly.group2.pro2111.record.dto.RecordDto;
import vn.poly.group2.pro2111.record.form.RecordCreateForm;
import vn.poly.group2.pro2111.record.service.RecordService;

@Controller
@RequestMapping("/record")
public class RecordCreateController {
	@Autowired
	RecordService recordService;
	@Autowired
	HttpServletRequest rq;
	@GetMapping("/createRecord")
	public String insert(ModelMap model) {
		model.addAttribute("recordCreateForm",new RecordCreateForm());
		 model.addAttribute("lecturers", recordService.lecturers(null));
		return "record/createRecord";
	}
	
	@PostMapping("/createRecord")
    public String submit(ModelMap model, @Valid RecordCreateForm recordCreateForm,
                        BindingResult bindingResult) {

        /*// Validate data
        validateFormData(employeeCreateForm, bindingResult);*/

        // Check errors
        if (bindingResult.hasErrors()) {
        	model.addAttribute("lecturers", recordService.lecturers(null));
            return "/record/createRecord";
        }
        
        
        RecordDto recordDto = (RecordDto) DataTransformUtil.transform(recordCreateForm, RecordDto.class);
        recordDto.setLecturerId(recordCreateForm.getLecturerId());
        recordDto.setTypeRecord(recordCreateForm.isTypeRecord());
        recordDto.setDateRecord(recordCreateForm.getDateRecord());
        recordDto.setNote(recordCreateForm.getNote());
        
        recordService.create(recordDto);
       
        
     // message success
     		SessionMessageDto sessionMessageDto = new SessionMessageDto();
     		sessionMessageDto.setMessageCode("message.record.create.success");
     		sessionMessageDto.setMessageArgs(recordDto.getId());
     		rq.getSession().setAttribute(CmnConst.MESSAGE_KEY_RECORD, sessionMessageDto);

 
        return "redirect:/record";
    }

}
