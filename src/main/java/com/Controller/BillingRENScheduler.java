//package com.Controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.Entity.BillingEntity;
//import com.Repository.TblBillingRepo;
//import com.Service.BillingService;
//
//@Component
//public class BillingRENScheduler 
//{
//
//	@Autowired
//	TblBillingRepo billingRepo;
//	
//	@Autowired
//	BillingService billingService;
////	
////	@Scheduled(fixedDelay  = 1000L)
////	public void getRenType()
////	{
////		try {
////		String status = "0";
////		String type="REN";
//////		
////				
////			List<BillingEntity> entity = billingRepo.findByStatusAndType(status, type);
////			if(entity.size()!=0) {
////			System.out.print("Thread For status 0:::");
////			billingService.hitBilling(entity);
////			}
////			
//////			}
////		}catch (Exception e) {
////			// TODO: handle exception
////			e.printStackTrace();
////			System.out.println("Exception in BillingRenType"+e.getMessage());
////		}
////	}
//	
//	
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread2() {
//		
//		try {
//			String status="1";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 1::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread3() {
//		
//		try {
//			String status="2";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				
//				System.out.print("Thread For status 2:::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread4() {
//		
//		try {
//			
//			String status="3";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 3:::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread5() {
//		
//		try {
//			
//			String status="4";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//			
//				System.out.print("Thread For status 4:::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread6() {
//		
//		try {
//			String status="5";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				
//				System.out.print("Thread For status 5::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread7() {
//		
//		try {
//			String status="6";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				
//				System.out.print("Thread For status 6::::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread8() {
//		
//		try {
//			String status="7";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 7:::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread9() {
//		
//		try {
//			String status="8";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {			
//				System.out.print("Thread For status 8::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread10() {
//		
//		try {
//			String status="9";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 9:::::");
//
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread11() {
//		
//		try {
//			String status="10";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 10::::");
//
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread12() {
//		
//		try {
//			String status="11";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				
//				System.out.print("Thread For status 11::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread13() {
//		
//		try {
//			String status="12";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 12::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread14() {
//		
//		try {
//			String status="13";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 13::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread15() {
//		
//		try {
//			String status="14";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 14::::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread16() {
//		
//		try {
//			String status="15";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 15::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread17() {
//		
//		try {
//			String status="16";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 16:::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread18() {
//		
//		try {
//			String status="17";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 17::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread19() {
//		
//		try {
//			String status="18";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 18::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread20() {
//		
//		try {
//			String status="19";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 19:::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread21() {
//		
//		try {
//			String status="20";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 20:::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread22() {
//		
//		try {
//			String status="21";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 21::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread23() {
//		
//		try {
//			String status="22";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 22:::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread24() {
//		
//		try {
//			String status="23";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 23::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread25() {
//		
//		try {
//			String status="24";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread26() {
//		
//		try {
//			String status="25";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread27() {
//		
//		try {
//			String status="26";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread28() {
//		
//		try {
//			String status="27";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread29() {
//		
//		try {
//			String status="28";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread30() {
//		
//		try {
//			String status="29";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread31() {
//		
//		try {
//			String status="30";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread32() {
//		
//		try {
//			String status="31";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread33() {
//		
//		try {
//			String status="32";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread34() {
//		
//		try {
//			String status="33";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread35() {
//		
//		try {
//			String status="34";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread36() {
//		
//		try {
//			String status="35";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread37() {
//		
//		try {
//			String status="36";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000)
//	public void billingThread38() {
//		
//		try {
//			String status="37";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//
//	
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread39() {
//		
//		try {
//			String status="38";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread40() {
//		
//		try {
//			String status="39";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread41() {
//		
//		try {
//			String status="40";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread42() {
//		
//		try {
//			String status="41";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread43() {
//		
//		try {
//			String status="42";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread44() {
//		
//		try {
//			String status="43";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay = 1000L)
//	public void billingThread45() {
//		
//		try {
//			String status="44";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread46() {
//		
//		try {
//			String status="45";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread47() {
//		
//		try {
//			String status="46";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread48() {
//		
//		try {
//			String status="47";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread49() {
//		
//		try {
//			String status="48";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread50() {
//		
//		try {
//			String status="49";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//	
//	@Scheduled(fixedDelay  = 1000L)
//	public void billingThread51() {
//		
//		try {
//			String status="50";
//			String type = "REN";
//			List<BillingEntity> entity = billingRepo.findByStatusAndType(status,type);
//			if(entity.size()!=0) {
//				System.out.print("Thread For status 24::::");
//				billingService.hitBilling(entity);
//			}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}
//}
