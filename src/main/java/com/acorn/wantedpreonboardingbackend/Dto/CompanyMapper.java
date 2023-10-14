package com.acorn.wantedpreonboardingbackend.Dto;

import com.acorn.wantedpreonboardingbackend.VO.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public CompanyPostReqDto convertToDto(Company company) {
        CompanyPostReqDto dto = new CompanyPostReqDto();
        dto.setCompany_name(company.getCompany_name());
        dto.setCountry(company.getCountry());
        dto.setLocation(company.getLocation());
        dto.setPosition(company.getPosition());
        dto.setCompensation(company.getCompensation());
        dto.setSkill(company.getSkill());

        return dto;
    }
}