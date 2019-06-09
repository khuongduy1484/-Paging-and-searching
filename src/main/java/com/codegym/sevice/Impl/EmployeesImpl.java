package com.codegym.sevice.Impl;

import com.codegym.model.Employess;
import com.codegym.repository.EmployessRepository;
import com.codegym.sevice.EmployeesSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class EmployeesImpl implements EmployeesSevice {
    @Autowired
    private EmployessRepository employessRepository;

//    @Override
//    public Page<Employess> fillAll(Pageable pageable) {
//        return employessRepository.findAll(pageable);


    @Override
    public Page<Employess> findAllByFirstNameContaining(String name, Pageable pageable) {
        return employessRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Page<Employess>fillAll(Pageable pageable) {
        return employessRepository.findAll(pageable);
    }

    @Override
    public Employess findById(Long id) {
        return employessRepository.findOne(id);
    }

    @Override
    public void save(Employess employess) {
        employessRepository.save(employess);

    }
    @Override
    public void delete(Long id) {
        employessRepository.delete(id);

    }
}
