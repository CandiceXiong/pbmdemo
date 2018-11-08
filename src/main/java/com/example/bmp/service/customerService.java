package com.example.bmp.service;

import com.example.bmp.dao.customerDao;
import com.example.bmp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service        //作用于业务逻辑层
@Transactional  //事物
public class customerService {
    @Autowired
    private customerDao customerDao;
    //保存所以数据
    public Customer saveCustomer
      (Customer customer)
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

}
