package com.mahadi.demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mahadi.demo.entity.Budget;

@Repository
public interface BudgetDao extends PagingAndSortingRepository<Budget, String>{

}
