package cn.edu.gzccc.sell.service;

import cn.edu.gzccc.sell.dataobject.SellerInfo;

/**
 *卖家端
 */
public interface SellerService {


    /**
     * @param username
     * @param password
     * @return
     */
    SellerInfo findByUsernameAndPassword(String username,String password);

}
