package com.it.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


public class ServiceUtils {
	
	public ServiceUtils() {
		throw new IllegalStateException("ServiceUtils class");
	}

	public static HttpHeaders createResponseHeader(MediaType contentType , String fileName , Long contentLength) {

		if(contentType == null) {
			contentType = MediaType.APPLICATION_JSON_UTF8;
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(contentType);
		
		if(StringUtils.isNotBlank(fileName)) {
			headers.add("Content-Disposition", "inline;filename="+fileName);
		}
		
		if(contentLength != null) {
			headers.setContentLength(contentLength);
		}
		
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		
		return headers;
	}
}
