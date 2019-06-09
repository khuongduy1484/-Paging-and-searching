package com.codegym.repository;

import com.codegym.model.Employess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployessRepository  extends PagingAndSortingRepository<Employess,Long>{
//    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
    Page<Employess> findAllByNameContaining(String name, Pageable pageable);


}
