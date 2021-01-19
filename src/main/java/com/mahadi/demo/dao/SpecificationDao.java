package com.mahadi.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mahadi.demo.entity.Specification;




@Repository
public interface SpecificationDao extends PagingAndSortingRepository<Specification, String>{
	
	
	
	@Query(value = "Select * from specification WHERE cpu =?1 AND ram =?2", nativeQuery = true)
    List<Specification>findByBudgetAndMonitorRequrementAndPurposeTTTT(String cpu, String ram);
	
	@Query(value = "Select * from specification WHERE budget_id =?1 AND monitorRequrement_id =?2 AND purpose_id =?3", nativeQuery = true)
    List<Specification>findByBudgetAndMonitorRequrementAndPurpose(String budget, String monitorRequrement, String purpose);
	
	@Query(value = "SELECT * FROM  specification  WHERE budget_id =?1 AND monitorRequrement_id =?2 AND purpose_id =?3 AND IS_ACTIVE = 1", nativeQuery = true)
	 List<Specification> findByIsActiveTrue(String budget, String monitorRequrement, String purpose);
    
    @Query(value = "SELECT * FROM  specification  WHERE budget_id =?1 AND monitorRequrement_id =?2 AND purpose_id =?3 AND IS_ACTIVE = 0", nativeQuery = true)
    List<Specification> findByIsActiveFalse(String budget, String monitorRequrement, String purpose);
    
    @Query(value = "SELECT * FROM  specification  WHERE IS_ACTIVE = 0", nativeQuery = true)
    List<Specification> findByContribution();

}
