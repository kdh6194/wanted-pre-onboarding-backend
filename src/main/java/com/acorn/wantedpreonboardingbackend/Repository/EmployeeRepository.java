package com.acorn.wantedpreonboardingbackend.Repository;

import com.acorn.wantedpreonboardingbackend.VO.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Company,Integer> {
    List<Company> findByCompanyNameContaining(String companyName);
}
