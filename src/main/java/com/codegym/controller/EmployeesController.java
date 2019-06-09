package com.codegym.controller;

import com.codegym.model.Employess;
import com.codegym.model.Office;
import com.codegym.sevice.EmployeesSevice;
import com.codegym.sevice.OfficeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class EmployeesController {
    @Autowired
    private EmployeesSevice employeesSevice;
    @Autowired
    private OfficeSevice officeSevice;


    @GetMapping("/employees")
    public ModelAndView modelAndView(@RequestParam("s") Optional<String> s, @PageableDefault(
             value = 5) Pageable pageable){
        Page<Employess>employesses ;
        if (s.isPresent()){
            employesses = employeesSevice.findAllByFirstNameContaining(s.get(),pageable);
        }else {
            employesses = employeesSevice.fillAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("employees/list");
        modelAndView.addObject("employees",employesses);
        return modelAndView;
    }

    @ModelAttribute("office")
    public Iterable<Office>offices(){
        return officeSevice.fillALL();
    }
    @GetMapping("/create-employees")
    public ModelAndView createEmployees(){
        ModelAndView modelAndView = new ModelAndView("employees/create");
        modelAndView.addObject("employees",new Employess());
        return modelAndView;
    }
    @PostMapping("/create-employees")
    public ModelAndView saveEmployees(@ModelAttribute("employees") Employess employess){
        employeesSevice.save(employess);
        ModelAndView modelAndView = new ModelAndView("employees/create");
        return modelAndView;
    }
    @GetMapping("edit-employees/{id}")
    public ModelAndView editEmployees(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("employees/edit");
        modelAndView.addObject("employees",employeesSevice.findById(id));
        return modelAndView;
    }
    @PostMapping("edit-employees")
    public String updateEmployees(@ModelAttribute("employees") Employess employess){
        employeesSevice.save(employess);
        return "redirect:/employees";
    }
    @GetMapping("delete-employees/{id}")
    public ModelAndView deleteEmployees(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("employees/delete");
        modelAndView.addObject("employees",employeesSevice.findById(id));
        return modelAndView;
    }
    @PostMapping("delete-employees")
    public String deteleE(@ModelAttribute("employees") Employess employess){
        employeesSevice.delete(employess.getId());
        return "redirect:/employees";
    }
}
