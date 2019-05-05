package com.bmw.passbook.service.impl;

import com.alibaba.fastjson.JSON;
import com.bmw.passbook.constant.Constants;
import com.bmw.passbook.constant.ErrorCode;
import com.bmw.passbook.dto.CreateMerchantRequest;
import com.bmw.passbook.dto.CreateMerchantResponse;
import com.bmw.passbook.dto.PassTemplate;
import com.bmw.passbook.dto.Response;
import com.bmw.passbook.repository.MerchantRepository;
import com.bmw.passbook.service.IMerchantService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MerchantService implements IMerchantService {
    private final MerchantRepository _repository;
    private final KafkaTemplate<String, String> _kafkaTemplate;

    public MerchantService(MerchantRepository repository, KafkaTemplate<String, String> kafkaTemplate) {
        this._repository = repository;
        this._kafkaTemplate = kafkaTemplate;
    }

    @Override
    @Transactional
    public Response createMerchant(CreateMerchantRequest request) {
        var code = request.validate(_repository);
        if (code != ErrorCode.SUCCESS) {
            return Response.ERROR(code);
        }
        var merchant = request.toMerchant();
        var id = _repository.save(merchant).getId();
        var data = new CreateMerchantResponse();
        data.setId(id);
        return Response.SUCCESS(data);
    }

    @Override
    public Response buildMerchantById(Integer id) {
        var merchant = _repository.findById(id);
        if (null == merchant) {
            return Response.ERROR(ErrorCode.MERCHANTS_NOT_EXIST);
        }
        var response = Response.SUCCESS(merchant);
        return response;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {
        var error = template.validate(_repository);
        if (error != ErrorCode.SUCCESS) {
            return Response.ERROR(error);
        }
        String passTemplate = JSON.toJSONString(template);
        _kafkaTemplate.send(Constants.TEMPLATE_TOPIC, Constants.TEMPLATE_TOPIC, passTemplate);
        log.info("dropPassTemplate:{}", passTemplate);
        return Response.SUCCESS("success");
    }
}
