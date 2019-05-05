package com.bmw.passbook.dto;

import com.bmw.passbook.constant.ErrorCode;
import com.bmw.passbook.repository.MerchantRepository;
import lombok.Data;

import java.util.Date;

@Data
public class PassTemplate {
    private Integer id;
    private String title;
    private String summary;
    private String desc;
    private Long limit;
    private Boolean hasToken;
    private Integer background;
    private Date start;
    private Date end;

    public ErrorCode validate(MerchantRepository repository) {
        if (null == repository.findById(id)) {
            return ErrorCode.MERCHANTS_NOT_EXIST;
        }
        return ErrorCode.SUCCESS;
    }

}
