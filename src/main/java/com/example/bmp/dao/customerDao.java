package com.example.bmp.dao;

import com.example.bmp.entity.Customer;
import javafx.scene.chart.ValueAxis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository  //用于标注数据访问组件，即DAO组件,持久层
public interface customerDao extends JpaRepository<Customer,Long> {

    //保存全部数据
    Customer save(Customer customer);
    //查询第一条数据
    Customer findFirstByStatus(int status);
    //查询第一条数据
    String findByOpenid(String openid);
    //更新使用过的code为1，根据openid拿code
   @Transactional   //事物
   @Modifying(clearAutomatically = true)
   @Query(value = "update Customer set status=1,updatetime=sysdate(),openid=?2 where code=?1 ",nativeQuery = true)
   public  void updateByCode(String code,String openid);


    //分页

    //根据code,opneid进行模糊查询
}
