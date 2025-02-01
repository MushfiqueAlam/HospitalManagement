package com.management.hospitalmanagment.controller;

import com.management.hospitalmanagment.model.Doctor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/doctor/api")
public class DoctorController {

    HashMap<Integer, Doctor> doctorMap=new HashMap<>();

    //for add or save the doctor
    @PostMapping("/save")
    public  String saveDoctor(@RequestBody Doctor doctor){
        doctorMap.put(doctor.getId(),doctor);
        return "Doctor has been saved successfully";
    }

    //find doctor by id
    @GetMapping("/find/{id}")
    public Doctor findById(@PathVariable int id){
        Doctor doctor=doctorMap.get(id);
        return doctor;
    }

    //find all doctor
    @GetMapping("/findAll")
    public HashMap<Integer,Doctor> findAll(){
        return doctorMap;
    }

    //update doctor
    @PutMapping("/update/{id}")
    public String update(@PathVariable int id , @RequestBody Doctor doctor){
        Doctor doctor1=doctorMap.get(id);
        if(doctor1==null){
            return "Doctor does not exit with this id";
        }else{
            doctorMap.put(doctor.getId(),doctor);
            return "Doctor deatails updated successfully";
        }
    }

    //delete doctor
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        doctorMap.remove(id);
        return "Doctor has been deleted successfully";
    }

}
