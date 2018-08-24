package vn.poly.group2.pro2111.lecturer.service;


import org.springframework.web.multipart.MultipartFile;

import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.lecturer.dto.LecturerDto;


public interface LecturerService {

	ListDataDto<LecturerDto> list(String code, String name, Long pn);

	boolean deleteLecturer(Long id);

	boolean insertLecturer(LecturerDto lecturerDto);

	LecturerDto getLecturerID(Long id);

	boolean editLecturer(LecturerDto lecturerDto);

	String saveImage(String code, MultipartFile file);

	boolean checkId(String code);
}
