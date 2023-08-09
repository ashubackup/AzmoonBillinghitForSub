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
@Table(name="tbl_unsubscription")
public class TblUnsubscription 

{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ani ;
	private String pack;
	private LocalDateTime dateTime;
	private String status;
	private String type;
	private String language;
	private String request;
	private String mAct;
	private String mDeact;
	private LocalDateTime subDateTime;
	private LocalDateTime unsubDateTime;
	private String txnId;
}
