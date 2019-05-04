package com.bmw.passbook.service.impl;

import com.bmw.passbook.constant.ErrorCode;
import com.bmw.passbook.dto.CreateMerchantRequest;
import com.bmw.passbook.dto.CreateMerchantResponse;
import com.bmw.passbook.dto.PassTemplate;
import com.bmw.passbook.dto.Response;
import com.bmw.passbook.repository.MerchantRepository;
import com.bmw.passbook.service.IMerchantService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MerchantService implements IMerchantService {
    private final MerchantRepository _repository;

    public MerchantService(MerchantRepository repository) {
        this._repository = repository;
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
        return null;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {
        return null;
    }
}
