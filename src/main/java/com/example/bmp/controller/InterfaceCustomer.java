package com.example.bmp.controller;
import com.example.bmp.entity.Customer;
import com.example.bmp.model.ResultUtility;
import com.example.bmp.service.CustomerService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterfaceCustomer {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/save")
    public String saveCustomer(
            @RequestParam("openid" )String openid,
            @RequestParam("Answer1" )int Answer1,
            @RequestParam("Answer2" )int Answer2
    )
    {
        ResultUtility resultUtilityn;
        Customer open= customerService.findOpenid (openid);//查询opendid
        if (open != null)
        {
            resultUtilityn=new ResultUtility (false,"你已经领取过了");
        }
        else {
            Customer customer = customerService.firstdata (0);
            customer.setAnswer1 (Answer1);
            customer.setAnswer2 (Answer2);
            String code = customer.getCode ();
            customerService.updatecode (code, openid);
           resultUtilityn=new ResultUtility (true,"领取成功！",code+" ");
        }
        JSONObject jsonObject=JSONObject.fromObject (resultUtilityn);
        String str=jsonObject.toString ();
        return str;
    }
}
