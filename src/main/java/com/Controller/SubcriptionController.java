//package com.Controller;
//
//import java.time.LocalDate;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import com.Entity.BillingEntity;
//import com.Entity.TblSubscription;
//import com.Repository.TblBillingRepo;
//import com.Repository.TblSubscriptionRepository;
//import com.Service.SubscriptionService;
//
////@RestController
//@Component
//public class SubcriptionController {
//
//	@Autowired
//	TblSubscriptionRepository subscriptionRepository;
//
//	@Autowired
//	SubscriptionService service;
//
//	@Autowired
//	TblBillingRepo billingRepo;
//
////	@GetMapping("/sub")
//	@Scheduled(cron = "0 0 4 * * *", zone = "Asia/Kolkata")
////@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//	public void getTypeRenForThread1() {
//
//		try {
//			String status="1";
//			System.out.println("Control Inside Subscription");
//			List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////				System.out.println("value of subscription is"+subscription);
//			if (subscription.size() != 0) {
////					System.out.println("Control inside if");
//				service.saveRenTypeInBilling(subscription);
//			}
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			System.out.println("Exception in Subscription Controller" + e.getMessage());
//		}
//
//	}
//
//	@Scheduled(cron = "0 0 5 * * ?", zone = "Asia/Kolkata")
////	@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//	public void getNullFromSub() {
//		try {
//			List<TblSubscription> getData = subscriptionRepository.getNullNumber();
//
//			if (getData.size() != 0) {
//
//				for (TblSubscription subscription : getData) {
//
//					List<BillingEntity> billingRecord = billingRepo.findByAni(Long.parseLong(subscription.getAni()));
//					if (billingRecord.size() == 0) {
//						
//							BillingEntity billingEntity = new BillingEntity();
//							billingEntity.setAmount(subscription.getAmount());
//							billingEntity.setAni(Long.parseLong(subscription.getAni()));
//							billingEntity.setBillingDate(LocalDate.now());
//							billingEntity.setLanguage(subscription.getLanguage());
//							billingEntity.setMAct(subscription.getMAct());
//							billingEntity.setPackType(subscription.getPack());
//							billingEntity.setService(subscription.getService());
//							billingEntity.setStatus("8");
//							billingEntity.setType("REN");
//
//							billingRepo.save(billingEntity);
//							System.out.println("Successfully Null Billing Date Added in table tbl_billing");
//
//						
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Exception in Subscription Controller" + e.getMessage());
//
//		}
//
//	}
//	
//	
//	@Scheduled(cron = "0 1 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread2() {
//
//			try {
//				String status="2";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 2 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread3() {
//
//			try {
//				String status="3";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 3 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread4() {
//
//			try {
//				String status="4";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 24 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread5() {
//
//			try {
//				String status="5";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 4 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread6() {
//
//			try {
//				String status="6";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 5 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread7() {
//
//			try {
//				String status="7";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 6 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread8() {
//
//			try {
//				String status="8";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 7 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread9() {
//
//			try {
//				String status="9";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 8 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread10() {
//
//			try {
//				String status="10";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 9 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread11() {
//
//			try {
//				String status="11";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 10 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread12() {
//
//			try {
//				String status="12";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	@Scheduled(cron = "0 11 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread13() {
//
//			try {
//				String status="13";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	
//	@Scheduled(cron = "0 12 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread14() {
//
//			try {
//				String status="14";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 13 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread15() {
//
//			try {
//				String status="15";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 14 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread16() {
//
//			try {
//				String status="16";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 15 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread17() {
//
//			try {
//				String status="17";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	
//	@Scheduled(cron = "0 16 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread18() {
//
//			try {
//				String status="18";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 17 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread19() {
//
//			try {
//				String status="19";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	
//	@Scheduled(cron = "0 18 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread20() {
//
//			try {
//				String status="20";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 19 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread21() {
//
//			try {
//				String status="21";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	
//	@Scheduled(cron = "0 20 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread22() {
//
//			try {
//				String status="22";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	
//	@Scheduled(cron = "0 21 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread23() {
//
//			try {
//				String status="23";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	
//	@Scheduled(cron = "0 22 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread24() {
//
//			try {
//				String status="24";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	
//	@Scheduled(cron = "0 23 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread25() {
//
//			try {
//				String status="25";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	
//	@Scheduled(cron = "0 25 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread26() {
//
//			try {
//				String status="26";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 26 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread27() {
//
//			try {
//				String status="27";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 27 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread28() {
//
//			try {
//				String status="28";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 28 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread29() {
//
//			try {
//				String status="29";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 29 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread30() {
//
//			try {
//				String status="30";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 30 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread31() {
//
//			try {
//				String status="31";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 31 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread32() {
//
//			try {
//				String status="32";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 32 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread33() {
//
//			try {
//				String status="33";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 33 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread34() {
//
//			try {
//				String status="34";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 34 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread35() {
//
//			try {
//				String status="35";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 35 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread36() {
//
//			try {
//				String status="36";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 36 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread37() {
//
//			try {
//				String status="37";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	
//	@Scheduled(cron = "0 37 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread38() {
//
//			try {
//				String status="38";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	
//	@Scheduled(cron = "0 38 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread39() {
//
//			try {
//				String status="39";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 39 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread40() {
//
//			try {
//				String status="40";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 40 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread41() {
//
//			try {
//				String status="41";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 41 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread42() {
//
//			try {
//				String status="42";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 42 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread43() {
//
//			try {
//				String status="43";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 43 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread44() {
//
//			try {
//				String status="44";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	
//	@Scheduled(cron = "0 44 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread45() {
//
//			try {
//				String status="45";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 45 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread46() {
//
//			try {
//				String status="46";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 46 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread47() {
//
//			try {
//				String status="47";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 47 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread48() {
//
//			try {
//				String status="48";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 48 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread49() {
//
//			try {
//				String status="49";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//	
//	@Scheduled(cron = "0 49 4 * * *", zone = "Asia/Kolkata")
//	//@Scheduled(fixedDelay = 3 * 60 * 60 * 1000) // 3 hours in milliseconds
//
//		public void getTypeRenForThread50() {
//
//			try {
//				String status="50";
//				System.out.println("Control Inside Subscription");
//				List<TblSubscription> subscription = subscriptionRepository.getForREN(status);
////					System.out.println("value of subscription is"+subscription);
//				if (subscription.size() != 0) {
////						System.out.println("Control inside if");
//					service.saveRenTypeInBilling(subscription);
//				}
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				System.out.println("Exception in Subscription Controller" + e.getMessage());
//			}
//
//		}
//}
