package com.wm.eshop.price.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.wm.eshop.price.model.ProductPrice;

/** 注入【商品-价格表】的MyBatis Mapper配置 */
@Mapper
public interface ProductPriceMapper {

	@Insert("INSERT INTO product_price(value,product_id) VALUES(#{value},#{productId})")
	void add(ProductPrice productPrice);

	@Update("UPDATE product_price SET value=#{value},product_id=#{productId} WHERE id=#{id}")
	void update(ProductPrice productPrice);

	@Delete("DELETE FROM product_price WHERE id=#{id}")
	void delete(Long id);

	@Select("SELECT * FROM product_price WHERE id=#{id}")
	ProductPrice findById(Long id);
	
	@Select("SELECT * FROM product_price WHERE product_id=#{productId}")
	ProductPrice findByProductId(Long productId);

}
