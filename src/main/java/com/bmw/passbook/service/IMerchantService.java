package com.bmw.passbook.service;

import com.bmw.passbook.dto.CreateMerchantRequest;
import com.bmw.passbook.dto.PassTemplate;
import com.bmw.passbook.dto.Response;

public interface IMerchantService {
    Response createMerchant(CreateMerchantRequest request);
    Response buildMerchantById(Integer id);
    Response dropPassTemplate(PassTemplate template);
}
