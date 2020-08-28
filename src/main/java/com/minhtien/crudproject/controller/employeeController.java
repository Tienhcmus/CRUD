package com.minhtien.crudproject.controller;

import java.util.List;
import java.util.Optional;

import com.minhtien.crudproject.dao.employeeDAO;
import com.minhtien.crudproject.model.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class employeeController {

    @Autowired
    private employeeDAO dao;

    @PostMapping("/add")
    public String addEmployee(@RequestBody employee empl) {
        dao.save(empl);
        return "Save Successful";
    }

    @GetMapping("/get")
    public List<employee> getList() {
        return (List<employee>) dao.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<employee> getListById(@PathVariable int id) {
        return dao.findById(id);
    }
    
    @DeleteMapping("/delete/{id}")
    public String delEmployee(@PathVariable int id){
        dao.deleteById(id);
        return "Delete Successful";
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody employee empl){
        employee existsEmployee = dao.findById(empl.getId()).orElse(null);
        existsEmployee.setName(empl.getName());
        existsEmployee.setSalary(empl.getSalary());
        dao.save(existsEmployee);
        return "Update Successful";
    }
}