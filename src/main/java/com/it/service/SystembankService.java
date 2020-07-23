package com.it.service;

import java.util.List;
import com.it.dto.SystembankDto;

public interface SystembankService {

public List<SystembankDto> selectAllSystembankDto() throws Exception;
	
	public SystembankDto getSystembankById (Integer id) throws Exception;
}
