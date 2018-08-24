/*
 *@Author P.Tuong
 *@Date Jul 18, 2018
 *@Version 1.0
*/
package vn.poly.group2.pro2111.account.repositories;

import java.util.List;

import vn.poly.group2.pro2111.common.bases.BaseRepositoryInterface;
import vn.poly.group2.pro2111.common.entities.Lecturer;

public interface LecturerRepository extends BaseRepositoryInterface {
	  List<Lecturer> search(Long id);
}
