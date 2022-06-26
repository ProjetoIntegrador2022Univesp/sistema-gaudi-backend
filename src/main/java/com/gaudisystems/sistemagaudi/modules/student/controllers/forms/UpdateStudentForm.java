package com.gaudisystems.sistemagaudi.modules.student.controllers.forms;

import java.util.List;

import com.gaudisystems.sistemagaudi.modules.address.models.Address;
import com.gaudisystems.sistemagaudi.modules.guardian.models.Guardian;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;
import com.gaudisystems.sistemagaudi.modules.student.repositories.StudentRepository;

public class UpdateStudentForm {

    private String name;
    private String email;
    private String cpf;
    private String rg;
    private String phone;
    private String birthdate;
    private List<Guardian> guardian;
    private List<Address> addresses;

    public Student update(Long id, StudentRepository repository) {
        Student student = repository.findById(id).get();
        if(name != null) student.setName(name);
        if(email != null) student.setEmail(email);
        if(cpf != null) student.setCpf(cpf);
        if(rg != null) student.setRg(rg);
        if(phone != null) student.setPhone(phone);
        if(birthdate != null) student.setBirthdate(birthdate);
        if(guardian != null) student.setGuardian(guardian);
        if(addresses != null) student.setAddresses(addresses);
        return student;
    }

   

}
