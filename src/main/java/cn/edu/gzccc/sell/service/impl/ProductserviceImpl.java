package cn.edu.gzccc.sell.service.impl;

import cn.edu.gzccc.sell.dataobject.ProductInfo;
import cn.edu.gzccc.sell.exception.SellException;
import cn.edu.gzccc.sell.repository.ProductinfoRepository;
import cn.edu.gzccc.sell.service.ProductService;
import dto.CartDTO;
import enums.ProductStatusEnum;
import enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {

        for (CartDTO cartDTO : cartDTOList){

            ProductInfo productInfo = productinfoRepository.findOne(cartDTO.getProductId());
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0 ){
                   throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productinfoRepository.save(productInfo);

        }
    }
}
