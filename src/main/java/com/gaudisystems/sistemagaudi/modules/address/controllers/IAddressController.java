package com.gaudisystems.sistemagaudi.modules.address.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaudisystems.sistemagaudi.modules.address.dtos.AddressDto;
import com.gaudisystems.sistemagaudi.modules.address.forms.CreateAddressForm;
import com.gaudisystems.sistemagaudi.modules.address.forms.UpdateAddressForm;
import com.gaudisystems.sistemagaudi.modules.address.models.Address;
import com.gaudisystems.sistemagaudi.modules.address.models.CepAddress;

public interface IAddressController {
    public ResponseEntity<CepAddress> getAddressFromCep(String cep);

    public List<AddressDto> findAll();

    public ResponseEntity<AddressDto> findById(long id);

    public ResponseEntity<AddressDto> save(CreateAddressForm form, UriComponentsBuilder uriBuilder);

    public ResponseEntity<Address> update(UpdateAddressForm form);

    public ResponseEntity<Void> delete(long id);
}
