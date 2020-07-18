package com.it.service;

import java.util.List;
import com.it.dto.MarketDto;

public interface MarketService {

	public MarketDto saveMarket(MarketDto marketDto) throws Exception;

	public MarketDto updateMarket(MarketDto marketDto) throws Exception;

	public Integer deleteMarketByUser_id(Integer user_id) throws Exception;

	public List<MarketDto> selectAllMarket() throws Exception;
	
	public MarketDto getMarketByUser_id (Integer user_id) throws Exception;
}
