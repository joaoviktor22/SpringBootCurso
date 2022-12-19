package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData(){
        Employee emp1 = new Employee(1,"Leslie","Andrews","leslie@luv2code.com");
        Employee emp2 = new Employee(1,"Emma","Baumgarten","emma@luv2code.com");
        Employee emp3 = new Employee(1,"Avani","Gupta","avani@luv2code.com");

        theEmployees = new ArrayList<>();

        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        theModel.addAttribute("employees",theEmployees);
        return "list-employees";
    }
}
