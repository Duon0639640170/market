package com.it.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.core.io.InputStreamResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.it.dto.ReportDto;
import com.it.service.ReportService;
import com.it.utils.ServiceUtils;

@RestController
public class ReportController {
	private static final Logger log = LoggerFactory.getLogger(ReportController.class);
	
	@Autowired(required = false)
	ReportService reportservice;

	@PostMapping("/report/save")
	public ResponseEntity<ReportDto> saveReport(@RequestBody ReportDto reportDto) throws Exception {
		reportservice.saveReport(reportDto);
		return new ResponseEntity<ReportDto>(reportDto, HttpStatus.OK);
	}

	@PostMapping("/report/update")
	public ResponseEntity<ReportDto> updateReport(@RequestBody ReportDto reportDto) throws Exception {
		reportservice.updateReport(reportDto);
		return new ResponseEntity<ReportDto>(reportDto, HttpStatus.OK);
	}

	@DeleteMapping("/report/{rp_id}")
	public ResponseEntity<Integer> deleteReportByRp_id(@PathVariable Integer rp_id) throws Exception {
		reportservice.deleteReportByRP_id(rp_id);
		return new ResponseEntity<Integer>(rp_id, HttpStatus.OK);
	}

	@GetMapping("/report/{rp_id}")
	public ResponseEntity<ReportDto> getReportByReport(@PathVariable Integer rp_id) throws Exception {
		ReportDto reportDto = reportservice.getReportByRp_id(rp_id);
		return new ResponseEntity<ReportDto>(reportDto, HttpStatus.OK);
	}

	@GetMapping("/report")
	public ResponseEntity<List<ReportDto>> getAllReport() throws Exception {
		List<ReportDto> response = reportservice.selectAllReport();
		return new ResponseEntity<List<ReportDto>>(response, HttpStatus.OK);
	}
	

	@GetMapping(path = "/report/generateReport")
	public ResponseEntity<InputStreamResource> generateReport(HttpServletRequest request) throws IOException {
		log.info("generateReport : Start");
		ResponseEntity<InputStreamResource> response = null;
		try (ByteArrayOutputStream out = reportservice.generateReport()) {
			if (out != null) {
				response = new ResponseEntity<>(new InputStreamResource(new ByteArrayInputStream(out.toByteArray())),
						ServiceUtils.createResponseHeader(MediaType.APPLICATION_PDF, "market-report.pdf", null), HttpStatus.OK);
			}
		} catch (Exception e) {
			log.error("generateReport Error : {}", e);
		}
		log.info("generateReport : End");
		return response;
	}

	
	@GetMapping(path = "/report/orderReport/{shop_id}")
	public ResponseEntity<InputStreamResource> orderReport(@PathVariable Integer shop_id) throws IOException {
		log.info("orderReport : Start");
		ResponseEntity<InputStreamResource> response = null;
		try (ByteArrayOutputStream out = reportservice.orderReport(shop_id)) {
			if (out != null) {
				response = new ResponseEntity<>(new InputStreamResource(new ByteArrayInputStream(out.toByteArray())),
						ServiceUtils.createResponseHeader(MediaType.APPLICATION_PDF, "market-report.pdf", null), HttpStatus.OK);
			}
		} catch (Exception e) {
			log.error("orderReport Error : {}", e);
		}
		log.info("orderReport : End");
		return response;
	}
}
