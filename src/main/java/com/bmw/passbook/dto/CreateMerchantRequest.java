package com.bmw.passbook.dto;

import com.bmw.passbook.constant.ErrorCode;
import com.bmw.passbook.entity.Merchant;
import com.bmw.passbook.repository.MerchantRepository;
import lombok.Data;
import lombok.var;

@Data
public class CreateMerchantRequest {

    private String name;

    private String logoUrl;

    private String businessLicenseUrl;

    private String phone;

    private String address;

    private Boolean isAduit;


    public Merchant ToMerchant(){
        var merchant = new Merchant();
        merchant.setAddress(address);
        merchant.setBusinessLicenseUrl(logoUrl);
        merchant.setIsAduit(isAduit);
        merchant.setLogoUrl(logoUrl);
        merchant.setName(name);
        merchant.setPhone(phone);
        return merchant;
    }

    public static ErrorCode validate(MerchantRepository repository){

        return ErrorCode.SUCCESS;


    }
}
