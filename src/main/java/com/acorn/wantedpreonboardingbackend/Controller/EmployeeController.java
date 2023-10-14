package com.acorn.wantedpreonboardingbackend.Controller;

import com.acorn.wantedpreonboardingbackend.Dto.CompanyListReqDto;
import com.acorn.wantedpreonboardingbackend.Dto.CompanyPostReqDto;
import com.acorn.wantedpreonboardingbackend.Dto.CompanyReqDto;
import com.acorn.wantedpreonboardingbackend.Service.EmployeeService;
import com.acorn.wantedpreonboardingbackend.VO.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/upload")
    public ResponseEntity<Map<String,String>> signUp(@RequestBody CompanyReqDto companyReqDto) {
       Company isSignUp = employeeService.signUp(companyReqDto);
       if(isSignUp != null){
           return ResponseEntity.ok(Map.of("message","등록이 되었습니다."));
       }else{
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message","이미 등록이 되어있습니다."));
       }
    }

    @PutMapping("/job-postings/{id}")
    public ResponseEntity<Map<String,String>> updateJobPosting(@PathVariable int id, @RequestBody CompanyReqDto companyReqDto) {
        Company isUpdate = employeeService.updateJobPost(id, companyReqDto);
        if(isUpdate != null){
            return ResponseEntity.ok(Map.of("message","수정되었습니다."));
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message","수정을 실패했습니다.."));
        }
    }

    @GetMapping("/job-postings/{id}")
    public ResponseEntity<List<CompanyPostReqDto>> getAllJobPosts() {
        List<Company> companies = employeeService.getAllJobPosts();
        List<CompanyPostReqDto> companyReqDtos = companies.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(companyReqDtos);
    }
    private CompanyPostReqDto convertToDto(Company company) {
        CompanyPostReqDto dto = new CompanyPostReqDto();
        dto.setCompany_name(company.getCompany_name());
        dto.setCountry(company.getCountry());
        dto.setLocation(company.getLocation());
        dto.setPosition(company.getPosition());
        dto.setCompensation(company.getCompensation());
        dto.setSkill(company.getSkill());

        return dto;
    }

    @GetMapping("/job-postings/{id}")
    public ResponseEntity<CompanyListReqDto> getJobPost(@PathVariable int id) {
        Company company = employeeService.getJobPost(id);
        CompanyListReqDto companyReqDto = new CompanyListReqDto();
        companyReqDto.setCompany_name(company.getCompany_name());
        companyReqDto.setCountry(company.getCountry());
        companyReqDto.setLocation(company.getLocation());
        companyReqDto.setPosition(company.getPosition());
        companyReqDto.setCompensation(company.getCompensation());
        companyReqDto.setContent(company.getContent());
        companyReqDto.setSkill(company.getSkill());

        return ResponseEntity.ok(companyReqDto);
    }

}
