package com.example.bmp.dao;
import com.example.bmp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository  //用于标注数据访问组件，即DAO组件,持久层
public interface CustomerDao extends JpaRepository<Customer,Integer> {
      Customer findCustomerById(int id);
      void  deleteById(int id);
    /**
     * 保存
     **/
    Customer save(Customer customer);
    /**
     * 查询第一天数据
     **/
    Customer findFirstByStatus(int status);
    /**
     * 查询openid 为空的给code领取成功，不为空的已经领取过了
     **/

    Customer findByOpenid(String openid);
    /**
     * 更新使用过的code为1，根据openid拿code
     **/
   @Transactional   //事物
   @Modifying(clearAutomatically = true)
   @Query(value = "update Customer set status=1,updatetime=sysdate(),openid=?2 where code=?1 ",nativeQuery = true)
    void updateByCode(String code,String openid);

    /**
     * 根据openid，code模糊查询
     *
     **/
    @Query("select  c.code from  Customer c where  c.code like CONCAT('%',:code,'%') ")
    List<Customer> findByNameLike(@Param("code") String code);

    /**
     * 多条件查询
     *
     **/
    @Query(value = "select * from Customer as c where c.code=?1 and c.openid=?2 ",nativeQuery = true)
    List<Customer>findByCodeAndOpenid(String code,String openid);
}
