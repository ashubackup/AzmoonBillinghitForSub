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
@Table(name = "tbl_billing_logs")
public class TblBillingLogs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String amount;
	private String ani;
	private String type;
	private LocalDateTime dateTime;
	private String status;
	private String packType;
//	private double price;
	private LocalDateTime lastBilledDate;
	private LocalDateTime nextBilledDate;
	private String request;
	private String response;
	private LocalDateTime processDateTime;
	private LocalDate processDate;
	private String service;
	private LocalDate billingDate;
	private LocalDateTime billingDateTime;
	private LocalDate date;
	private String mAct;
	private String language;
	private String failedStatus;
	private String txnId;


}
