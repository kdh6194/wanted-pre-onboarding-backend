package com.acorn.wantedpreonboardingbackend.Controller;

import com.acorn.wantedpreonboardingbackend.Dto.CompanyReqDto;
import com.acorn.wantedpreonboardingbackend.Service.EmployeeService;
import com.acorn.wantedpreonboardingbackend.VO.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
}
