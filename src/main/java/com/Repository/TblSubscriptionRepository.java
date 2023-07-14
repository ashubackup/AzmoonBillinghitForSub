package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Entity.TblSubscription;

@Repository
public interface TblSubscriptionRepository extends JpaRepository<TblSubscription, Integer>
{
	public List<TblSubscription> findByAni(String ani);
	
	@Query(value="SELECT * FROM tbl_subscription WHERE DATE(nextBilledDateTime)<=DATE(SUBDATE(NOW(),0)) and pickStatus:status",nativeQuery=true)
	public List<TblSubscription> getForREN(@Param("status") String status);
	
	@Query(value="Select * from tbl_subscription where ani=:ani",nativeQuery=true)
	public TblSubscription getAni(String ani);
//	public List<TblSubscription> get();
	
	@Query(value="SELECT * FROM tbl_subscription WHERE nextBilledDateTime IS NULL",nativeQuery=true)
	public List<TblSubscription> getNullNumber();
}