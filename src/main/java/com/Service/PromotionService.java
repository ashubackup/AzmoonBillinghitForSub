package com.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Entity.TblMessage;
import com.Entity.TblPromotion;
import com.Entity.TblSmsData;
import com.Repository.TblMessageRepo;
import com.Repository.TblPromotionrRepo;
import com.Repository.Tbl_SmsRepo;
import com.Repository.Tbl_Sms_DataRepo;

@Service
public class PromotionService 
{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	Tbl_Sms_DataRepo dataRepo;
	
	@Autowired
	TblMessageRepo messageRepo;
	
//	@Autowired
//	Tbl_SmsRepo dataRepo2;
	
	@Autowired
	TblPromotionrRepo repo;

	public void sendPromotionMessage(TblPromotion promotion,int number)
	{
		
		try {
			
			String status="1";
			TblSmsData data = dataRepo.findByStatus(status);
			
				List<TblMessage> getLanguage = messageRepo.findByLanguage(promotion.getLanguage());
				for(TblMessage message : getLanguage)
				{
					System.out.println("Control inside Service"+number);
					if(number==1) {
					if(message.getType().equalsIgnoreCase("EP1") || message.getType().equalsIgnoreCase("DP1") || message.getType().equalsIgnoreCase("PP1"))
					{
						TblMessage tblMessage = messageRepo.findByTypeAndLanguage(message.getType(),message.getLanguage());
						String text = data.getUrl();
						String req= text.replace("<ani>",String.valueOf(promotion.getAni()));
						String url = req.replace("<message>", message.getMessage());
						System.out.println("The request is"+url);
						ResponseEntity<String> entity= restTemplate.getForEntity(url, String.class);
						String body = entity.getBody();
						HttpStatus httpStatus = entity.getStatusCode();
						
						promotion.setStatus("Send");
						promotion.setPromotionDate(LocalDateTime.now());
						promotion.setRequest(url);
						promotion.setResponse(body);
						repo.save(promotion);
//						System.out.println("Pr");
						
					}
					else if(number==2)
					{

							if(message.getType().equalsIgnoreCase("EP2") || message.getType().equalsIgnoreCase("DP2") || message.getType().equalsIgnoreCase("PP2"))
							{
								TblMessage tblMessage = messageRepo.findByTypeAndLanguage(message.getType(),message.getLanguage());
								String text = data.getUrl();
								String req= text.replace("<ani>",String.valueOf(promotion.getAni()));
								String url = req.replace("<message>", message.getMessage());
								System.out.println("The request is"+url);
								ResponseEntity<String> entity= restTemplate.getForEntity(url, String.class);
								String body = entity.getBody();
								HttpStatus httpStatus = entity.getStatusCode();
								
								promotion.setStatus("Send");
								promotion.setPromotionDate(LocalDateTime.now());
								promotion.setRequest(url);
								promotion.setResponse(body);
								repo.save(promotion);
//								System.out.println("Pr");
								
							}
							
					}
					else if(number==3)
					{
							if(message.getType().equalsIgnoreCase("EP3") || message.getType().equalsIgnoreCase("DP3") || message.getType().equalsIgnoreCase("PP3"))
							{
								TblMessage tblMessage = messageRepo.findByTypeAndLanguage(message.getType(),message.getLanguage());
								String text = data.getUrl();
								String req= text.replace("<ani>",String.valueOf(promotion.getAni()));
								String url = req.replace("<message>", message.getMessage());
								System.out.println("The request is"+url);
								ResponseEntity<String> entity= restTemplate.getForEntity(url, String.class);
								String body = entity.getBody();
								HttpStatus httpStatus = entity.getStatusCode();
								
								promotion.setStatus("Send");
								promotion.setPromotionDate(LocalDateTime.now());
								promotion.setRequest(url);
								promotion.setResponse(body);
								repo.save(promotion);
//								System.out.println("Pr");
								
							}
					}
					
				}
			}
			
	
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
