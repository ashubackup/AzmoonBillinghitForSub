package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Entity.TblMessage;

@Repository
public interface TblMessageRepo extends JpaRepository<TblMessage, Integer>
{
	public TblMessage findByTypeAndLanguage (String type,String language);
	
	@Query(value="Select * from tbl_message where type=:type and language=:language",nativeQuery=true)
	public List<TblMessage> getPromotionMessage(@Param("type")String type,@Param("language") String language);
	
	List<TblMessage> findByLanguage(String language);
}
