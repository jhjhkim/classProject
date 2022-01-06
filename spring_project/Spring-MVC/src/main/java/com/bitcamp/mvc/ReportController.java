package com.bitcamp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/report")
public class ReportController {

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String getReportForm() {
		
		return "report/form";
	}
	
	@RequestMapping(value = "/submit1", method = RequestMethod.POST)
	public String submit1(
			@RequestParam("sno") String sno,
			@RequestParam("sname") String sname,
			@RequestParam("report") MultipartFile report,
			Model model
			) {
		
		System.out.println("학번 : " + sno);
		System.out.println("이름 : " + sname);
		System.out.println("리포트 파일 : " + report.getOriginalFilename());
		System.out.println("리포트 파일 : " + report.getContentType());
		System.out.println("리포트 파일 : " + report.getName());
		System.out.println("리포트 파일 : " + report.getSize());
		System.out.println("리포트 파일 : " + report.isEmpty());
		
		String newFileName = sno + "_" + report.getOriginalFilename();
		
		
		model.addAttribute("sno", sno);
		model.addAttribute("sname", sname);
		model.addAttribute("report", report.getOriginalFilename());
		
		return "report/submit";
	}
	
}
