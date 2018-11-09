package com.example.bmp.controller;

import com.example.bmp.entity.Customer;
import com.example.bmp.model.ResultUtility;
import com.example.bmp.service.CustomerService;
import com.fasterxml.jackson.annotation.JsonView;
import net.sf.json.JSON;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.jar.JarEntry;


@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
  /*  @RequestMapping(value = "/find")
    public Page<Customer> index(String openid, String code, Pageable pageable)
    {
        if (openid!=null)
        {

        }
        else
        {

        }
       return customerService.insetopenidAndcode (openid,code,pageable);

    }*/
    @RequestMapping("add")
   public String addCustomer(Customer customer)
   {
       ResultUtility resultUtility=new ResultUtility ();
       try{
           customerService.saveCustomer (customer);
           resultUtility.setStatus (true);
           resultUtility.setMsg ("添加成功！");
           return "User/index";
       }catch (Exception e)
       {
           e.printStackTrace ();
           resultUtility.setStatus (false);
           resultUtility.setMsg ("添加失败!");
           return "User/index";
       }
   }
}
