package com.digitalinnovationone.personapi.dto.mapper;

import com.digitalinnovationone.personapi.dto.request.PersonDTO;
import com.digitalinnovationone.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO dto);

    PersonDTO toDTO(Person dto);
}

