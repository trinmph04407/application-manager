/**
 * 
 */
package vn.poly.group2.pro2111.subject.service;

import java.util.List;

import vn.poly.group2.pro2111.common.bases.BaseServiceInterface;
import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.subject.dto.LecturerDto;
import vn.poly.group2.pro2111.subject.dto.MajorDto;
import vn.poly.group2.pro2111.subject.dto.SubjectDto;

/**
 * Subject service
 * 
 * @author minht
 * 
 */
public interface SubjectService extends BaseServiceInterface {
	
		List<MajorDto> majorDtos(String code);
		
		List<LecturerDto> lecturerDtos(String code);

	    ListDataDto<SubjectDto> list(Long majorId,Long lecturerId, String name, Long pn);

	    SubjectDto detail(Long id);
	    
	    Long create(SubjectDto subjectDto);
	    
	    Long update(SubjectDto subjectDto);
	    
	    boolean remove(Long id);
	    
	    boolean check(String code);

}
