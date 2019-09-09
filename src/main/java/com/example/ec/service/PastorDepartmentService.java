package com.example.ec.service;

import com.example.ec.domain.Department;
import com.example.ec.domain.PastorDepartment;
import com.example.ec.repo.DepartmentRepository;
import com.example.ec.repo.PastorDepartmentRepository;
import com.example.ec.repo.PastorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PastorDepartmentService {
//    private DepartmentRepository departmentRepository;
//    private PastorRepository pastorRepository;
    private PastorDepartmentRepository pastorDepartmentRepository;

    @Autowired
    public PastorDepartmentService(PastorDepartmentRepository pastorDepartmentRepository) {
        this.pastorDepartmentRepository = pastorDepartmentRepository;
    }
    public PastorDepartment createPastorDepartment(Long id, LocalDate createDate,LocalDate startDate,LocalDate endDate){
        if (pastorDepartmentRepository.findOne(id) == null) {
            return pastorDepartmentRepository.save(new PastorDepartment(id,createDate,startDate,endDate));
        }else{
            return null;
        }
    }
    public Iterable<PastorDepartment> lookup(){
        return pastorDepartmentRepository.findAll();
    }
    public long total(){
        return pastorDepartmentRepository.count();
    }
}
