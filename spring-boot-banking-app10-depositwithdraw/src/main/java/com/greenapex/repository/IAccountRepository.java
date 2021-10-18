package com.greenapex.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.greenapex.entity.Account;
import com.greenapex.entity.Customer;
import com.greenapex.entity.Registration;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer>{
  
	  @Query("FROM Account a where a.customer.customerId= :customerId")
	   public Account findAccountByCustomerId(@Param("customerId") Integer customerId);
	
	/*  @Query("FROM Account a where a.customer.firstName= :userName")
	  public Account findAccountByUserName(@Param("userName") String userName);*/

     
}
