package com.example.bmp.service;

import com.example.bmp.dao.CustomerDao;
import com.example.bmp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.awt.print.Pageable;
import java.util.List;

@Service        //作用于业务逻辑层
@Transactional  //事物
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;
    //保存所以数据
    public Customer saveCustomer(Customer customer)
    {
        return customerDao.save (customer);
    }

    //查询第一条数据
    public Customer firstdata(int status)
    {
        return customerDao.findFirstByStatus (status);
    }
    //查询openid
    public Customer findOpenid(String opneid)
    {
       return customerDao.findByOpenid (opneid);
    }
    //更新使用过的code为1
    public void updatecode(String code,String openid)
    {
        customerDao.updateByCode (code,openid);
    }

    //根据openid，code进行模糊查询

/*    public List<Customer> insetopenidAndcode(String openid, String code, Pageable pageable)
    {
        return customerDao.findByOpenidLikeAndCode (openid,code,pageable);
    }*/

    //根据id删除一条数据
    public void deleteCustomerById(Integer id)
    {
        customerDao.deleteById (id);
    }
}
