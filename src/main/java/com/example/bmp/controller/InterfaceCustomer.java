package com.example.bmp.controller;
import com.example.bmp.entity.Customer;
import com.example.bmp.model.ResultUtility;
import com.example.bmp.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterfaceCustomer {
  /*  @Autowired
    private customerService customerService;
    @RequestMapping("/save")
    public String saveCustomer(
            @RequestParam("openid" )String openid,
            @RequestParam("Answer1" )String Answer1,
            @RequestParam("Answer12" )String Answer2)
    {
        ResultUtility resultUtility;
        String open=customerService.findOpenid (openid);//查询opendid
        if (open!=null)
        {
            resultUtility=new ResultUtility (false,"已经领取过了！");
        }
        else
        {
            Customer customer=customerService.firstdata (0);
            customerService.updatecode (code,openid);

        }
    }*/
}
