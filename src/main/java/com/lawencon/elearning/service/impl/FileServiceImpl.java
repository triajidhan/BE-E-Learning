package com.lawencon.elearning.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.elearning.dao.FileDao;
import com.lawencon.elearning.dto.file.FileDataDto;
import com.lawencon.elearning.dto.file.FileDto;
import com.lawencon.elearning.model.File;
import com.lawencon.elearning.service.FileService;


@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDao fileDao;


	@Override
	public FileDto getById(final Long id) {
		final Optional<File> fileOptional = fileDao.getById(id);
		final FileDataDto fileDataDto = new FileDataDto();
		final FileDto fileDto = new FileDto();
		if (fileOptional.isPresent()) {
			fileDataDto.setId(fileOptional.get().getId());
			fileDataDto.setFiles(fileOptional.get().getFiles());
			fileDataDto.setExtensions(fileOptional.get().getExtensions());
			fileDataDto.setVersion(fileOptional.get().getVersion());
			
			fileDto.setData(fileDataDto);
		}
		return fileDto;
	}

}
