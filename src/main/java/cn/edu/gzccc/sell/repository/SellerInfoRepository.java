package cn.edu.gzccc.sell.repository;

import cn.edu.gzccc.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String>{
    SellerInfo findByUsernameAndPassword(String username,String password);
}
