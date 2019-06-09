package com.codegym.sevice;

import com.codegym.model.Employess;
import com.codegym.model.Office;
import com.codegym.repository.EmployessRepository;

public interface OfficeSevice {
    Iterable<Office> fillALL();
    Office findById(Long id);
    void save( Office office);
    void delete(Office office);
}
