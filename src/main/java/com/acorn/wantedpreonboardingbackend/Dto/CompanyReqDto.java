package com.acorn.wantedpreonboardingbackend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompanyReqDto {
    int company_no;
    String position;
    String compensation;
    String content;
    String skill;
}
