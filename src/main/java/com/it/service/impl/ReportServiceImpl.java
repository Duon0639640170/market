package com.it.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.it.dao.ReportRepository;
import com.it.dto.ReportDto;
import com.it.entity.ReportEntity;
import com.it.service.ReportService;


@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired(required=false)
	ReportRepository reportRepository;

	@Override
	public ReportDto saveReport(ReportDto reportDto) throws Exception {
		if (reportDto !=null) {
			ReportEntity entity = convertDtoToEntit(reportDto);
			reportRepository.save(entity);
		}else {
			throw new NullPointerException("savereport :: ReportDto is Null!");
		}
	
		return reportDto;
	}

	@Override
	public ReportDto updateReport(ReportDto reportDto) throws Exception {
		if (reportDto !=null && reportDto.getRp_id() > 0) {
			ReportEntity entity = convertDtoToEntit(reportDto);
			reportRepository.save(entity);
		}else {
			throw new NullPointerException("updateReport :: ReportDto is Null or RP_id <0 !");
			
		}
		return reportDto;
	}

	@Override
	public Integer deleteReportByRP_id(Integer rp_id) throws Exception {
		if(rp_id > 0 ) {
			reportRepository.deleteById(rp_id);
		}else {
			throw new NullPointerException("deleteReportByRP_id :: rp_id <0");
		
		}
		return rp_id;
	}

	@Override
	public List<ReportDto> selectAllReport() throws Exception {
		List<ReportDto> report = new ArrayList<>();
		List<ReportEntity> entities = (List<ReportEntity>) reportRepository.findAll();
		if (entities != null) {
			report = entities.stream()
					.map(entity -> convertEntityToDto(entity))
					.collect(Collectors.toList());
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
		if (rp_id > 0 ) {
			ReportEntity entity = reportRepository.findById(rp_id).get();
			if (entity != null) {
				report = convertEntityToDto(entity);
				
			}
		} else {
			throw new NullPointerException("getReportByRP_id :: rp_id < 0! ");
		}
		return report;
	}

	}

