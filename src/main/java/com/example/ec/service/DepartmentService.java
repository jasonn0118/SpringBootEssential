package com.example.ec.service;

import com.example.ec.domain.Department;
import com.example.ec.domain.enumeration.Room;
import com.example.ec.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(Long id, LocalDate date, String name, Room room){
        if(departmentRepository.findOne(id)==null){
            return departmentRepository.save(new Department(id,date,name,room));
        }else{
            return null;
        }
    }
    public Iterable<Department> lookup(){
        return departmentRepository.findAll();
    }
    public long total(){
        return departmentRepository.count();
    }
}
