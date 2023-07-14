package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Entity.TblPlayer;

@Repository
public interface Tbl_PlayerRepo extends JpaRepository<TblPlayer, Integer>
{
	@Query(value="Select * from tbl_player where sub_player_foreign =:value",nativeQuery=true)
	public List<TblPlayer> getRecord(@Param("value") Integer id);
}
