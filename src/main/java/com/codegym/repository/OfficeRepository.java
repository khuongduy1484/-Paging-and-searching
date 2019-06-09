package com.codegym.repository;


import com.codegym.model.Office;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OfficeRepository extends PagingAndSortingRepository<Office,Long> {
}
