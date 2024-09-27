package com.Api.registration.service;

import com.Api.registration.entity.Registration;
import com.Api.registration.exception.ResourceNotFoundException;
import com.Api.registration.payload.RegistrationDto;
import com.Api.registration.repository.RegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class RegistrationService {
    private RegistrationRepository registrationRepository;
    private ModelMapper modelMapper;
    public RegistrationService(RegistrationRepository registrationRepository, ModelMapper modelMapper) {
        this.registrationRepository = registrationRepository;
        this.modelMapper = modelMapper;
    }
    @GetMapping
    public List<RegistrationDto> getRegistrations(){
        List<Registration> registrations = registrationRepository.findAll();
        List<RegistrationDto> dtos= registrations.stream().map(r->mapToDto(r)).collect(Collectors.toList());
        return dtos;
    }
    public RegistrationDto createRegistration(RegistrationDto registrationDto){
        // copy dto to entity
        Registration registration = mapToEntity(registrationDto);
        Registration saveEntity = registrationRepository.save(registration);
        // copy  entity to Dto
        RegistrationDto dto = mapToDto(saveEntity);
       // RegistrationDto dto = new RegistrationDto();
        return dto;
    }
    public void deleteRegistration(long id) {
        registrationRepository.deleteById(id);
    }
    public Registration updateRegistration(long id, Registration registration){
        Registration r = registrationRepository.findById(id).get();
        r.setName(registration.getName());
        r.setEmail(registration.getEmail());
        r.setMobile(registration.getMobile());
        Registration saveEntity = registrationRepository.save(r);
        return saveEntity;
    }
    Registration mapToEntity(RegistrationDto registrationDto){
        Registration registration = modelMapper.map(registrationDto,Registration.class );
//        Registration registrations = new Registration();
//        registrations.setName(registrationDto.getName());
//        registrations.setEmail(registrationDto.getEmail());
//        registrations.setMobile(registrationDto.getEmail());
        return registration;
    }
    RegistrationDto mapToDto(Registration registration) {
       RegistrationDto dto = modelMapper.map(registration, RegistrationDto.class);
//        RegistrationDto dto = new RegistrationDto();
//        dto.setName(registration.getName());
//        dto.setEmail(registration.getEmail());
//        dto.setMobile(registration.getMobile());
        return dto;
    }
    public RegistrationDto getRegistrationById(long id) {
        Registration registration = registrationRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Record not found:")
                //supplier functional interface
        );
        return mapToDto(registration);
    }
}
