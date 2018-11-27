package com.example.bmp.service;
import com.example.bmp.dao.CustomerDao;
import com.example.bmp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service        //作用于业务逻辑层
@Transactional  //事物
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    /**
     * 删除
     **/

    public void deleteCustomer(int id)
    {
        customerDao.deleteById (id);
    }
    /**
     * 根据id查询
     **/
    public Customer findCusById(int id) {
        return customerDao.findCustomerById (id);
    }

    /**
     * 保存所有数据
     **/

    public Customer saveCustomer(Customer customer)
    {
        return customerDao.save (customer);
    }

    /**
     * 修改所有数据
     **/

    public void editCustomer(Customer customer)
    {
         customerDao.save (customer);
    }

    /**
     * 获取所有数据
     **/

    public List<Customer> getCustomerList()
    {
        List<Customer> all=customerDao.findAll ();
        return  all;
    }

    /**
     * 查询第一条数据
     **/

    public Customer firstdata(int status)
    {
        return customerDao.findFirstByStatus (status);
    }
    /**
     * 查询openid
     **/

    public Customer findOpenid(String opneid)
    {
       return customerDao.findByOpenid (opneid);
    }
    /**
     * 更新使用过的code为1
     **/

    public void updatecode(String code,String openid)
    {
        customerDao.updateByCode (code,openid);
    }

    /**
     * 根据openid，code进行模糊查询
     **/
  public List<Customer> findBycode(String code)
  {
      return customerDao.findByNameLike (code);
  }
   public List<Customer> findByopenidAndcode(String code,String openid)
   {
       return customerDao.findByCodeAndOpenid (code,openid);
   }
}
