package com.mk.convention.dao;

import com.mk.convention.model.ProductPriceInfo;

public interface ProductPriceInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductPriceInfo record);

    int insertSelective(ProductPriceInfo record);

    ProductPriceInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductPriceInfo record);

    int updateByPrimaryKey(ProductPriceInfo record);
}