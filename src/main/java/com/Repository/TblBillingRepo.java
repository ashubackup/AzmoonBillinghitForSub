package com.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.BillingEntity;
import com.Model.Tbl_Billing_Model;

@Repository
public interface TblBillingRepo extends JpaRepository<BillingEntity, Integer> {
	
	public List<BillingEntity> findByStatusAndType(String status,String type);
	
//	@Query(value="Select * from tbl_billing where status=:status and type=sub",nativeQuery= true)
//	public List
//	
	public List<BillingEntity> findByStatus(String status);
	public List<BillingEntity> findByAni(long ani);
	
	public List<BillingEntity> findByType(String type);
	
}
