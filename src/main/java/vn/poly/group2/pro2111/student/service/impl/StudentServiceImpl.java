package vn.poly.group2.pro2111.student.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang3.StringUtils;

import vn.poly.group2.pro2111.classes.dto.ClassDto;
import vn.poly.group2.pro2111.common.bases.BaseService;
import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.common.dto.ListPagingDto;
import vn.poly.group2.pro2111.common.entities.Clasess;
import vn.poly.group2.pro2111.common.entities.Major;
import vn.poly.group2.pro2111.common.entities.Student;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;
import vn.poly.group2.pro2111.major.dto.MajorDto;
import vn.poly.group2.pro2111.student.dto.StudentDto;
import vn.poly.group2.pro2111.student.repositories.StudentRepository;
import vn.poly.group2.pro2111.student.service.StudentService;

@Service
public class StudentServiceImpl extends BaseService implements StudentService {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	ServletContext context;
	@Override
	public ListDataDto<StudentDto> list(String code, String name, Long pn) {
		// Declare result data
		ListDataDto<StudentDto> listDataDto = new ListDataDto<StudentDto>();

		// Calculating paging
		ListPagingDto pagingDto = listDataDto.getPaging();
		pagingDto.setCurrentPage(pn);

		// Count record
		Long totalRecords = studentRepository.count(code, name);
		pagingDto.setTotalRecords(totalRecords);

		// Check no result data
		if (totalRecords.intValue() == 0) {
			return listDataDto;
		}

		// Get list records
		List<Student> staffsList = studentRepository.select(code, name, pagingDto.getOffset(), pagingDto.getLimit());

		// Check record list
		if (CollectionUtils.isEmpty(staffsList)) {
			return null;
		}

		// Cast to staffs dto
		List<StudentDto> studentDtoList = new ArrayList<>();
		for (Student student : staffsList) {
			studentDtoList.add((StudentDto) DataTransformUtil.transform(student, StudentDto.class));
		}
		listDataDto.setList(studentDtoList);
		return listDataDto;
	}

	@Override
	public StudentDto detail(Long id) {
		Student student = studentRepository.selectStudent(id);

		if (student == null) {
			throw new RuntimeException("Cannot find entity with id or It was deleted");
		}

		return (StudentDto) DataTransformUtil.transform(student, StudentDto.class);
	}

	@Override
	public boolean deleteStudent(Long id) {
		return studentRepository.remove(id);
	}

	@Override
	public boolean insertStudent(StudentDto StudentDto) {
		Student entity = (Student) DataTransformUtil.transform(StudentDto, Student.class);
		return studentRepository.insert(entity);
	}

	@Override
	public boolean editStudnet(StudentDto StudentDto) {
		Student student = studentRepository.selectStudent(StudentDto.getId());

		if (student == null) {
			throw new RuntimeException("Cannot find entity with id or It was deleted");
		}
		student.setCode(StudentDto.getCode());
		student.setName(StudentDto.getName());
		student.setEmail(StudentDto.getEmail());
		student.setPhone(StudentDto.getPhone());
		student.setPhoto(StudentDto.getPhoto());
		student.setNote(StudentDto.getNote());
		student.setClassid(StudentDto.getClassid());
		student.setMajorid(StudentDto.getMajorid());
		return studentRepository.update(student);
	}

	@Override
	public boolean checkId(String code) {
		return studentRepository.checkId(code);
	}

	@Override
	public List<ClassDto> listClass() {
		List<Clasess> listClass = studentRepository.listClass();
		List<ClassDto> classDtoList = new ArrayList<>();
		for (Clasess classess : listClass) {
			classDtoList.add((ClassDto) DataTransformUtil.transform(classess, ClassDto.class));
		}
		return classDtoList;
	}

	@Override
	public List<MajorDto> listMajor() {
		List<Major> listMajor = studentRepository.listMajor();
		List<MajorDto> majorDtoList = new ArrayList<>();
		for (Major major : listMajor) {
			majorDtoList.add((MajorDto) DataTransformUtil.transform(major, MajorDto.class));
		}
		return majorDtoList;
	}

	@Override
	public String saveImage(String code, MultipartFile file) {
		String uploadFileSavePath = context.getRealPath("/WEB-INF/upload/");
		String originalFileName = file.getOriginalFilename();

		StringBuilder stbFilePath = new StringBuilder(uploadFileSavePath);
		stbFilePath.append(code);
		stbFilePath.append(originalFileName.substring(originalFileName.lastIndexOf('.')));

		File saveFile = new File(stbFilePath.toString());
		try {
			logger.info("Save image into: " + stbFilePath.toString());
			file.transferTo(saveFile);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return stbFilePath.toString().replace(uploadFileSavePath, StringUtils.EMPTY);
	}

}
