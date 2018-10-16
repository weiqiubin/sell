package cn.edu.gzccc.sell.service.impl;

import cn.edu.gzccc.sell.dataobject.ProductInfo;
import cn.edu.gzccc.sell.repository.ProductinfoRepository;
import cn.edu.gzccc.sell.service.ProductService;
import enums.ProductStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductserviceImpl implements ProductService{

    @Autowired
    private ProductinfoRepository productinfoRepository;

    @Override
    public ProductInfo findOne(String ProductId) {
        return productinfoRepository.findOne(ProductId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productinfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productinfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productinfoRepository.save(productInfo);
    }
}
