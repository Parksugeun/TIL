package com.campus.clova.controller;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class ClovaFileupload {
	public static String FileUpload(String path, MultipartFile f) {
		//파일명을 리턴함
		String orgFilename = f.getOriginalFilename(); // 멀티파트파일에서 구한다.
		//리네임 하려면 복잡하다. 
		
		try {
			f.transferTo(new File(path, orgFilename));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orgFilename;
	}
}
