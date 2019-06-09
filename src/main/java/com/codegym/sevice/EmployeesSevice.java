package com.codegym.sevice;

import com.codegym.model.Employess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeesSevice {
//    Page<Employess> fillAll();
//Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
    Page<Employess>findAllByFirstNameContaining(String name,Pageable pageable);
    Page<Employess>fillAll(Pageable pageable);
    Employess findById(Long id);
    void save(Employess employess);
    void  delete(Long id);
}
