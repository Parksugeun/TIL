package com.campus.clova.controller;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class ClovaFileupload {
	public static String fileUpload(String path, MultipartFile f) {
		//파일명을 리턴함
		String orgFilename = f.getOriginalFilename();
		
		try {
			f.transferTo(new File(path, orgFilename));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orgFilename;
	}
}
