package com.it.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.it.dao.ReportRepository;
import com.it.dto.OrderDto;
import com.it.dto.PaymentDto;
import com.it.dto.ReportDto;
import com.it.entity.ReportEntity;
import com.it.service.OrderService;
import com.it.service.PaymentService;
import com.it.service.ReportService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ReportServiceImpl implements ReportService {

	private static final Logger log = LoggerFactory.getLogger(ReportServiceImpl.class);
	
	@Autowired(required = false)
	ReportRepository reportRepository;
	
	//for select payment list create pdf report 
	@Autowired(required = false)
	private PaymentService paymentService;
	@Autowired(required = false)
	private OrderService orderService;

	@Override
	public ReportDto saveReport(ReportDto reportDto) throws Exception {
		if (reportDto != null) {
			ReportEntity entity = convertDtoToEntit(reportDto);
			reportRepository.save(entity);
		} else {
			throw new NullPointerException("savereport :: ReportDto is Null!");
		}

		return reportDto;
	}

	@Override
	public ReportDto updateReport(ReportDto reportDto) throws Exception {
		if (reportDto != null && reportDto.getRp_id() > 0) {
			ReportEntity entity = convertDtoToEntit(reportDto);
			reportRepository.save(entity);
		} else {
			throw new NullPointerException("updateReport :: ReportDto is Null or RP_id <0 !");

		}
		return reportDto;
	}

	@Override
	public Integer deleteReportByRP_id(Integer rp_id) throws Exception {
		if (rp_id > 0) {
			reportRepository.deleteById(rp_id);
		} else {
			throw new NullPointerException("deleteReportByRP_id :: rp_id <0");

		}
		return rp_id;
	}

	@Override
	public List<ReportDto> selectAllReport() throws Exception {
		List<ReportDto> report = new ArrayList<>();
		List<ReportEntity> entities = (List<ReportEntity>) reportRepository.findAll();
		if (entities != null) {
			report = entities.stream().map(entity -> convertEntityToDto(entity)).collect(Collectors.toList());
		}
		return report;
	}

	private ReportDto convertEntityToDto(ReportEntity entity) {
		ReportDto dto = new ReportDto();
		if (entity != null) {
			dto.setRp_id(entity.getRp_id());
			dto.setUser_id(entity.getUser_id());
			dto.setShop_id(entity.getShop_id());
			dto.setPd_id(entity.getPd_id());
			dto.setRp_product(entity.getRp_product());
			dto.setRp_trackingnumber(entity.getRp_trackingnumber());
			dto.setRp_date(entity.getRp_date());

		}
		return dto;
	}

	private ReportEntity convertDtoToEntit(ReportDto dto) {
		ReportEntity entity = new ReportEntity();
		if (dto != null) {
			entity.setRp_id(dto.getRp_id());
			entity.setUser_id(dto.getUser_id());
			entity.setShop_id(dto.getShop_id());
			entity.setPd_id(dto.getPd_id());
			entity.setRp_product(dto.getRp_product());
			entity.setRp_trackingnumber(dto.getRp_trackingnumber());
			entity.setRp_date(dto.getRp_date());

		}
		return entity;
	}

	@Override
	public ReportDto getReportByRp_id(Integer rp_id) throws Exception {
		ReportDto report = new ReportDto();
		if (rp_id > 0) {
			ReportEntity entity = reportRepository.findById(rp_id).get();
			if (entity != null) {
				report = convertEntityToDto(entity);

			}
		} else {
			throw new NullPointerException("getReportByRP_id :: rp_id < 0! ");
		}
		return report;
	}

	@Override
	public ByteArrayOutputStream generateReport() throws IOException {
		log.info("generateReport : Start");
		ByteArrayOutputStream out = null;
		try {
			
			// initial report 
			ClassPathResource reportFile = new ClassPathResource("report/report-payment-all.jasper");
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getInputStream());

			// get list payment
			List<PaymentDto> paymentList = paymentService.selectAllPayment();
			
			// check payment list is valid 
			if (CollectionUtils.isNotEmpty(paymentList)) {
				
				// map parameter
				Map<String, Object> parameters = new HashMap<>();
				parameters.put("PARAM_01", "TEST");
				
				// set paymentList to report
				JRDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(paymentList);
				
				//print 
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanCollectionDataSource);
				out = new ByteArrayOutputStream();

				// export to PDF Stream
				JasperExportManager.exportReportToPdfStream(jasperPrint, out);
			}

			
		} catch (Exception e) {
			log.error("generateReport Error : {} ", e);
		}
		
		log.info("generateReport : End");
		return out;
	}
	
	
	@Override
	public ByteArrayOutputStream orderReport(Integer shop_id) throws IOException {
		log.info("orderReport : Start :: shop_id : " + shop_id);
		ByteArrayOutputStream out = null;
		try {
			
			// initial report 
			ClassPathResource reportFile = new ClassPathResource("report/report-order-all.jasper");
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getInputStream());

			// get list payment
			ArrayList<OrderDto> orderList = orderService.getOrdersByShop_id(shop_id);
			
			// check payment list is valid 
			if (CollectionUtils.isNotEmpty(orderList)) {
				
				// map parameter
				Map<String, Object> parameters = new HashMap<>();
				parameters.put("PARAM_01", "TEST");
				
				// set paymentList to report
				JRDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(orderList);
				
				//print 
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanCollectionDataSource);
				out = new ByteArrayOutputStream();

				// export to PDF Stream
				JasperExportManager.exportReportToPdfStream(jasperPrint, out);
			}

			
		} catch (Exception e) {
			log.error("orderReport Error : {} ", e);
		}
		
		log.info("orderReport : End");
		return out;
	}

}
