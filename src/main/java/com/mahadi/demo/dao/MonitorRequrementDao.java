package com.mahadi.demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mahadi.demo.entity.MonitorRequrement;

@Repository
public interface MonitorRequrementDao extends PagingAndSortingRepository<MonitorRequrement, String>{

}
