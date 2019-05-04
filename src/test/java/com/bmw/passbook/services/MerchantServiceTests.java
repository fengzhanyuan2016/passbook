package com.bmw.passbook.services;

import com.alibaba.fastjson.JSON;
import com.bmw.passbook.dto.CreateMerchantRequest;
import com.bmw.passbook.service.IMerchantService;
import lombok.var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantServiceTests {
    @Autowired
    private IMerchantService _merchantService;
    @Test
    public void testCreateMerchant(){
        CreateMerchantRequest request = new CreateMerchantRequest();
        request.setName("imooc");
        request.setAddress("北京");
        request.setBusinessLicenseUrl("www.baidu.com");
        request.setIsAduit(true);
        request.setLogoUrl("www.baidu.com");
        request.setPhone("18351801922");
        var response = _merchantService.createMerchant(request);
        System.out.println(JSON.toJSONString(response));
    }
}
