//package com.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.Entity.BillingEntity;
//import com.Entity.TblBillingLogs;
//import com.Entity.TblFavourite;
//import com.Entity.TblPlayer;
//import com.Entity.TblSubscription;
//import com.Entity.TblUnsubscription;
//import com.Entity.TblUser;
//import com.Entity.UnSubRequest;
//import com.Repository.TblBillingLogsRepo;
//import com.Repository.TblBillingRepo;
//import com.Repository.TblFavouriteRepo;
//import com.Repository.TblSubscriptionRepository;
//import com.Repository.TblUnsubscriptionrepo;
//import com.Repository.TblUserRepo;
//import com.Repository.Tbl_PlayerRepo;
//import com.Repository.Tbl_UnsubRequestRepo;
//
//@Service
//public class Tbl_UnsubcriptionService {
//	@Autowired
//	Tbl_UnsubRequestRepo tbl_UnsubscriptionRepo;
//
//	@Autowired
//	TblSubscriptionRepository repository;
//
//	@Autowired
//	TblUnsubscriptionrepo tblUnsubscriptionrepo;
//
//	@Autowired
//	TblUserRepo repo;
//
//	@Autowired
//	Tbl_PlayerRepo playerRepo;
//
//	@Autowired
//	TblFavouriteRepo favouriteRepo;
//	
//	@Autowired
//	UnsubSmsService service;
//	
//	@Autowired
//	TblBillingLogsRepo logsRepo;
//
//	@Autowired
//	TblBillingRepo billingRepo;
//	
//	public void unsubRequest(List<UnSubRequest> request) {
//
//		System.out.println("The value of unsub req in service class"+request);
//		
//		for (UnSubRequest unSubRequest : request) 
//		
//		{
//			try {
//			List<TblSubscription> getAni = repository.findByAni(unSubRequest.getMsisdn());
//			
//			if (getAni.size() != 0) 
//			{
//				
//				for (TblSubscription subscription : getAni) {
//					
//					System.out.println("The value of subscription class is"+subscription);
//
////						
//				TblUnsubscription tblUnsubscription = new TblUnsubscription();
//				tblUnsubscription.setAni(subscription.getAni());
//				tblUnsubscription.setDateTime(LocalDateTime.now());
//				tblUnsubscription.setPack(subscription.getPack());
//				tblUnsubscription.setStatus("SuccessUnsub");
//				tblUnsubscription.setType(unSubRequest.getType());
//				tblUnsubscription.setLanguage(subscription.getLanguage());
//				tblUnsubscription.setRequest(unSubRequest.getRequest());
//				if(unSubRequest.getType()!=null)
//				{
//				tblUnsubscription.setMDeact(unSubRequest.getType());
//				}
//				else {
//					tblUnsubscription.setMDeact("sms");
//				}
//				tblUnsubscription.setMAct(subscription.getMAct());
//				tblUnsubscription.setSubDateTime(subscription.getSubDateTime());
//				tblUnsubscription.setUnsubDateTime(LocalDateTime.now());
//				tblUnsubscriptionrepo.save(tblUnsubscription);
//				System.out.println("DATA ADDEDD IN TABLE UNSUBSCRIPTION");
//				List<TblBillingLogs> billingLogs = logsRepo.findByAni(subscription.getAni());
//				if(billingLogs.size()!=0)
//				{
//					for(TblBillingLogs logs : billingLogs)
//					{
//						logs.setFailedStatus("Unsubscriber");
//						logsRepo.save(logs);
//						System.out.println("Status Updated in tbl_Billing_logs for Unsubscription");
//						try {
//						List<BillingEntity> billingDeleteNumber = billingRepo.findByAni(logs.getAni());
//						if(billingDeleteNumber.size()!=0) {
//						for(BillingEntity entity : billingDeleteNumber)
//						{
//							billingRepo.delete(entity);
//							System.out.println("Deleted Entity from tbl_billing for unsubscription");
//						}
//						}
//						
//						
//					}catch (Exception e) {
//						// TODO: handle exception
//						e.printStackTrace();
//						System.out.println("Exception in Exception Not Value in Billing "+e.getMessage());
//						unSubRequest.setStatus("Failed");
//						tbl_UnsubscriptionRepo.save(unSubRequest);
//						}
//					}
//				}
//				
//				try {
//					
//					
//					List<TblFavourite> favouriteKey = favouriteRepo.getFavRecord(subscription.getId());
//					List<TblPlayer> foreignKey = playerRepo.getRecord(subscription.getId());
//					if(foreignKey.size()!=0) 
//					{
//						for(TblPlayer getValue :  foreignKey)
//						{
//							playerRepo.delete(getValue);
//							System.out.println("Record SuccessFully Deleted");
//						}
//					}
//					if(favouriteKey.size()!=0) {
//						for(TblFavourite favourite : favouriteKey)
//						{
//							favouriteRepo.delete(favourite);
//							System.out.println("SuccessFully Value delete from Tbl_favourite");
//						}
//					}
//					repository.delete(subscription);
//					System.out.println("Data Delete From tbl_subScription");
//
//					unSubRequest.setStatus("Success");
//					tbl_UnsubscriptionRepo.save(unSubRequest);
//					System.out.println("Status Updated");
//					
//
//					service.getUnsubMessage(tblUnsubscription);
//
//					
//				}catch (Exception e) {
//					// TODO: handle exception
//					e.printStackTrace();
//					System.out.println("Exception Inside Unsub Service:::::"+e.getMessage());
//					unSubRequest.setStatus("Failed");
//					tbl_UnsubscriptionRepo.save(unSubRequest);
//				}
//				
//				
////				System.out.println("The value after calling service.getUnsubMessage method");
//				
//
//				
//				
//				try {
//					
//					List<TblUser> tblUser = repo.getTblUser(tblUnsubscription.getAni());
//					if(tblUser.size()!=0)
//					{
//						for(TblUser user : tblUser)
//						{
//							repo.delete(user);
//						}
//						unSubRequest.setStatus("Success");
//						tbl_UnsubscriptionRepo.save(unSubRequest);
//
//					}
////					TblUser tblUser = repo.findByAni(subscription.getAni());
////					if (tblUser != null) {
////						repo.delete(tblUser);
////						unSubRequest.setStatus("Success");
////					tbl_UnsubscriptionRepo.save(unSubRequest);
//
////						System.out.println("Data Delete From TblUser");
////					}
//
//				} catch (Exception e) {
//					// TODO: handle exception
//						e.printStackTrace();
//					unSubRequest.setStatus("Success");
//					tbl_UnsubscriptionRepo.save(unSubRequest);
//
//				}
//			}
//
//			} else {
//				unSubRequest.setStatus("NotSub");
//				tbl_UnsubscriptionRepo.save(unSubRequest);
//			}
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			unSubRequest.setStatus("Failed");
//			tbl_UnsubscriptionRepo.save(unSubRequest);
//		}
//		}
//	}
//
//}
