package com.lawencon.elearning.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.elearning.dao.FileDao;
import com.lawencon.elearning.model.File;

@RestController
@RequestMapping("files")
public class FileController {

	@Autowired
	FileDao fileDao;
	
	@GetMapping("download/{id}")
    public ResponseEntity<?> download(@PathVariable("id") final Long id) {
        final File file = fileDao.getById(id).get();
        final byte[] fileBytes = Base64.getDecoder().decode(file.getFiles());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=attachment." + file.getExtensions())
                .body(fileBytes);
    }
}
