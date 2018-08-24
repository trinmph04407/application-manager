/*
 *@Author P.Tuong
 *@Date Jul 17, 2018
 *@Version 1.0
*/
package vn.poly.group2.pro2111.record.repositories;

import java.util.List;

import vn.poly.group2.pro2111.common.entities.Record;

public interface RecordRepository {
	public List<Record> select(Long lecturerId, String typeRecord, int offset, int limit);

	public Long count(Long lecturerId, String typeRecord);
	
	public Long insert(Record record);
	
	public Long update(Record record);
	
	public Record getIdRecord(Long id);
	
	public List<Record> ListRecord();
	
	public boolean remove(Long id);
	
}
