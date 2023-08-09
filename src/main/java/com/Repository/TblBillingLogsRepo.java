package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Entity.TblBillingLogs;

@Repository
public interface TblBillingLogsRepo extends JpaRepository<TblBillingLogs, Integer>
{
	@Query(value="Select * from tbl_billing_logs where status='Failed' and failedStatus='0' and date(DATETIME)=date(curdate())",nativeQuery=true)
	public List<TblBillingLogs> getForFailed();
	
	List<TblBillingLogs> findByStatusAndFailedStatus(String status,String failedstatus);
	
	List<TblBillingLogs> findByAni(String ani);
}
