package com.gaudisystems.sistemagaudi.modules.address.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaudisystems.sistemagaudi.modules.address.apis.ViaCepApi;
import com.gaudisystems.sistemagaudi.modules.address.dtos.AddressDto;
import com.gaudisystems.sistemagaudi.modules.address.forms.CreateAddressForm;
import com.gaudisystems.sistemagaudi.modules.address.forms.UpdateAddressForm;
import com.gaudisystems.sistemagaudi.modules.address.models.Address;
import com.gaudisystems.sistemagaudi.modules.address.models.CepAddress;
import com.gaudisystems.sistemagaudi.modules.address.repositories.IAddressRepository;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;
import com.gaudisystems.sistemagaudi.modules.student.repositories.StudentRepository;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private IAddressRepository repository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Address> findAll() {
        List<Address> addresses = repository.findAll();
        return addresses;
    }

    @Override
    public ResponseEntity<CepAddress> getAddressFromCep(String cep) {
        try{
            return restTemplate.getForEntity(ViaCepApi.getViaCepUrl(cep), CepAddress.class);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<AddressDto> findById(long id) {
        Optional<Address> address = repository.findById(id);
        if(!address.isPresent()){
            return ResponseEntity.notFound().build();
        }
        AddressDto dto = new AddressDto(address.get());
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<AddressDto> save(CreateAddressForm form, UriComponentsBuilder uriComponentsBuilder) {
        long studentId = form.getStudentId();
            Optional<Student> optional = studentRepository.findById(studentId);
            if(!optional.isPresent()){
                return ResponseEntity.badRequest().build();
            }

          Student student = optional.get();
        
            
        Address entity = form.create(student);
        repository.save(entity);
        URI uri = uriComponentsBuilder.path("/courses/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(new AddressDto(entity));
    }

    @Override
    public ResponseEntity<Address> update(UpdateAddressForm form) {
        Optional<Address> address = repository.findById(form.getId());
        if(!address.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Address entity = form.update(address.get());
        repository.save(entity);
        return ResponseEntity.ok(entity);
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        Optional<Address> address = repository.findById(id);
        if(!address.isPresent()){
            return ResponseEntity.notFound().build();
        }
        repository.delete(address.get());
        return ResponseEntity.noContent().build();
    }

}
