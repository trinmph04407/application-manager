package vn.poly.group2.pro2111.lecturer.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vn.poly.group2.pro2111.common.bases.BaseRepository;
import vn.poly.group2.pro2111.common.dto.ListDataDto;
import vn.poly.group2.pro2111.common.dto.ListPagingDto;
import vn.poly.group2.pro2111.common.entities.Lecturer;
import vn.poly.group2.pro2111.common.utils.DataTransformUtil;
import vn.poly.group2.pro2111.lecturer.dto.LecturerDto;
import vn.poly.group2.pro2111.lecturer.repositories.LecturerRepository;
import vn.poly.group2.pro2111.lecturer.service.LecturerService;

@Service
public class LecturerServiceImpl extends BaseRepository implements LecturerService {

	@Autowired
	private LecturerRepository lecturerRepository;

	@Autowired
	private ServletContext context;

	@Override
	public ListDataDto<LecturerDto> list(String code, String name, Long pn) {

		ListDataDto<LecturerDto> listDataDto = new ListDataDto<LecturerDto>();

		ListPagingDto pagingDto = listDataDto.getPaging();
		pagingDto.setCurrentPage(pn);

		Long totalRecords = lecturerRepository.count(code, name);
		pagingDto.setTotalRecords(totalRecords);

		if (totalRecords.intValue() == 0) {
			return listDataDto;
		}

		List<Lecturer> lecturerList = lecturerRepository.select(code, name, pagingDto.getOffset(),
				pagingDto.getLimit());

		List<LecturerDto> lecturerDtos = new ArrayList<>();
		for (Lecturer lecturer : lecturerList) {
			lecturerDtos.add((LecturerDto) DataTransformUtil.transform(lecturer, LecturerDto.class));
		}

		listDataDto.setList(lecturerDtos);

		return listDataDto;
	}

	@Override
	public boolean deleteLecturer(Long id) {
		return lecturerRepository.deleteLecturer(id);
	}

	@Override
	public boolean insertLecturer(LecturerDto lecturerDto) {
		Lecturer entity = (Lecturer) DataTransformUtil.transform(lecturerDto, Lecturer.class);
		return lecturerRepository.insertLecturer(entity);
	}

	@Override
	public LecturerDto getLecturerID(Long id) {
		Lecturer lecturer = lecturerRepository.getLecturerId(id);
		return (LecturerDto) DataTransformUtil.transform(lecturer, LecturerDto.class);
	}

	@Override
	public boolean editLecturer(LecturerDto lecturerDto) {
		
		Lecturer lecturer = lecturerRepository.getLecturerId(lecturerDto.getId());
		
		if (lecturer == null) {
			throw new RuntimeException("Cannot find entity with id or It was deleted");
		}
		lecturer.setName(lecturerDto.getName());
		lecturer.setCode(lecturerDto.getCode());
		lecturer.setPhoto(lecturerDto.getPhoto());
		lecturer.setEmail(lecturerDto.getEmail());
		lecturer.setPhone(lecturerDto.getPhone());
		lecturer.setSalary(lecturerDto.getSalary());
		
		return lecturerRepository.editLecturer(lecturer);
	}

	@Override
	public String saveImage(String code, MultipartFile file) {
		String uploadFileSavePath = context.getRealPath("/WEB-INF/anh/");
		String originalFileName = file.getOriginalFilename();

		StringBuilder stbFilePath = new StringBuilder(uploadFileSavePath);
		stbFilePath.append(code);
		stbFilePath.append(originalFileName.substring(originalFileName.lastIndexOf('.')));

		File saveFile = new File(stbFilePath.toString());
		try {
			logger.info("Save image into: " + stbFilePath.toString());
			file.transferTo(saveFile);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return stbFilePath.toString().replace(uploadFileSavePath, StringUtils.EMPTY);
	}

	@Override
	public boolean checkId(String code) {
		return lecturerRepository.checkId(code);
	}

}
