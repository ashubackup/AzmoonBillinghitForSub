//package com.Controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.Entity.BillingEntity;
//import com.Entity.TblBillingLogs;
//import com.Repository.TblBillingLogsRepo;
//import com.Repository.TblBillingRepo;
//import com.Service.BillingService;
//
//@Component
//public class BillingFailedSchedular {
//
//	@Autowired
//	TblBillingRepo billingRepo;
//
//	@Autowired
//	TblBillingLogsRepo billingLogsRepo;
//
//	@Autowired
//	BillingService service;
//
//	@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//	public void userFailed() {
//		try {
//
//			System.out.println("Control inside Failed Schedulers");
////			String status = "Failed";
//			List<TblBillingLogs> billingLogs = billingLogsRepo.getForFailed();
//			System.out.println("The value of Failed Status List" + billingLogs);
//			System.out.println("The size of Failed Status List is" + billingLogs.size());
//			int count = 0;
//			int status = 1;
//			if (billingLogs.size() != 0) {
//
//				for (TblBillingLogs logs : billingLogs) {
//
//					if (count <= 1000) {
//						List<BillingEntity> billing = billingRepo.findByAni(logs.getAni());
//						if (billing.size() == 0) {
//							BillingEntity billingEntity = new BillingEntity();
//							billingEntity.setAmount(logs.getAmount());
//							billingEntity.setAni(logs.getAni());
////				billingEntity.setBillingDate(logs.getBillingDate());
//							billingEntity.setBillingDateTime(logs.getBillingDateTime());
////				billingEntity.setDate(logs.getDate());
//							billingEntity.setDateTime(logs.getDateTime());
//							billingEntity.setMAct(logs.getMAct());
//							billingEntity.setPackType(logs.getPackType());
//							billingEntity.setService(logs.getService());
//							if (logs.getType() == "sub") {
//								billingEntity.setStatus("0");
//							} else {
//								billingEntity.setStatus(String.valueOf(status));
//							}
//							billingEntity.setType(logs.getType());
//							billingEntity.setLastBilledDate(logs.getLastBilledDate());
//							billingEntity.setNextBilledDate(logs.getNextBilledDate());
//							billingEntity.setLanguage(logs.getLanguage());
//
//							billingRepo.save(billingEntity);
//
//							System.out.println("Schedulers For Failed Type");
//
//							logs.setFailedStatus("Done");
//							billingLogsRepo.save(logs);
//							count++;
//							System.out.println("Status updated for failed logs");
//
//						}
//
//						else {
//							logs.setFailedStatus("AlreadyExist");
//							billingLogsRepo.save(logs);
//							System.out.println("Status Updated For AlreadyExist");
//						}
//					} else {
//						count = 0;
//						status = status + 1;
//					}
//
//				}
//
//			}
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
//
//}
