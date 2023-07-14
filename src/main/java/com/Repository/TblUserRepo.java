package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Entity.TblUser;

@Repository
public interface TblUserRepo extends JpaRepository<TblUser, Integer> {

	@Query(value="Select * from tbl_user where ani=:ani",nativeQuery=true)
	public List<TblUser> getTblUser(@Param("ani") String ani);
	
	
	public TblUser findByAni(String ani);
	

}
