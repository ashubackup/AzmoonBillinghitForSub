package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Entity.TblBillingSuccess;

@Repository
public interface TblBillingSuccessRepo extends JpaRepository<TblBillingSuccess,Integer> 
{
	@Query(value="SELECT COUNT(ani) FROM tbl_billing_success WHERE DATE(billingDateTime)=DATE(SUBDATE(NOW(),0)) AND ani=:ani",nativeQuery = true)
	int getCount(@Param("ani") String ani);

}
