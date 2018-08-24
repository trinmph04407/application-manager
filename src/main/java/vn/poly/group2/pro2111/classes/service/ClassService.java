package vn.poly.group2.pro2111.classes.service;

import java.util.List;

import vn.poly.group2.pro2111.classes.dto.ClassDto;
import vn.poly.group2.pro2111.classes.dto.LecturerDto;
import vn.poly.group2.pro2111.classes.dto.MajorDto;
import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.student.dto.StudentDto;

public interface ClassService {

	List<MajorDto> majorDtos(String code);

	List<LecturerDto> lecturerDtos(String code);

	ListDataDto<ClassDto> list(Long majorid, Long lecturerid, Long pn);

	ClassDto detail(Long id);
	
	boolean deleteCLass(Long id);

	boolean insertClass(ClassDto classDto);
	
	boolean editClass(ClassDto classDto);
	
	boolean checkId(String code);
	
	public List<StudentDto> listStudent();

}
