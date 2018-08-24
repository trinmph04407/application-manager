/*
 *@Author P.Tuong
 *@Date Jul 19, 2018
 *@Version 1.0
*/
package vn.poly.group2.pro2111.record.repositories;

import java.util.List;

import vn.poly.group2.pro2111.common.entities.Lecturer;

public interface RecLecturerRepository {
	public List<Lecturer> search(String name);
}
