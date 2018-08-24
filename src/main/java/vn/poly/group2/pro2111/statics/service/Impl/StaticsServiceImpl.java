/*
 * (C) Copyright 2018
 *
 * @auth Nguyen Van Doan
 * @date Aug 14, 2018
 */
package vn.poly.group2.pro2111.statics.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.poly.group2.pro2111.common.bases.BaseService;
import vn.poly.group2.pro2111.statics.repositories.StaticsRepository;
import vn.poly.group2.pro2111.statics.service.StaticsService;

@Service
public class StaticsServiceImpl extends BaseService implements StaticsService {
	@Autowired
	StaticsRepository staticsRepository;

	@Override
	public List<Object[]> listStatics() {
		// TODO Auto-generated method stub
		return staticsRepository.listStatics();
	}

}
