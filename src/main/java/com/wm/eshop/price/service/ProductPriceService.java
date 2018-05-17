package com.wm.eshop.price.service;

import com.wm.eshop.price.model.ProductPrice;

/** 商品价格Service-负责向MySQL和Redis进行双写操作 */
public interface ProductPriceService {

	void add(ProductPrice productPrice);

	void update(ProductPrice productPrice);

	void delete(Long id);

	ProductPrice findById(Long id);

}
