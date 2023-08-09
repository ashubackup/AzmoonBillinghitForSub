package com.Entity;

import java.time.LocalDate;
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
@Table(name="tbl_billing_success")
public class TblBillingSuccess {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String amount;
	private String ani;
	private LocalDate billingDate;
	private LocalDateTime billingDateTime;
	private LocalDate date;
	private LocalDateTime dateTime;
	private String mAct;
	private LocalDate processDate;
	private LocalDateTime processDateTime;
	private String service;
	private String status;
	private String type;
	private String packType;
	private String request;
	private String response;
	private String language;
	private String txnId;

}
