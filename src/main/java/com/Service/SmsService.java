package com.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Entity.BillingEntity;
import com.Entity.TblMessage;
import com.Entity.TblSmsData;
import com.Entity.Tbl_Sms_Logs;
import com.Repository.TblMessageRepo;
import com.Repository.Tbl_SmsRepo;
import com.Repository.Tbl_Sms_DataRepo;

@Service
public class SmsService 
{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	Tbl_Sms_DataRepo dataRepo;
	
	@Autowired
	TblMessageRepo messageRepo;
	
	@Autowired
	Tbl_SmsRepo dataRepo2;
	
	public void sendSms(BillingEntity entities) 
	
	{
//		 get Billing Entity in method parameter
	
		
		try {
			
			String status="1";
			TblSmsData data = dataRepo.findByStatus(status);
			TblMessage message = messageRepo.findByTypeAndLanguage(entities.getPackType(),entities.getLanguage());
			String text = data.getUrl();
			String req= text.replace("<ani>",String.valueOf(entities.getAni()));
			String url = req.replace("<message>", message.getMessage());
			System.out.println("The request is"+url);
			ResponseEntity<String> entity= restTemplate.getForEntity(url, String.class);
			String body = entity.getBody();
			HttpStatus httpStatus = entity.getStatusCode();
			
			Tbl_Sms_Logs logs = new Tbl_Sms_Logs();
			logs.setAni(String.valueOf(entities.getAni()));
			logs.setMessage(message.getMessage());
			logs.setPackType(entities.getPackType());
			logs.setRequest(url);
			logs.setResponse(body);
			logs.setDateTime(LocalDateTime.now());
			logs.setLanguage(entities.getLanguage());
			System.out.println("New Subscriber Send Message Successfully");
			dataRepo2.save(logs);
			
			
		}catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	}
}
