/**
 * 
 */
package vn.poly.group2.pro2111.subject.service.impl;


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
import vn.poly.group2.pro2111.common.entities.Subject;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;
import vn.poly.group2.pro2111.subject.dto.LecturerDto;
import vn.poly.group2.pro2111.subject.dto.MajorDto;
import vn.poly.group2.pro2111.subject.dto.SubjectDto;
import vn.poly.group2.pro2111.subject.repositories.LecturerRepository;
import vn.poly.group2.pro2111.subject.repositories.MajorRepository;
import vn.poly.group2.pro2111.subject.repositories.SubjectRepository;
import vn.poly.group2.pro2111.subject.service.SubjectService;

/**
 * Subject service implement
 * 
 * @author minht
 * 
 */
@Service
public class SubjectServiceImpl extends BaseService implements SubjectService{
	
	/*=====================================================================================================
     *===== AUTOWIRED PROPERTIES                                                                      =====
     *=====================================================================================================*/
	
	 @Autowired
	 @Qualifier("empMajorRepositoryImpl")
	 MajorRepository majorRepository;
	 
	 @Autowired
	 @Qualifier("empLecturerRepositoryImpl")
	 LecturerRepository lecturerRepository;
	 
	@Autowired
	SubjectRepository subjectRepository;
	
	/*=====================================================================================================
     *===== MAPPING METHOD                                                                            =====
     *=====================================================================================================*/
	
	@Override
	public List<MajorDto> majorDtos(String code) {
		
		 // search repository
		 List<Major> majorList = majorRepository.search(code);
		 
		 // Lecturer array
	     List<MajorDto> majorDtoList = new ArrayList<>();
	        for (Major major : majorList) {
	        	majorDtoList.add(
	                    (MajorDto) DataTransformUtil.transform(major, MajorDto.class));
	        }
	        
	       // Return dto list
	     return majorDtoList;
	}
	
	@Override
	public List<LecturerDto> lecturerDtos(String code) {
		 
		 // search repository
		 List<Lecturer> lecturerList = lecturerRepository.search(code);
		 
		 // Lecturer array
	     List<LecturerDto> lecturerDtoList = new ArrayList<>();
	        for (Lecturer lecturer : lecturerList) {
	        	lecturerDtoList.add(
	                    (LecturerDto) DataTransformUtil.transform(lecturer, LecturerDto.class));
	        }
	        // Return dto list
	        return lecturerDtoList;
	}

	@Override
	public ListDataDto<SubjectDto> list(Long majorId, Long lecturerId, String name, Long pn) {
		
		// Declare result data
		ListDataDto<SubjectDto> listDataDto = new ListDataDto<SubjectDto>();
		
		// Calculating paging
        ListPagingDto pagingDto = listDataDto.getPaging();
        pagingDto.setCurrentPage(pn);
        
        // Count record
        Long totalRecords = subjectRepository.count(majorId, lecturerId, name);
        pagingDto.setTotalRecords(totalRecords);

        // Check no result data
        if (totalRecords.intValue() == 0) {
            return listDataDto;
        }
        
        // Get list major
        List<Subject> subjectList = subjectRepository.select(majorId, lecturerId, name, pagingDto.getOffset(), pagingDto.getLimit());
        
        // Cast to major dto
        List<SubjectDto> subjectDtoList = new ArrayList<>();
        for (Subject subject : subjectList) {
        	
        	// Create new dto
        	SubjectDto subjectDto = (SubjectDto) DataTransformUtil.transform(subject, SubjectDto.class);
        	
             Major major = subject.getMajor();
             subjectDto.setMajorId(major.getId());
             subjectDto.setMajorName(major.getName());
             Lecturer lecturer = subject.getLecturer();
             subjectDto.setLecturerId(lecturer.getId());
             subjectDto.setLecturerName(lecturer.getName());          
             subjectDtoList.add(subjectDto);
        }
        
        // Set list into data dto
        listDataDto.setList(subjectDtoList);
        
        // Return data list
        return listDataDto;
	}

	@Override
	public SubjectDto detail(Long id) {
		
		// Get data
		Subject subject = subjectRepository.select(id);
		
		// Check existing
	    if (subject == null) {
	       throw new RuntimeException("Cannot find entity with id or It was deleted");
	    }   
	    
	    // Return detail DTO
	    return (SubjectDto) DataTransformUtil.transform(subject, SubjectDto.class);
	}

	@Override
	public Long create(SubjectDto subjectDto) {
		
		// Create new entity
		Subject subject = (Subject) DataTransformUtil.transform(subjectDto, Subject.class);
		
		// Return create result
        return subjectRepository.insert(subject);
	}

	@Override
	public Long update(SubjectDto subjectDto) {
		
		// Get id
		Subject subject = subjectRepository.select(subjectDto.getId());
		
		// Check existing
		if (subject == null) {
			throw new RuntimeException("Cannot find entity with id or It was deleted");
		}
		subject.setName(subjectDto.getName());
		subject.setMajorId(subjectDto.getMajorId());
		subject.setLecturerId(subjectDto.getLecturerId());
		
		// Return update result
		return subjectRepository.update(subject);
	}
	
	@Override
	public boolean remove(Long id) {
		
		// Get data
		Subject subject = subjectRepository.select(id);
		
		// Check existing
		if (subject == null) {
			throw new RuntimeException("Cannot find entity with id or It was deleted");
		}
		
		// Return remove result
		return subjectRepository.remove(id);
	}
	
	@Override
	public boolean check(String code) {
		
		// Return check result
		return subjectRepository.check(code);
	}

}
