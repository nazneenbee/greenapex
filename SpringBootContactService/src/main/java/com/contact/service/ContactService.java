package com.contact.service;



import java.util.List;

import com.contact.entity.ContactEntity;

public interface ContactService {

	public List<ContactEntity> getContactsOfUser(Long userId);

}