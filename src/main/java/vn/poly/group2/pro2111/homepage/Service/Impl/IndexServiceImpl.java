/*
 * (C) Copyright 2018
 *
 * @auth Nguyen Van Doan
 * @date Aug 16, 2018
 */
package vn.poly.group2.pro2111.homepage.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.poly.group2.pro2111.common.bases.BaseService;
import vn.poly.group2.pro2111.homepage.Repositories.IndexRepository;
import vn.poly.group2.pro2111.homepage.Service.IndexService;

@Service
public class IndexServiceImpl extends BaseService implements IndexService {
	@Autowired
	private IndexRepository indexRepository;

	@Override
	public List<Object[]> listTop() {
		return indexRepository.listTop();
	}

}
