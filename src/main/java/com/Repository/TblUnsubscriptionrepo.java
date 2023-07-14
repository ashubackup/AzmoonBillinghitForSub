package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.TblUnsubscription;

@Repository
public interface TblUnsubscriptionrepo extends JpaRepository<TblUnsubscription, Integer>
{

}
