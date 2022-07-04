package com.gaudisystems.sistemagaudi.modules.student.models.forms;

import java.util.ArrayList;
import java.util.List;

import com.gaudisystems.sistemagaudi.modules.address.models.Address;
import com.gaudisystems.sistemagaudi.modules.guardian.models.Guardian;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStudentForm {

    private String name;
    private String email;
    private String cpf;
    private String rg;
    private String phone;
    private String birthdate;
    private List<Guardian> guardians;
    private List<Address> addresses;

    public Student update(Student student) {
        if(name != null) student.setName(name);
        if(email != null) student.setEmail(email);
        if(cpf != null) student.setCpf(cpf);
        if(rg != null) student.setRg(rg);
        if(phone != null) student.setPhone(phone);
        if(birthdate != null) student.setBirthdate(birthdate);
        if(addresses != null) student.setAddresses(addresses);
        if(guardians != null) {
            List<Student> students = new ArrayList<>();
            students.add(student);
            for(Guardian guardian : guardians) {
                guardian.setStudents(students);
            }
            student.setGuardians(guardians);
        }
        return student;
    }

}
