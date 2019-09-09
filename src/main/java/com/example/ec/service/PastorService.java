package com.example.ec.service;

import com.example.ec.domain.Pastor;
import com.example.ec.repo.PastorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PastorService {
    private PastorRepository pastorRepository;

    @Autowired
    public PastorService(PastorRepository pastorRepository) {
        this.pastorRepository = pastorRepository;
    }


    public Pastor createPastor(Long id,LocalDate date,Integer personId){
        if(pastorRepository.findOne(id)==null){
            return pastorRepository.save(new Pastor(id,date,personId));
        }else{
            return null;
        }
    }
    public Iterable<Pastor> lookup(){
        return pastorRepository.findAll();
    }
    public long total(){
        return pastorRepository.count();
    }

}
