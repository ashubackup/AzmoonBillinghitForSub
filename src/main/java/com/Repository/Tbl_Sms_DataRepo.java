package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.TblSmsData;

@Repository
public interface Tbl_Sms_DataRepo extends JpaRepository<TblSmsData, Integer>
{
	public TblSmsData findByStatus(String status);
}
