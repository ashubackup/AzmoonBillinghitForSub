package com.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Tbl_Player")
public class TblPlayer 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pId;
	private LocalDateTime dateTime;
	private String game;
	private String position;
	private int score;
	private String service;
	private Integer sub_player_foreign;
	
}
