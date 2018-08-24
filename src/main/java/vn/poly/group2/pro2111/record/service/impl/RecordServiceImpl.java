/*
 *@Author P.Tuong
 *@Date Jul 17, 2018
 *@Version 1.0
*/
package vn.poly.group2.pro2111.record.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import vn.poly.group2.pro2111.common.bases.BaseService;
import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.common.dto.ListPagingDto;
import vn.poly.group2.pro2111.common.entities.Lecturer;
import vn.poly.group2.pro2111.common.entities.Record;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;
import vn.poly.group2.pro2111.record.dto.RecLecturerDto;
import vn.poly.group2.pro2111.record.dto.RecordDto;
import vn.poly.group2.pro2111.record.repositories.RecLecturerRepository;
import vn.poly.group2.pro2111.record.repositories.RecordRepository;
import vn.poly.group2.pro2111.record.service.RecordService;

@Service
public class RecordServiceImpl extends BaseService implements RecordService {
	@Autowired
	@Qualifier("recLecturerRepositoryImpl")
	RecLecturerRepository reclecturerRepository;
	@Autowired
	RecordRepository recordRepository;

	@Override
	public ListDataDto<RecordDto> getListRecord(Long lecturerId, String type, Long pn) {
		ListDataDto<RecordDto> listDataDto = new ListDataDto<RecordDto>();

		// Calculating paging
		ListPagingDto pagingDto = listDataDto.getPaging();
		pagingDto.setCurrentPage(pn);

		// Count record
		Long totalRecords = recordRepository.count(lecturerId, type);
		pagingDto.setTotalRecords(totalRecords);

		// Check no result data
		if (totalRecords.intValue() == 0) {
			return listDataDto;
		}

		// Get list department
		List<Record> recordList = recordRepository.select(lecturerId, type, pagingDto.getOffset(),
				pagingDto.getLimit());

		// Cast to department dto
		List<RecordDto> recordDtoList = new ArrayList<>();
		for (Record record : recordList) {
			RecordDto recordDto = (RecordDto) DataTransformUtil.transform(record, RecordDto.class);
			Lecturer lecturer = record.getLecturer();
			recordDto.setLecturerId(lecturer.getId());
			recordDto.setlecturerName(lecturer.getName());
			
			recordDtoList.add(recordDto);
			
		}

		// Set list into data dto
		listDataDto.setList(recordDtoList);

		// Return data
		return listDataDto;
	}
	
	
	@Override
	public List<RecLecturerDto> lecturers(String name) {
		 List<Lecturer> lecturerList = reclecturerRepository.search(name);

	        List<RecLecturerDto> lecturerDtoList = new ArrayList<>();
	        for (Lecturer lecturer : lecturerList) {
	        	lecturerDtoList.add(
	                    (RecLecturerDto) DataTransformUtil.transform(lecturer, RecLecturerDto.class));
	        }

	        return lecturerDtoList;
	}

	@Override
	public Long create(RecordDto recordDto) {
		Record record = (Record) DataTransformUtil.transform(recordDto, Record.class);

		return recordRepository.insert(record);
	}

	@Override
	public RecordDto getIdRecord(Long id) {
		Record record = recordRepository.getIdRecord(id);
		return (RecordDto) DataTransformUtil.transform(record, RecordDto.class);
	}

	@Override
	public List<RecordDto> ListRecord() {
		List<Record> recordList = recordRepository.ListRecord();

		if (CollectionUtils.isEmpty(recordList)) {
			return null;
		}

		List<RecordDto> recordDto = new ArrayList<>();
		for (Record record : recordList) {
			recordDto.add((RecordDto) DataTransformUtil.transform(record, RecordDto.class));
		}
		return recordDto;
	}

	@Override
	public Long updateRecord(RecordDto recordDto) {
		Record entity = recordRepository.getIdRecord(recordDto.getId());
		entity.setLecturerId(recordDto.getLecturerId());
		entity.setTypeRecord(recordDto.isTypeRecord());
		entity.setNote(recordDto.getNote());
		entity.setDateRecord(recordDto.getDateRecord());
		return recordRepository.update(entity);
	}

	@Override
	public boolean remove(Long id) {
		Record record = recordRepository.getIdRecord(id);

		if (record == null) {
			throw new RuntimeException("Cannot find entity with id or It was deleted");
		}

		return recordRepository.remove(id);
	}

}
