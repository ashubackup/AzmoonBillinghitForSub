package com.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Entity.TblMessage;
import com.Entity.TblSmsData;
import com.Entity.TblUnsubscription;
import com.Entity.Tbl_Sms_Logs;
import com.Repository.TblMessageRepo;
import com.Repository.Tbl_SmsRepo;
import com.Repository.Tbl_Sms_DataRepo;

@Service
public class UnsubSmsService
{
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	Tbl_Sms_DataRepo dataRepo;
	
	@Autowired
	TblMessageRepo messageRepo;
	
	@Autowired
	Tbl_SmsRepo dataRepo2;
	
	public void getUnsubMessage(TblUnsubscription unsubscription)
	{
		
		try {
			System.out.println("Control inside unsub Sms api");
			String status="1";
			TblSmsData data = dataRepo.findByStatus(status);
			
//			if(unsubscription.getLanguage()!=null || unsubscription.getLanguage().isEmpty()==false) 
//			{
			System.out.println("The value of unsubscriber List"+unsubscription);
			TblMessage message = messageRepo.findByTypeAndLanguage("Unsub",unsubscription.getLanguage());
			String text = data.getUrl();
			String req= text.replace("<ani>",String.valueOf(unsubscription.getAni()));
			String url = req.replace("<message>", message.getMessage());
			System.out.println("The value from tbl_message is"+message);
			
			ResponseEntity<String> entity= restTemplate.getForEntity(url, String.class);
			String body = entity.getBody();
			HttpStatus httpStatus = entity.getStatusCode();
			
			Tbl_Sms_Logs logs = new Tbl_Sms_Logs();
			logs.setAni(String.valueOf(unsubscription.getAni()));
			logs.setMessage(message.getMessage());
			logs.setPackType(unsubscription.getPack());
			logs.setRequest(url);
			logs.setResponse(body);
			logs.setDateTime(LocalDateTime.now());
			logs.setLanguage(message.getLanguage());
			System.out.println("Unsub Message Send Successfully");
			dataRepo2.save(logs);
			
//			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Exception in UnsubMessage"+e.getMessage());
			
		}
	}
}
