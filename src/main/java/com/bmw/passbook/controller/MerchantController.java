package com.bmw.passbook.controller;


import com.bmw.passbook.constant.TemplateColor;
import com.bmw.passbook.dto.CreateMerchantRequest;
import com.bmw.passbook.dto.PassTemplate;
import com.bmw.passbook.dto.Response;
import com.bmw.passbook.service.IMerchantService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

@Slf4j
@RestController
public class MerchantController {
    private final IMerchantService _merchantService;

    public MerchantController(IMerchantService merchantService) {
        _merchantService = merchantService;
    }

    @ResponseBody
    @PostMapping("/api/merchant")
    public Response createMerchant() {
        CreateMerchantRequest request = new CreateMerchantRequest();
        request.setName("优惠卷");
        request.setAddress("上海市");
        request.setBusinessLicenseUrl("www.baidu.com");
        request.setIsAduit(true);
        request.setPhone("18351801922");
        request.setLogoUrl("www.baidu.com");
        var response = _merchantService.createMerchant(request);
        return response;
    }

    @ResponseBody
    @GetMapping("/api/merchant/{id}")
    public Response getMerchantById(@PathVariable Integer id) {
        return _merchantService.buildMerchantById(id);
    }

    @ResponseBody
    @PostMapping("/api/merchant/drop")
    public Response dropTemplate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setBackground(TemplateColor.GREEN.getCode());
        passTemplate.setDesc("描述");
        passTemplate.setStart(new Date());
        passTemplate.setEnd(calendar.getTime());
        passTemplate.setHasToken(false);
        passTemplate.setLimit(100L);
        passTemplate.setId(1);
        passTemplate.setSummary("简介");
        passTemplate.setTitle("标题");
        return _merchantService.dropPassTemplate(passTemplate);
    }


}
