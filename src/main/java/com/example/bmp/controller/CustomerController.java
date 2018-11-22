package com.example.bmp.controller;
import com.example.bmp.entity.Customer;
import com.example.bmp.model.ResultUtility;
import com.example.bmp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping("index")
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
            return "index";
        } catch (Exception e) {
            e.printStackTrace ();
            resultUtility.setStatus (false);
            resultUtility.setMsg ("添加失败!");
            return "index";
        }
    }
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

        }catch (Exception e){
            e.printStackTrace();
        }
        return "index";
    }
}
