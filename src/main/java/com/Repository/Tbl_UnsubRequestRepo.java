package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.UnSubRequest;

@Repository
public interface Tbl_UnsubRequestRepo extends JpaRepository<UnSubRequest, Integer> 
{
	
	public List<UnSubRequest> findByStatus(String status);
}
