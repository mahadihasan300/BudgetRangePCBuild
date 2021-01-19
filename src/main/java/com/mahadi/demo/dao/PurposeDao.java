package com.mahadi.demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mahadi.demo.entity.Purpose;

@Repository
public interface PurposeDao extends PagingAndSortingRepository<Purpose, String>{

}
