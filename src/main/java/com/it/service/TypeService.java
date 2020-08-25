package com.it.service;

import java.util.List;
import com.it.dto.TypeDto;

public interface TypeService {

	public List<TypeDto> selectAllType() throws Exception;
	
	public TypeDto getTypeByTypeId (Integer type_id) throws Exception;

	
}
