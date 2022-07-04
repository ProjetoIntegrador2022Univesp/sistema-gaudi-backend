package com.gaudisystems.sistemagaudi.modules.address.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaudisystems.sistemagaudi.modules.address.dtos.AddressDto;
import com.gaudisystems.sistemagaudi.modules.address.forms.CreateAddressForm;
import com.gaudisystems.sistemagaudi.modules.address.forms.UpdateAddressForm;
import com.gaudisystems.sistemagaudi.modules.address.models.Address;
import com.gaudisystems.sistemagaudi.modules.address.models.CepAddress;
import com.gaudisystems.sistemagaudi.modules.address.services.AddressServiceImpl;

@RestController
@RequestMapping("/address")
public class AddressControllerImpl implements IAddressController {

    @Autowired
    private AddressServiceImpl service;


    @Override
    @GetMapping("/cep/{cep}")
    public ResponseEntity<CepAddress> getAddressFromCep(@PathVariable String cep) {
        return service.getAddressFromCep(cep);
    }

    @Override
    @GetMapping
    public List<AddressDto> findAll() {
        
            List<Address> addresses = service.findAll();
            return AddressDto.toAddressDto(addresses);
            
       
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> findById(@PathVariable long id) {
        System.out.println("id: " + id);

        return service.findById(id);
    }

    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<AddressDto> save(@RequestBody @Valid CreateAddressForm form, UriComponentsBuilder uriBuilder) {
        return service.save(form, uriBuilder);
    }

    @Override
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Address> update(@PathVariable @Valid UpdateAddressForm form) {
        return service.update(form);
    }

    @Override
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        return service.delete(id);
    }


    
    
}
