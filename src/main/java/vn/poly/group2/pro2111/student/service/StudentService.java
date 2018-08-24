package vn.poly.group2.pro2111.student.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import vn.poly.group2.pro2111.classes.dto.ClassDto;
import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.major.dto.MajorDto;
import vn.poly.group2.pro2111.student.dto.StudentDto;

public interface StudentService {
	ListDataDto<StudentDto> list(String code, String name, Long pn);

	StudentDto detail(Long id);

	boolean deleteStudent(Long id);

	boolean insertStudent(StudentDto StudentDto);

	boolean editStudnet(StudentDto StudentDto);

	boolean checkId(String code);

	List<ClassDto> listClass();
	
	List<MajorDto> listMajor();
	
	String saveImage(String code, MultipartFile file);

}
