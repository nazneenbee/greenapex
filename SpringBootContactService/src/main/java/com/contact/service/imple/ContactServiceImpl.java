package com.contact.service.imple;


import com.contact.entity.ContactEntity;
import com.contact.service.ContactService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    //fake list of contacts

    List<ContactEntity> list = List.of(
            new ContactEntity(1L, "amit@gmail.com", "Amit", 1311L),
            new ContactEntity(2L, "anil@gmail.com", "Anil", 1311L),
            new ContactEntity(3L, "rohan@gmail.com", "Rohan", 1312L),
            new ContactEntity(4L, "sameer@gmail.com", "Sameer", 1314L)
    );


    @Override
    public List<ContactEntity> getContactsOfUser(Long userId) {
        return list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
    }
}