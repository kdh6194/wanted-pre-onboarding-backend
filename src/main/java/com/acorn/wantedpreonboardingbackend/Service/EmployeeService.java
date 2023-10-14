package com.acorn.wantedpreonboardingbackend.Service;

import com.acorn.wantedpreonboardingbackend.Dto.CompanyReqDto;
import com.acorn.wantedpreonboardingbackend.Repository.EmployeeRepository;
import com.acorn.wantedpreonboardingbackend.VO.Company;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Transactional
    public Company signUp(CompanyReqDto companyReqDto) {
        if(companyReqDto == null){
            throw new RuntimeException("Invalid arguments");
        }
        int company_no = companyReqDto.getCompany_no();
        String position = companyReqDto.getPosition();
        String compensation = companyReqDto.getCompensation();
        String content = companyReqDto.getContent();
        String skill = companyReqDto.getSkill();
        if(employeeRepository.existsById(company_no)){
            throw new RuntimeException("이미 등록된 글입니다.");
        }

        Company upload = Company.builder()
                .company_no(company_no)
                .position(position)
                .compensation(compensation)
                .content(content)
                .skill(skill)
                .build();

        return employeeRepository.save(upload);
    }

    @Transactional
    public Company updateJobPost(int id, CompanyReqDto companyReqDto) {
        Company company = Company.builder()
                .company_no(companyReqDto.getCompany_no())
                .position(companyReqDto.getPosition())
                .compensation(companyReqDto.getCompensation())
                .content(companyReqDto.getContent())
                .skill(companyReqDto.getSkill())
                .build();

        Optional<Company> existingCompany = employeeRepository.findById(id);

        if (existingCompany.isPresent()) {

            Company existingEntity = existingCompany.get();
            BeanUtils.copyProperties(company, existingEntity, "company_no");

            return employeeRepository.save(existingEntity);

        } else {
            throw new RuntimeException("회사가 없습니다.");
        }
    }

}
