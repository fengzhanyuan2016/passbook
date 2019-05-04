package com.bmw.passbook.dto;

import com.bmw.passbook.constant.ErrorCode;
import com.bmw.passbook.entity.Merchant;
import com.bmw.passbook.repository.MerchantRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.var;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Example;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantRequest {

    private String name;

    private String logoUrl;

    private String businessLicenseUrl;

    private String phone;

    private String address;

    private Boolean isAduit;


    public Merchant toMerchant() {
        var merchant = new Merchant();
        merchant.setAddress(address);
        merchant.setBusinessLicenseUrl(logoUrl);
        merchant.setIsAduit(isAduit);
        merchant.setLogoUrl(logoUrl);
        merchant.setName(name);
        merchant.setPhone(phone);
        return merchant;
    }

    public ErrorCode validate(MerchantRepository repository) {
        var merchant = new Merchant();
        merchant.setName(this.name);
        Example<Merchant> example = Example.of(merchant);
        if (!repository.exists(example)) {
            return ErrorCode.DUPLICATE_NAME;
        }
        if (StringUtils.isEmpty(this.logoUrl)) {
            return ErrorCode.EMPTY_LOGO;
        }
        if (StringUtils.isEmpty(this.businessLicenseUrl)) {
            return ErrorCode.EMPTY_BUSINESS_LICENSE;
        }
        if(StringUtils.isEmpty(this.address)){
            return ErrorCode.EMPTY_ADDRESS;
        }
        if(StringUtils.isEmpty(this.phone)){
            return ErrorCode.ERROR_PHONE;
        }
        return ErrorCode.SUCCESS;
    }
}
