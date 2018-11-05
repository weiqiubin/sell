package cn.edu.gzccc.sell.service.impl;

import cn.edu.gzccc.sell.dataobject.SellerInfo;
import cn.edu.gzccc.sell.repository.SellerInfoRepository;
import cn.edu.gzccc.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findByUsernameAndPassword(String Username,String Password) {
        return sellerInfoRepository.findByUsernameAndPassword(Username,Password);
    }
}
