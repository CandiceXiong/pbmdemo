package com.example.bmp.dao;

import com.example.bmp.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository  //用于标注数据访问组件，即DAO组件,持久层
public interface CustomerDao extends JpaRepository<Customer,Integer> {



    //保存全部数据
    Customer save(Customer customer);
    //查询第一条数据
    Customer findFirstByStatus(int status);
    //查询openid 为空的给code领取成功，不为空的已经领取过了
    Customer findByOpenid(String openid);
    //更新使用过的code为1，根据openid拿code
   @Transactional   //事物
   @Modifying(clearAutomatically = true)
   @Query(value = "update Customer set status=1,updatetime=sysdate(),openid=?2 where code=?1 ",nativeQuery = true)
   public void updateByCode(String code,String openid);

    //分页
    //根据code,opneid进行模糊查询
/*    @Query(value = "select s from Customer as s where s.openid like concat('%',?1,'%') and s.code = ?2")
    Page<Customer> findByOpenidLikeAndCode(String opendid, String code, Pageable pageable);*/
}
