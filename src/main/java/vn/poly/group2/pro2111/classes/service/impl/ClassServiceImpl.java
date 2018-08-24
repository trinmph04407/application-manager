package vn.poly.group2.pro2111.classes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import vn.poly.group2.pro2111.classes.dto.ClassDto;
import vn.poly.group2.pro2111.classes.dto.LecturerDto;
import vn.poly.group2.pro2111.classes.dto.MajorDto;
import vn.poly.group2.pro2111.classes.repositories.ClassRepository;
import vn.poly.group2.pro2111.classes.repositories.LecturerRepository;
import vn.poly.group2.pro2111.classes.repositories.MajorRepository;
import vn.poly.group2.pro2111.classes.service.ClassService;
import vn.poly.group2.pro2111.common.bases.BaseService;
import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.common.dto.ListPagingDto;
import vn.poly.group2.pro2111.common.entities.Clasess;
import vn.poly.group2.pro2111.common.entities.Lecturer;
import vn.poly.group2.pro2111.common.entities.Major;
import vn.poly.group2.pro2111.common.entities.Student;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;
import vn.poly.group2.pro2111.student.dto.StudentDto;

@Service
public class ClassServiceImpl extends BaseService implements ClassService {

	@Autowired
	@Qualifier("empMajorRepositoryImpl1")
	MajorRepository majorRepository;

	@Autowired
	@Qualifier("empLecturerRepositoryImpl1")
	LecturerRepository lecturerRepository;

	@Autowired
	ClassRepository classRepository;

	@Override
	public List<MajorDto> majorDtos(String code) {
		List<Major> majorList = majorRepository.search(code);

		List<MajorDto> majorDtoList = new ArrayList<>();
		for (Major major : majorList) {
			majorDtoList.add((MajorDto) DataTransformUtil.transform(major, MajorDto.class));
		}

		return majorDtoList;
	}

	@Override
	public List<LecturerDto> lecturerDtos(String code) {
		List<Lecturer> lecturerList = lecturerRepository.search(code);

		List<LecturerDto> lecturerDtoList = new ArrayList<>();
		for (Lecturer lecturer : lecturerList) {
			lecturerDtoList.add((LecturerDto) DataTransformUtil.transform(lecturer, LecturerDto.class));
		}

		return lecturerDtoList;
	}

	@Override
	public ListDataDto<ClassDto> list(Long majorid, Long lecturerid, Long pn) {

		ListDataDto<ClassDto> listDataDto = new ListDataDto<ClassDto>();

		ListPagingDto pagingDto = listDataDto.getPaging();
		pagingDto.setCurrentPage(pn);

		Long totalRecords = classRepository.count(majorid, lecturerid);
		pagingDto.setTotalRecords(totalRecords);

		if (totalRecords.intValue() == 0) {
			return listDataDto;
		}

		List<Clasess> classList = classRepository.select(majorid, lecturerid, pagingDto.getOffset(),
				pagingDto.getLimit());
		List<ClassDto> classDtoList = new ArrayList<>();

		for (Clasess clasess : classList) {

			ClassDto classDto = (ClassDto) DataTransformUtil.transform(clasess, ClassDto.class);

			Major major = clasess.getMajor();

			classDto.setMajorid(major.getId());
			classDto.setMajorName1(major.getName());

			Lecturer lecturer = clasess.getLecturer();

			classDto.setLecturerid(lecturer.getId());
			classDto.setLecturerName1(lecturer.getName());

			classDtoList.add(classDto);

		}

		listDataDto.setList(classDtoList);

		return listDataDto;
	}

	@Override
	public ClassDto detail(Long id) {
		Clasess clasess = classRepository.select(id);

		if (clasess == null) {
			throw new RuntimeException("Cannot find entity with id or It was deleted");
		}

		return (ClassDto) DataTransformUtil.transform(clasess, ClassDto.class);
	}

	@Override
	public boolean deleteCLass(Long id) {
		return classRepository.remove(id);
	}

	@Override
	public boolean insertClass(ClassDto classDto) {
		Clasess entity = (Clasess) DataTransformUtil.transform(classDto, Clasess.class);
		return classRepository.insert(entity);
	}

	
	@Override
	public boolean editClass(ClassDto classDto) {
		Clasess clasess = classRepository.select(classDto.getId());

		if (clasess == null) {
			throw new RuntimeException("Cannot find entity with id or It was deleted");
		}
		clasess.setCode(classDto.getCode());
		clasess.setLecturerid(classDto.getLecturerid());
		clasess.setMajorid(classDto.getMajorid());

		return classRepository.update(clasess);
	}

	@Override
	public boolean checkId(String code) {
		return classRepository.checkId(code);
	}

	@Override
	public List<StudentDto> listStudent() {
		List<Student> list = classRepository.listStudent();
		List<StudentDto> studentDto = new ArrayList<>();
		for (Student student : list) {
			studentDto.add((StudentDto) DataTransformUtil.transform(student, StudentDto.class));
		}
		return studentDto;
	}
	
	
	

}
