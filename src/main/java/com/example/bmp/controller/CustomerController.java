package com.example.bmp.controller;
import com.example.bmp.entity.Customer;
import com.example.bmp.model.ResultUtility;
import com.example.bmp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/likecode/{code}")
    public List<Customer>findBycode(@PathVariable(value = "code") String code)
    {
        return customerService.findBycode (code);
    }
    @RequestMapping("/cando/{code}")
    public List<Customer>findopenidAndcode(
            @PathVariable(value = "code") String code,
            @PathVariable("openid") String openid
            )
    {
        return customerService.findByopenidAndcode (code,openid);
    }
    @RequestMapping("/list")
   public String customer(Model model)
    {
        List<Customer> customers=customerService.getCustomerList ();
        model.addAttribute ("Cus",customers);
        return "index";
    }

    /**
     * 添加用户
     * */
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "addcustomer";
    }

    @RequestMapping("/add")
    public String add(Customer customer) {
        customerService.saveCustomer (customer);
        return "index";
    }

    /**
     * 修改
     **/
    @RequestMapping("/toEdit")
    public String toEdit(Model model,Integer id) {
        Customer customer=customerService.findCusById (id);
        model.addAttribute("Customer", customer);
        return "updatecustomer";
    }

    @RequestMapping("/edit")
    public String edit(Customer customer) {
        customerService.editCustomer (customer);
        return "list ";
    }

    /**
     * 删除
     * */
    @RequestMapping("/delete")
    public String delete(Integer id) {
        ResultUtility resultUtility=new ResultUtility ();
        try {
            customerService.deleteCustomer (id);
            resultUtility.setStatus (true);
            resultUtility.setMsg ("删除成功");
            return "index";
        }catch (Exception e)
        {
            e.printStackTrace ();
            resultUtility.setStatus (false);
            resultUtility.setMsg ("删除失败!");
            return "erro";
        }
    }
   /* @RequestMapping("add")
    public String addCustomer(Customer customer) {
        ResultUtility resultUtility = new ResultUtility ();
        try {
            customerService.saveCustomer (customer);
            resultUtility.setStatus (true);
            resultUtility.setMsg ("添加成功！");
            return "addcustomer";
        } catch (Exception e) {
            e.printStackTrace ();
            resultUtility.setStatus (false);
            resultUtility.setMsg ("添加失败!");c
            return "erro";
        }
    }*/
    @RequestMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file, Model model){
        if (file.isEmpty()){
            model.addAttribute("message", "The file is empty!");
            return "index";
        }
        try{
            byte[] bytes = file.getBytes();
            Path path = Paths.get("G:\\test/" + file.getOriginalFilename());
            Files.write(path, bytes);
            model.addAttribute("message", "succes");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "index";
    }
}
