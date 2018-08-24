/**
 * 
 */
package vn.poly.group2.pro2111.major.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import vn.poly.group2.pro2111.common.bases.BaseService;
import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.common.dto.ListPagingDto;
import vn.poly.group2.pro2111.common.entities.Lecturer;
import vn.poly.group2.pro2111.common.entities.Major;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;
import vn.poly.group2.pro2111.major.dto.LecturerDto;
import vn.poly.group2.pro2111.major.dto.MajorDto;
import vn.poly.group2.pro2111.major.repositories.LecturerRepository;
import vn.poly.group2.pro2111.major.repositories.MajorRepository;
import vn.poly.group2.pro2111.major.service.MajorService;

/**
 * Major service implement
 * 
 * @author minht
 * 
 */

@Service
public class MajorServiceImpl extends BaseService implements MajorService {

	/*=====================================================================================================
     *===== AUTOWIRED PROPERTIES                                                                      =====
     *=====================================================================================================*/

	@Autowired
	MajorRepository majorRepository;

	@Autowired
	@Qualifier("emLecturerRepositoryImpl")
	LecturerRepository lecturerRepository;

	/*=====================================================================================================
     *===== MAPPING METHOD                                                                            =====
     *=====================================================================================================*/

	@Override
	public List<LecturerDto> lecturerDtos(String code) {

		// search repository
		List<Lecturer> lecturerList = lecturerRepository.search(code);

		// Lecturer array
		List<LecturerDto> lecturerDtoList = new ArrayList<>();
			for (Lecturer lecturer : lecturerList) {
				lecturerDtoList.add((LecturerDto) DataTransformUtil.transform(lecturer, LecturerDto.class));
			}
		
		// Return dto list
		return lecturerDtoList;
	}

	@Override
	public ListDataDto<MajorDto> list(Long lecturerId, String name, Long pn) {

		// Declare result data
		ListDataDto<MajorDto> listDataDto = new ListDataDto<MajorDto>();

		// Calculating paging
		ListPagingDto pagingDto = listDataDto.getPaging();
		pagingDto.setCurrentPage(pn);

		// Count record
		Long totalRecords = majorRepository.count(lecturerId, name);
		pagingDto.setTotalRecords(totalRecords);

		// Check no result data
		if (totalRecords.intValue() == 0) {
			return listDataDto;
		}

		// Get list major
		List<Major> majorList = majorRepository.select(lecturerId, name, pagingDto.getOffset(), pagingDto.getLimit());

		// Cast to major dto
		List<MajorDto> majorListDto = new ArrayList<>();
		for (Major major : majorList) {

			// Create new dto
			MajorDto majorDto = (MajorDto) DataTransformUtil.transform(major, MajorDto.class);

			Lecturer lecturer = major.getLecturer();
			majorDto.setLecturerId(lecturer.getId());
			majorDto.setLecturerName(lecturer.getName());
			majorListDto.add(majorDto);
		}

		// Set list into data dto
		listDataDto.setList(majorListDto);

		// Return data list
		return listDataDto;
	}

	@Override
	public MajorDto detail(Long id) {

		// Get data
		Major major = majorRepository.select(id);

		// Check existing
		if (major == null) {
			throw new RuntimeException("Cannot find entity with id or It was deleted");
		}

		// Return detail DTO
		return (MajorDto) DataTransformUtil.transform(major, MajorDto.class);
	}

	@Override
	public Long create(MajorDto majorDto) {

		// Create new entity
		Major major = (Major) DataTransformUtil.transform(majorDto, Major.class);

		// Return create result
		return majorRepository.insert(major);
	}

	@Override
	public Long update(MajorDto majorDto) {

		// Get id
		Major major = majorRepository.select(majorDto.getId());

		// Check existing
		if (major == null) {
			throw new RuntimeException("Cannot find entity with id or It was deleted");
		}

		major.setName(majorDto.getName());
		major.setLecturerId(majorDto.getLecturerId());

		// Return update result
		return majorRepository.update(major);
	}

	@Override
	public boolean remove(Long id) {

		// Get data
		Major major = majorRepository.select(id);

		// Check existing
		if (major == null) {
			throw new RuntimeException("Cannot find entity with id or It was deleted");
		}

		// Return remove result
		return majorRepository.remove(id);
	}

	@Override
	public boolean check(String code) {

		// Return check result
		return majorRepository.check(code);
	}

}
