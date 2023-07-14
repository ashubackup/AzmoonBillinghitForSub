package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.TblApi;

@Repository
public interface TblApiRepository extends JpaRepository<TblApi, Integer>{
	
	public TblApi findByStatus(String status);

}
