package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_favourite")
public class TblFavourite 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sub_favourite_foreign;
}
