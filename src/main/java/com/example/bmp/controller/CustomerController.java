package com.example.bmp.controller;
import com.example.bmp.entity.Customer;
import com.example.bmp.model.ResultUtility;
import com.example.bmp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/index")
   public String customer(Model model)
    {
        List<Customer> customers=customerService.getCustomerList ();
        model.addAttribute ("s",customers);
        return "index";
    }
    @RequestMapping("add")
    public String addCustomer(Customer customer) {
        ResultUtility resultUtility = new ResultUtility ();
        try {
            customerService.saveCustomer (customer);
            resultUtility.setStatus (true);
            resultUtility.setMsg ("添加成功！");
            return "User/index";
        } catch (Exception e) {
            e.printStackTrace ();
            resultUtility.setStatus (false);
            resultUtility.setMsg ("添加失败!");
            return "User/index";
        }
    }
}
