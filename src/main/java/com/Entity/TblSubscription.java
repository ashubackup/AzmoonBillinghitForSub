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
@Table(name="tbl_subscription")
public class TblSubscription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ani;
	private String amount;
	private String favourite;
	private String image="https://www.gameninja.in/html/Azmoon/avatar.png";
	private String language;
	private LocalDateTime lastChecked;
	private LocalDateTime lastPlayed;
	private String mAct;
	private String mDeact;
	private String name="Player";
	private String pack;
	private String position;
	private LocalDateTime processDateTime;
	private String score;
	private String service;
	private String status;
	private LocalDateTime subDateTime;
	private LocalDateTime unsubDateTime;
	private LocalDate lastBilledDate;
	private LocalDate nextBilledDate;
	private LocalDateTime nextBilledDateTime;
	private LocalDateTime lastBilledDateTime;
	private String pickStatus;
	private String billingType;
}
