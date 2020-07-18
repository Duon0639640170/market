package com.it.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
	void uploadImage(MultipartFile file);
}