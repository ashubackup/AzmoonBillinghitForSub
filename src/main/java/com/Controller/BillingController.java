package com.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.Entity.BillingEntity;
import com.Repository.TblBillingRepo;
import com.Service.BillingService;

//@RestController
@Component
public class BillingController {

	@Autowired
	BillingService billingService;
	
	@Autowired
	TblBillingRepo billingRepo;
	
//	@GetMapping("/billing")
	
	@Scheduled(fixedDelay  = 1000L)
	public void billingThread1() 
	{
		
		try {
			String status="0";
			String type = "sub";
			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
			if(entity.size()!=0)
			{
				for(BillingEntity entity2 : entity)
				{
					List<BillingEntity> billingEntities = billingRepo.findByAni(entity2.getAni());
					billingService.hitBilling(billingEntities);
				}
				
			}
		}
		
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();	
		}

	}
//	@Scheduled(fixedDelay  = 1000L)
//
//	public void billingThread2()
//	{
//		try {
//			
//			String status="1";
//			String type = "sub";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0)
//			{
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//	}
////	@Scheduled(fixedDelay  = 1000L)
////
////	public void billingThread3()
////	{
////		try {
////			
////			String status="2";
////			String type = "sub";
////			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
////			if(entity.size()!=0) {
////				billingService.hitBilling(entity);
////			}
////		}
////		catch (Exception e) {
////			// TODO: handle exception
////			e.printStackTrace();
////			
////		}
////	}
////	@Scheduled(fixedDelay  = 1000L)
////
////	public void billingThread4()
////	{
////		try {
////			
////			String status="3";
////			String type = "sub";
////			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
////			if(entity.size()!=0) {
////				billingService.hitBilling(entity);
////			}
////		}
////		catch (Exception e) {
////			// TODO: handle exception
////			e.printStackTrace();
////			
////		}
////	}
////	
////	@Scheduled(fixedDelay  = 1000L)
////
////	public void billingThread5()
////	{
////		try {
////			
////			String status="4";
////			String type = "sub";
////			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
////			if(entity.size()!=0){
////				billingService.hitBilling(entity);
////			}
////		}
////		catch (Exception e) {
////			// TODO: handle exception
////			e.printStackTrace();
////			
////		}
////	}
////
////	
////	@Scheduled(fixedDelay  = 1000L)
////
////	public void billingThread6()
////	{
////		try {
////			
////			String status="5";
////			String type = "sub";
////			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
////			if(entity.size()!=0) {
////				billingService.hitBilling(entity);
////			}
////		}
////		catch (Exception e) {
////			// TODO: handle exception
////			e.printStackTrace();
////			
////		}
////	}
//
//	
////	@Scheduled(fixedDelay  = 1000L)
////
////	public void billingThread7()
////	{
////		try {
////			
////			String status="6";
////			String type = "sub";
////			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
////			if(entity.size()!=0) {
////				billingService.hitBilling(entity);
////			}
////		}
////		catch (Exception e) {
////			// TODO: handle exception
////			e.printStackTrace();
////			
////		}
////	}
//
//	
////	@Scheduled(fixedDelay  = 1000L)
////
////	public void billingThread8()
////	{
////		try {
////			
////			String status="7";
////			String type = "sub";
////			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
////			if(entity.size()!=0) {
////				billingService.hitBilling(entity);
////			}
////		}
////		catch (Exception e) {
////			// TODO: handle exception
////			e.printStackTrace();
////			
////		}
////	}
////
////	
////	@Scheduled(fixedDelay  = 1000L)
////
////	public void billingThread9()
////	{
////		try {
////			
////			String status="8";
////			String type = "sub";
////			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
////			if(entity.size()!=0){
////				billingService.hitBilling(entity);
////			}
////		}
////		catch (Exception e) {
////			// TODO: handle exception
////			e.printStackTrace();
////			
////		}
////	}
////
////	
////	@Scheduled(fixedDelay  = 1000L)
////
////	public void billingThread10()
////	{
////		try {
////			
////			String status="9";
////			String type = "sub";
////			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
////			if(entity.size()!=0){
////				billingService.hitBilling(entity);
////			}
////		}
////		catch (Exception e) {
////			// TODO: handle exception
////			e.printStackTrace();
////			
////		}
////	}
////
////	
////	@Scheduled(fixedDelay  = 1000L)
////
////	public void billingThread11()
////	{
////		try {
////			
////			String status="10";
////			String type = "sub";
////			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
////			if(entity.size()!=0){
////				billingService.hitBilling(entity);
////			}
////		}
////		catch (Exception e) {
////			// TODO: handle exception
////			e.printStackTrace();
////			
////		}
////	}
////
////	
////	@Scheduled(fixedDelay  = 1000L)
////
////	public void billingThread12()
////	{
////		try {
////			
////			String status="11";
////			String type = "sub";
////			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
////			if(entity.size()!=0) {
////				billingService.hitBilling(entity);
////			}
////		}
////		catch (Exception e) {
////			// TODO: handle exception
////			e.printStackTrace();
////			
////		}
////	}
////
////	
////	@Scheduled(fixedDelay  = 1000L)
////
////	public void billingThread13()
////	{
////		try {
////			
////			String status="12";
////			String type = "sub";
////			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
////			if(entity.size()!=0) {
////				billingService.hitBilling(entity);
////			}
////		}
////		catch (Exception e) {
////			// TODO: handle exception
////			e.printStackTrace();
////			
////		}
////	}
////
////	
////	@Scheduled(fixedDelay  = 1000L)
////
////	public void billingThread14()
////	{
////		try {
////			
////			String status="13";
////			String type = "sub";
////			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
////			if(entity.size()!=0) {
////				billingService.hitBilling(entity);
////			}
////		}
////		catch (Exception e) {
////			// TODO: handle exception
////			e.printStackTrace();
////			
////		}
////	}
////
////	
////	@Scheduled(fixedDelay  = 1000L)
////
////	public void billingThread15()
////	{
////		try {
////			
////			String status="14";
////			String type = "sub";
////			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
////			if(entity.size()!=0){
////				billingService.hitBilling(entity);
////			}
////		}
////		catch (Exception e) {
////			// TODO: handle exception
////			e.printStackTrace();
////			
////		}
////	}
////
////	
////	@Scheduled(fixedDelay  = 1000L)
////
////	public void billingThread16()
////	{
////		try {
////			
////			String status="15";
////			String type = "sub";
////			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
////			if(entity.size()!=0) {
////				billingService.hitBilling(entity);
////			}
////		}
////		catch (Exception e) {
////			// TODO: handle exception
////			e.printStackTrace();
////			
////		}
////	}
////
////	
////	@Scheduled(fixedDelay  = 1000L)
////
////	public void billingThread17()
////	{
////		try {
////			
////			String status="16";
////			String type = "sub";
////			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
////			if(entity.size()!=0) {
////				billingService.hitBilling(entity);
////			}
////		}
////		catch (Exception e) {
////			// TODO: handle exception
////			e.printStackTrace();
////			
////		}
////	}
////
////	
////	@Scheduled(fixedDelay  = 1000L)
////
////	public void billingThread18()
////	{
////		try {
////			
////			String status="17";
////			String type = "sub";
////			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
////			if(entity.size()!=0) {
////				billingService.hitBilling(entity);
////			}
////		}
////		catch (Exception e) {
////			// TODO: handle exception
////			e.printStackTrace();
////			
////		}
////	}
////
////	
////	@Scheduled(fixedDelay  = 1000L)
////
////	public void billingThread19()
////	{
////		try {
////			
////			String status="18";
////			String type = "sub";
////			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
////			if(entity.size()!=0) {
////				billingService.hitBilling(entity);
////			}
////		}
////		catch (Exception e) {
////			// TODO: handle exception
////			e.printStackTrace();
////			
////		}
////	}
//
}
