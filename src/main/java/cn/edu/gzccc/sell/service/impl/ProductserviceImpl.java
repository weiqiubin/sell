package cn.edu.gzccc.sell.service.impl;

import cn.edu.gzccc.sell.dataobject.ProductInfo;
import cn.edu.gzccc.sell.enums.PayStatusEnum;
import cn.edu.gzccc.sell.exception.SellException;
import cn.edu.gzccc.sell.repository.ProductinfoRepository;
import cn.edu.gzccc.sell.service.ProductService;
import cn.edu.gzccc.sell.dto.CartDTO;
import cn.edu.gzccc.sell.enums.ProductStatusEnum;
import cn.edu.gzccc.sell.enums.ResultEnum;
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
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList ){
            ProductInfo productInfo = productinfoRepository.findOne(cartDTO.getProductId());
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            productinfoRepository.save(productInfo);
        }

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

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = productinfoRepository.findOne(productId);
        if (productId == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP){

            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return productinfoRepository.save(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = productinfoRepository.findOne(productId);
        if (productId == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN){

            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return productinfoRepository.save(productInfo);
    }
}
