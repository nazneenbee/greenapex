package com.contact.service.imple;


import com.contact.entity.ContactEntity;
import com.contact.repository.ContactRepositoy;
import com.contact.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

   @Autowired
   ContactRepositoy contactRepositoy;

    @Override
    public List<ContactEntity> getContactsOfUser(Long userId) {
   
    	

		return contactRepositoy.getContactDetail(userId);
    	
    }
}