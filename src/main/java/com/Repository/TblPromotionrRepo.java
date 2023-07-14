package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Entity.TblApi;
import com.Entity.TblPromotion;

@Repository
public interface TblPromotionrRepo extends JpaRepository<TblPromotion, Integer> 
{
	@Query(value="Select * from tbl_promotion_base where status=:status limit :limit",nativeQuery=true)
	public List<TblPromotion> getData(@Param("status")String status,@Param("limit")Integer limit);
	
	
	public List<TblPromotion> findByStatus(String status);
}
