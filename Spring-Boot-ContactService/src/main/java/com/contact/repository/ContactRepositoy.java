package com.contact.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.contact.entity.ContactEntity;

public interface ContactRepositoy extends JpaRepository<ContactEntity, Long> {
	
	@Query("from ContactEntity c where c.userId IN :userId")
	public List<ContactEntity> getContactDetail(@Param("userId") Long userId);
}
