package com.greenapex.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.greenapex.entity.Registration;

@Repository
public interface IRegUserRepository extends JpaRepository<Registration, Integer>{

Optional<Registration> findByUserName(String userName);


}
