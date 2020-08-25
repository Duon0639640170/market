package com.it.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import com.it.dto.ReportDto;

public interface ReportService {

	public ReportDto saveReport(ReportDto reportDto) throws Exception;

	public ReportDto updateReport(ReportDto reportDto) throws Exception;

	public Integer deleteReportByRP_id(Integer rp_id) throws Exception;

	public List<ReportDto> selectAllReport() throws Exception;
	
	public ReportDto getReportByRp_id (Integer rp_id) throws Exception;
	
	public ByteArrayOutputStream generateReport() throws IOException;
	
	public ByteArrayOutputStream orderReport(Integer shop_id) throws IOException;
	
}
