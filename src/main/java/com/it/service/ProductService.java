package com.it.service;

import java.util.List;

import com.it.dto.ProductDto;

public interface ProductService {

	public ProductDto saveProduct(ProductDto productDto) throws Exception;

	public ProductDto updateProduct(ProductDto productDto) throws Exception;

	public Integer deleteProductByPD_id(Integer pd_id) throws Exception;

	public List<ProductDto> selectAllProduct() throws Exception;
	
	public ProductDto getProductByPD_id (Integer pd_id ) throws Exception;
	
	public List<ProductDto> getProductByShop_id (Integer shop_id) throws Exception;
	
//	public ProductDto getProductByShop_id (Integer shop_id) throws Exception;
	public List<ProductDto> getProductByTypeId (Integer type_id) throws Exception;
}
