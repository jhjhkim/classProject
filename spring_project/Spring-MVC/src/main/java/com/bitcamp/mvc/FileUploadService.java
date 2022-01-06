package com.bitcamp.mvc;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	
	// 파라미터 : 저장할 경로(웹경로), MultipartFile 객체, HttpServletRequest
	public String saveFile(String uri, MultipartFile file, HttpServletRequest request) throws Exception {
		
		if(file.isEmpty() || file.getSize()==0) {
			throw new Exception("파일이 존재하지 않습니다.");
		}
		
		// 전달받은 웹경로를 시스템경로로 변환
		String savePath = request.getSession().getServletContext().getRealPath(uri);
		
		// 새로운 파일 이름 생성
		String[] files = file.getOriginalFilename().split("\\.");	// 정규식 표현 주의!
		String exet = files[files.length-1];
		
		String newFileName = System.nanoTime()+"."+exet;
		
		// 전달받은 파일 객체를 이용해서 저장
		File saveFile = new File(savePath, newFileName);
		file.transferTo(saveFile);
		
		return newFileName;
	}

}
