package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Tbl_Sms_Logs;

@Repository
public interface Tbl_SmsRepo extends JpaRepository<Tbl_Sms_Logs, Integer>
{
	
}
