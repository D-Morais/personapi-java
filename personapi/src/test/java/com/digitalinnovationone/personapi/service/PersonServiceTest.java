package com.digitalinnovationone.personapi.service;

import com.digitalinnovationone.personapi.dto.request.PersonDTO;
import com.digitalinnovationone.personapi.dto.response.MessageResponseDTO;
import com.digitalinnovationone.personapi.entity.Person;
import com.digitalinnovationone.personapi.repository.PersonRepository;
import com.digitalinnovationone.personapi.services.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.digitalinnovationone.personapi.utils.PersonUtils.createFakeDTO;
import static com.digitalinnovationone.personapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThanReturnSavedMessage(){
       PersonDTO personDTO = createFakeDTO();
       Person expectedSavedPerson = createFakeEntity();

       when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

       MessageResponseDTO expectedSuccesMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
       MessageResponseDTO successMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccesMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId){
        return MessageResponseDTO.builder()
                .message("Person succesfully created with Id " + savedPersonId)
                .build();
    }


}
