/**
 * 
 */
package vn.poly.group2.pro2111.major.service;

import java.util.List;

import vn.poly.group2.pro2111.common.bases.BaseServiceInterface;
import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.major.dto.LecturerDto;
import vn.poly.group2.pro2111.major.dto.MajorDto;

/**
 * Major service
 * 
 * @author minht
 * 
 */
public interface  MajorService  extends BaseServiceInterface {
	
	List<LecturerDto> lecturerDtos(String code);
	
	ListDataDto<MajorDto> list(Long lecturerId, String name, Long pn);
	
	MajorDto detail(Long id);
	
	Long create(MajorDto majorDto);
	
	Long update(MajorDto majorDto);
	
	boolean remove(Long id);
	
	boolean check(String code);
}
