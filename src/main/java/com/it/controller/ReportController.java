package com.it.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.it.dto.ReportDto;
import com.it.service.ReportService;


@RestController
public class ReportController {
	
	@Autowired(required=false)
	
	ReportService reportservice;

	@PostMapping("/report/save")
	public ResponseEntity<ReportDto> saveReport(@RequestBody ReportDto reportDto) throws Exception{		
		reportservice.saveReport(reportDto);
		return new ResponseEntity<ReportDto>(reportDto, HttpStatus.OK);
	}
	
	@PostMapping("/report/update")
	public ResponseEntity<ReportDto> updateReport(@RequestBody ReportDto reportDto) throws Exception{
		reportservice.updateReport(reportDto);
		return new ResponseEntity<ReportDto>(reportDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/report/{rp_id}")
	public ResponseEntity<Integer> deleteReportByRp_id(@PathVariable Integer rp_id) throws Exception{
		reportservice.deleteReportByRP_id(rp_id);
		return new ResponseEntity<Integer>(rp_id, HttpStatus.OK);		
	}
		@GetMapping("/report/{rp_id}")
	public ResponseEntity<ReportDto> getReportByReport (@PathVariable Integer rp_id) throws Exception{
			ReportDto reportDto = reportservice.getReportByRp_id(rp_id);
		return new ResponseEntity<ReportDto>(reportDto, HttpStatus.OK);		
	}
	
	@GetMapping("/report")
	public ResponseEntity<List<ReportDto>> getAllReport() throws Exception{
		List<ReportDto> response = reportservice.selectAllReport();
		return new ResponseEntity<List<ReportDto>>(response, HttpStatus.OK);
	}
	
		
	
}
