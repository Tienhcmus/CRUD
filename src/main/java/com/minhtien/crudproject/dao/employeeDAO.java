package com.minhtien.crudproject.dao;

import com.minhtien.crudproject.model.employee;

import org.springframework.data.repository.CrudRepository;

public interface employeeDAO extends CrudRepository<employee, Integer>{

}