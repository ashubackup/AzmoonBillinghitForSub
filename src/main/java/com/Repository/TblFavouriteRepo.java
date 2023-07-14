package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Entity.TblFavourite;

@Repository
public interface TblFavouriteRepo extends JpaRepository<TblFavourite, Integer>
{
	@Query(value="Select * from tbl_favourite where sub_favourite_foreign=:value",nativeQuery=true)
	public List<TblFavourite> getFavRecord(@Param("value") Integer value);
}
