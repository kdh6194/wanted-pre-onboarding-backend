package com.acorn.wantedpreonboardingbackend.Repository;

import com.acorn.wantedpreonboardingbackend.VO.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Company,Integer> {
}
