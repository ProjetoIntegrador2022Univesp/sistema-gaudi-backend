package com.gaudisystems.sistemagaudi.modules.contract.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaudisystems.sistemagaudi.modules.contract.controllers.ContractDto;
import com.gaudisystems.sistemagaudi.modules.contract.controllers.UpdateContractForm;
import com.gaudisystems.sistemagaudi.modules.contract.forms.CreateContractForm;
import com.gaudisystems.sistemagaudi.modules.contract.models.Contract;
import com.gaudisystems.sistemagaudi.modules.contract.repositories.ContractRepository;
import com.gaudisystems.sistemagaudi.modules.courses.models.Course;
import com.gaudisystems.sistemagaudi.modules.courses.repositories.CourseRepository;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;
import com.gaudisystems.sistemagaudi.modules.student.repositories.StudentRepository;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository repository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Contract> findAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<ContractDto> findById(long id) {
        Optional<Contract> optional = repository.findById(id);
        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Contract contract = optional.get();
        return ResponseEntity.ok().body(new ContractDto(contract));
            
    }

    @Override
    public ResponseEntity<ContractDto> save(CreateContractForm form, UriComponentsBuilder uriBuilder) {

        Optional<Student> studentOptional = studentRepository.findById(form.getStudentId());
        if (!studentOptional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        Student student = studentOptional.get();
        
        Optional<Course> courseOptional = courseRepository.findById(form.getCourseId());
        if (!courseOptional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        Course course = courseOptional.get();

        Contract contract = form.toContract(student, course);
        repository.save(contract);
        URI uri = uriBuilder.path("/contract/{id}").buildAndExpand(contract.getId()).toUri();
        return ResponseEntity.created(uri).body(new ContractDto(contract));
    }

    @Override
    public ResponseEntity<ContractDto> update(long id, UpdateContractForm form) {
        Optional<Contract> optional = repository.findById(id);
        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Contract contract = form.update(optional.get());
        contract = repository.save(contract);
        return ResponseEntity.ok().body(new ContractDto(contract));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        Optional<Contract> optional = repository.findById(id);
        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        repository.delete(optional.get());
        return ResponseEntity.noContent().build();
    }

    
}
