package com.acorn.wantedpreonboardingbackend.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompanyPostReqDto {
    String company_name;
    String country;
    String location;
    String position;
    String compensation;
    String skill;
}
