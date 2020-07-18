package com.it.service.impl;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.it.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService {

	@Value("${path.upload}")
	private String PATH_UPLOAD;

	@Override
	public void uploadImage(MultipartFile file) {

		if (file.isEmpty()) {
			throw new RuntimeException("File Is Not Found!");
		}

		try {

			/** check exists Directory and Create Directory **/
			Path dir = Paths.get(PATH_UPLOAD);
			if (!Files.exists(dir)) {
				Files.createDirectory(dir);
			}

			String fileName = file.getOriginalFilename();
			InputStream is = file.getInputStream();
			Files.copy(is, Paths.get(PATH_UPLOAD + fileName), StandardCopyOption.REPLACE_EXISTING);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}