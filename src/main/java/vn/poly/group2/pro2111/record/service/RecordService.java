/*
 *@Author P.Tuong
 *@Date Jul 17, 2018
 *@Version 1.0
*/
package vn.poly.group2.pro2111.record.service;

import java.util.List;

import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.record.dto.RecLecturerDto;
import vn.poly.group2.pro2111.record.dto.RecordDto;

public interface RecordService {
	public ListDataDto<RecordDto> getListRecord(Long lecturerId, String type, Long pn);

	Long create(RecordDto recordDto);

	public RecordDto getIdRecord(Long id);

	public List<RecordDto> ListRecord();

	public List<RecLecturerDto> lecturers(String name);

	public Long updateRecord(RecordDto recordDto);

	public boolean remove(Long id);
	
}
