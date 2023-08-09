package com.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.Entity.BillingEntity;
import com.Entity.TblApi;
import com.Entity.TblBillingLogs;
import com.Entity.TblBillingSuccess;
import com.Entity.TblDnd;
import com.Entity.TblFavourite;
import com.Entity.TblPlayer;
import com.Entity.TblSubscription;
import com.Entity.TblUnsubscription;
import com.Entity.TblUser;
import com.Repository.TblApiRepository;
import com.Repository.TblBillingLogsRepo;
import com.Repository.TblBillingRepo;
import com.Repository.TblBillingSuccessRepo;
import com.Repository.TblDndRepo;
import com.Repository.TblFavouriteRepo;
import com.Repository.TblSubscriptionRepository;
import com.Repository.TblUnsubscriptionrepo;
import com.Repository.TblUserRepo;
import com.Repository.Tbl_PlayerRepo;

@Service

public class BillingService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	TblBillingRepo billingRepo;

	@Autowired
	TblApiRepository apiRepository;

	@Autowired
	TblSubscriptionRepository subscriptionRepository;

	@Autowired
	TblBillingLogsRepo logsRepo;

	@Autowired
	TblBillingSuccessRepo repo;

	@Autowired
	TblUserRepo tblUserRepo;

	@Autowired
	SmsService service;

	@Autowired
	TblDndRepo dndRepo;

	@Autowired
	TblUnsubscriptionrepo tblUnsubscriptionrepo;

	@Autowired
	Tbl_PlayerRepo playerRepo;

	@Autowired
	TblFavouriteRepo favouriteRepo;

	public void billingRecordForSub() {

		try {
//			hitBilling(entity);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void hitBilling(List<BillingEntity> list,String threadStatus) {

//			String url = "http://43.250.139.33:10381/TisService";

		TblApi req = apiRepository.findByStatus("1");
		for (BillingEntity entity : list) {
			if (entity.getAni().startsWith("70180") || entity.getAni().startsWith("70280")
					|| entity.getAni().startsWith("70380") || entity.getAni().startsWith("70480")
					|| entity.getAni().startsWith("70580") || entity.getAni().startsWith("70680")
					|| entity.getAni().startsWith("70780") || entity.getAni().startsWith("70880")
					|| entity.getAni().startsWith("70980") || entity.getAni().startsWith("71180"))
			{
				TblDnd dnd = new TblDnd();
				dnd.setAni(entity.getAni());
				dnd.setDate(LocalDateTime.now());	
				dnd.setStatus("1");
				dndRepo.save(dnd);
				
				TblUnsubscription tblUnsubscription = new TblUnsubscription();
				tblUnsubscription.setAni(String.valueOf(entity.getAni()));
				tblUnsubscription.setPack(entity.getPackType());
				tblUnsubscription.setDateTime(LocalDateTime.now());
				tblUnsubscription.setStatus("DND");
				tblUnsubscription.setType(entity.getType());
				tblUnsubscription.setLanguage(entity.getLanguage());
				tblUnsubscriptionrepo.save(tblUnsubscription);
				try {
					TblSubscription subscription = subscriptionRepository.getAni(entity.getAni());

					List<TblFavourite> favouriteKey = favouriteRepo.getFavRecord(subscription.getId());
					List<TblPlayer> foreignKey = playerRepo.getRecord(subscription.getId());
					if (foreignKey.size() != 0) {
						for (TblPlayer geyValue : foreignKey) {
							playerRepo.delete(geyValue);
							System.out.println("Record SuccessFully Deleted");
						}
					}
					if (favouriteKey.size() != 0) {
						for (TblFavourite favourite : favouriteKey) {
							favouriteRepo.delete(favourite);
							System.out.println("SuccessFully Value delete from Tbl_favourite");
						}
					}
					subscriptionRepository.delete(subscription);
					System.out.println("Data Delete From tbl_subScription Due To Table DND");

					billingRepo.delete(entity);
					System.out.println("Data Deleted From tblBilling Due to DND Table");

					List<TblBillingLogs> billingLogs = logsRepo.findByAni(entity.getAni());
					for (TblBillingLogs logs : billingLogs) {
						logs.setFailedStatus("Unsub");
						logsRepo.save(logs);
					}

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					System.out.println("Exception Inside HitBilling Service:::::" + e.getMessage());
					billingRepo.delete(entity);
					System.out.println("Data Deleted From tblBilling Due to DND Table");

				}


			} else {
				
								
				//Start
				
				List<TblDnd> dnd = dndRepo.findByAni(entity.getAni().trim());
				System.out.println("Dnd Size" + dnd.size());
//			System.out.println("The value of Dnd Is"+dnd);
//			for(TblDnd tblDnd : dnd) {
//				System.out.println("The vaulue of dnd is"+tblDnd);
				if (dnd.size() == 0) {
//				List<Tbl_Billing_Model> billing_Model = billingRepo.getCountAni(String.valueOf(entity.getAni()));	

//				if(billing_Model.equals("1")) {
					String ani = entity.getAni();
					int count = repo.getCount(ani);
					if(count==0)
					{
					System.out.println("The vallue of ani is" + ani);
					String price = String.valueOf(entity.getAmount());
					System.out.println("The value of price is" + price);

					String xmlRequest = req.getRequest().replace("<price>", price);
					xmlRequest = xmlRequest.replace("<ani>", ani);

					if (entity.getMAct().equalsIgnoreCase("Promo") || entity.getMAct().equalsIgnoreCase("Migration")) {
						xmlRequest = xmlRequest.replace("<eventName>",
								"USSD_" + entity.getPackType() + "_" + "AutoRenewal");
					} else if(entity.getMAct().equalsIgnoreCase("USSD") || entity.getMAct().equalsIgnoreCase("WEB")) {
						xmlRequest = xmlRequest.replace("<eventName>",
								entity.getMAct().toUpperCase() + "_" + entity.getPackType() + "_" + "AutoRenewal");
					}
					else
					{
						xmlRequest = xmlRequest.replace("<eventName>",
								"USSD_" + entity.getPackType() + "_" + "AutoRenewal");
					}


					HttpHeaders headers = new HttpHeaders();
					headers.setContentType(MediaType.APPLICATION_XML);

					HttpEntity<String> request = new HttpEntity<String>(xmlRequest, headers);
					System.out.println("The value of request is" + threadStatus + ":::::" + request);
					String body = "";
					try {

						ResponseEntity<String> responseEntity = restTemplate.postForEntity(req.getUrl(), request,
								String.class);
						body = responseEntity.getBody();
						Integer status = responseEntity.getStatusCodeValue();
						System.out.println("Value of status is" + status);

						if (status == 200 || body.contains("ChargedBalances")) {

							entity.setRequest(request.toString());
							entity.setResponse(body + " " + status);
							entity.setStatus("Success");
							entity.setBillingDateTime(LocalDateTime.now());
							entity.setProcessDateTime(LocalDateTime.now());
							entity.setPackType(entity.getPackType());
							entity.setService(entity.getService());
							entity.setTxnId(entity.getTxnId());
							billingRepo.save(entity);
							System.out.println("The Response for SuccessFull" + body);

							System.out.println("Billing is Successfull");

							if (entity.getPackType().equalsIgnoreCase("Daily"))

							{
								System.out.println("Control inside the daily pack");
								LocalDateTime lastBilledDate = LocalDateTime.now();
								LocalDateTime nextBillingDate = LocalDateTime.now().plusDays(1);
								try {
									TblSubscription subscription = subscriptionRepository
											.getAni(entity.getAni().trim());
									System.out.println("The value of subscription is" + subscription);
									if (subscription != null && entity.getType().equalsIgnoreCase("REN")) {

//						subscription.setPack(entity.getPackType());
//						subscription.setLastBilledDate(lastBilledDate);
//						subscription.setNextBilledDate(nextBillingDate);
//						subscriptionRepository.save(subscription);
//						System.out.println("Record is Updated in Subscription Table");
//									entity.setLastBilledDate(lastBilledDate);
//									entity.setNextBilledDate(nextBillingDate);
//									billingRepo.save(entity);

										updateDataInSub(subscription, entity, lastBilledDate, nextBillingDate);

										saveRecordInTableLogs(entity, lastBilledDate, nextBillingDate,
												request.toString(), body + " " + status);
										saveInTableBillingSuccess(entity, request.toString(), body + " " + status);

									} else if (subscription != null && entity.getType().equalsIgnoreCase("sub")) {

										entity.setLastBilledDate(lastBilledDate);
										entity.setNextBilledDate(nextBillingDate);
										entity.setRequest(request.toString());
										entity.setResponse(body);
										billingRepo.save(entity);

										updateDataInSub(subscription, entity, lastBilledDate, nextBillingDate);
										service.sendSms(entity);
										saveRecordInTableLogs(entity, lastBilledDate, nextBillingDate,
												request.toString(), body + " " + status);
										saveInTableBillingSuccess(entity, request.toString(), body + " " + status);

									} else if (subscription == null) {
//								System.out.println("control inside else block of daily pack");
//									service.sendSms(entity);
//										saveInSub(entity, lastBilledDate, nextBillingDate);
										saveRecordInTableLogs(entity, lastBilledDate, nextBillingDate,
												request.toString(), body + " " + status);
										saveInTableBillingSuccess(entity, request.toString(), body + " " + status);

									}
								} catch (IncorrectResultSizeDataAccessException e) {
									List<TblSubscription> sub = subscriptionRepository
											.findByAni(String.valueOf(entity.getAni()));
									for (int i = 0; i < sub.size() - 1; i++) {
										subscriptionRepository.delete(sub.get(i));
										System.out.println("Duplicate Number Delete from table" + sub.get(i));

									}
								} catch (NullPointerException e) {
									// TODO: handle exception
									e.printStackTrace();
//									service.sendSms(entity);
									System.out.println("handle Null Pointer Exception");
									System.out.println("Exception In DAILY" + e.getMessage());

								}
							} else if (entity.getPackType().equalsIgnoreCase("weekly")) {
								LocalDateTime lastBilledDate = LocalDateTime.now();
								LocalDateTime nextBillingDate = LocalDateTime.now().plusDays(7);
								try {
									TblSubscription subscription = subscriptionRepository
											.getAni(String.valueOf(entity.getAni()));
									if (subscription != null && entity.getType().equalsIgnoreCase("REN")) {
										entity.setLastBilledDate(lastBilledDate);
										entity.setNextBilledDate(nextBillingDate);
										billingRepo.save(entity);
										updateDataInSub(subscription, entity, lastBilledDate, nextBillingDate);
										saveRecordInTableLogs(entity, lastBilledDate, nextBillingDate,
												request.toString(), body + " " + status);
										saveInTableBillingSuccess(entity, request.toString(), body + " " + status);

									} else if (subscription != null && entity.getType().equalsIgnoreCase("sub")) {

										entity.setLastBilledDate(lastBilledDate);
										entity.setNextBilledDate(nextBillingDate);
										entity.setRequest(request.toString());
										entity.setResponse(body);
										billingRepo.save(entity);
										updateDataInSub(subscription, entity, lastBilledDate, nextBillingDate);
										service.sendSms(entity);
										saveRecordInTableLogs(entity, lastBilledDate, nextBillingDate,
												request.toString(), body + " " + status);
										saveInTableBillingSuccess(entity, request.toString(), body + " " + status);

									} else if (subscription == null) {

//									service.sendSms(entity);
										saveInSub(entity, lastBilledDate, nextBillingDate);
										saveRecordInTableLogs(entity, lastBilledDate, nextBillingDate,
												request.toString(), body + " " + status);
										saveInTableBillingSuccess(entity, request.toString(), body + " " + status);
									}
								} catch (NonUniqueResultException e) {
									List<TblSubscription> sub = subscriptionRepository
											.findByAni(String.valueOf(entity.getAni()));
									for (int i = 0; i < sub.size() - 1; i++) {
										subscriptionRepository.delete(sub.get(i));

									}
								} catch (NullPointerException e) {
									// TODO: handle exception
//								service.sendSms(entity);
									
									System.out.println("handle Null Pointer Exception");
									e.printStackTrace();
									System.out.println("Exception In WEEKLY" + e.getMessage());

								}
							} else if (entity.getPackType().equalsIgnoreCase("monthly")) {
								LocalDateTime lastBilledDate = LocalDateTime.now();
								LocalDateTime nextBillingDate = LocalDateTime.now().plusMonths(1);
								try {
									TblSubscription subscription = subscriptionRepository
											.getAni(String.valueOf(entity.getAni()));
									if (subscription != null && entity.getType().equalsIgnoreCase("REN")) {

										entity.setLastBilledDate(lastBilledDate);
										entity.setNextBilledDate(nextBillingDate);

										billingRepo.save(entity);
										updateDataInSub(subscription, entity, lastBilledDate, nextBillingDate);
										saveRecordInTableLogs(entity, lastBilledDate, nextBillingDate,
												request.toString(), body + " " + status);
										saveInTableBillingSuccess(entity, request.toString(), body + " " + status);

									}

									else if (subscription != null && entity.getType().equalsIgnoreCase("Sub")) {
										entity.setLastBilledDate(lastBilledDate);
										entity.setNextBilledDate(nextBillingDate);
										entity.setRequest(request.toString());
										entity.setResponse(body);
										billingRepo.save(entity);

										updateDataInSub(subscription, entity, lastBilledDate, nextBillingDate);
//								service.sendSms(entity);
										saveRecordInTableLogs(entity, lastBilledDate, nextBillingDate,
												request.toString(), body + " " + status);
										saveInTableBillingSuccess(entity, request.toString(), body + " " + status);
									} else if (subscription == null) {
//									service.sendSms(entity);
										saveInSub(entity, lastBilledDate, nextBillingDate);
										saveRecordInTableLogs(entity, lastBilledDate, nextBillingDate,
												request.toString(), body + " " + status);
										saveInTableBillingSuccess(entity, request.toString(), body + " " + status);

									}

								} catch (IncorrectResultSizeDataAccessException e) {
									List<TblSubscription> sub = subscriptionRepository
											.findByAni(String.valueOf(entity.getAni()));
									for (int i = 0; i < sub.size() - 1; i++) {
										subscriptionRepository.delete(sub.get(i));

									}
								} catch (NullPointerException e) {
									// TODO: handle exception
//								service.sendSms(entity);
									e.printStackTrace();
									System.out.println("handle Null Pointer Exception");
									System.out.println("Exception In Monthly" + e.getMessage());
								}

							}

							else {

								entity.setRequest(request.toString());
								entity.setResponse(body + " " + status);
								System.out.println("Response for Failed" + body);
								entity.setStatus("Failed");
								billingRepo.save(entity);
								saveRecordInTableLogs(entity, null, null, request.toString(), body + " " + status);

							}

						}
					} catch (Exception e) {
						// TODO: handle exception
//					e.printStackTrace();
						entity.setRequest(xmlRequest);
						entity.setResponse(e.getMessage());
						entity.setStatus("Failed");
						System.out.println("Response for Failed" + e.getMessage());
						billingRepo.save(entity);
						saveRecordInTableLogs(entity, null, null, xmlRequest, e.getMessage());
					}
					}else {
						billingRepo.delete(entity);
					}
				} else {
					TblUnsubscription tblUnsubscription = new TblUnsubscription();
					tblUnsubscription.setAni(String.valueOf(entity.getAni()));
					tblUnsubscription.setPack(entity.getPackType());
					tblUnsubscription.setDateTime(LocalDateTime.now());
					tblUnsubscription.setStatus("DND");
					tblUnsubscription.setType(entity.getType());
					tblUnsubscription.setLanguage(entity.getLanguage());
					tblUnsubscriptionrepo.save(tblUnsubscription);

					try {
						TblSubscription subscription = subscriptionRepository.getAni(entity.getAni());

						List<TblFavourite> favouriteKey = favouriteRepo.getFavRecord(subscription.getId());
						List<TblPlayer> foreignKey = playerRepo.getRecord(subscription.getId());
						if (foreignKey.size() != 0) {
							for (TblPlayer geyValue : foreignKey) {
								playerRepo.delete(geyValue);
								System.out.println("Record SuccessFully Deleted");
							}
						}
						if (favouriteKey.size() != 0) {
							for (TblFavourite favourite : favouriteKey) {
								favouriteRepo.delete(favourite);
								System.out.println("SuccessFully Value delete from Tbl_favourite");
							}
						}
						subscriptionRepository.delete(subscription);
						System.out.println("Data Delete From tbl_subScription Due To Table DND");

						billingRepo.delete(entity);
						System.out.println("Data Deleted From tblBilling Due to DND Table");

						List<TblBillingLogs> billingLogs = logsRepo.findByAni(entity.getAni());
						for (TblBillingLogs logs : billingLogs) {
							logs.setFailedStatus("Unsub");
							logsRepo.save(logs);
						}

					} catch (Exception e) {
						// TODO: handle exception

						System.out.println("Exception Inside HitBilling Service:::::" + e.getMessage());
						billingRepo.delete(entity);
						System.out.println("Data Deleted From tblBilling Due to DND Table");

					}

				}
			}
		}

	}

	public void saveRecordInTableLogs(BillingEntity entity, LocalDateTime lastBilledDate, LocalDateTime nextBillingDate,
			String request, String body)

	{

		try {
//			System.out.println("The value of entity in billing logs" + entity);
			TblBillingLogs billingLogs = new TblBillingLogs();
			billingLogs.setAmount(entity.getAmount());
			billingLogs.setAni(entity.getAni());
			billingLogs.setBillingDate(LocalDate.now());
			billingLogs.setProcessDate(LocalDate.now());
			billingLogs.setProcessDateTime(LocalDateTime.now());
			billingLogs.setBillingDateTime(LocalDateTime.now());
			billingLogs.setDate(LocalDate.now());
			billingLogs.setDateTime(LocalDateTime.now());
			billingLogs.setLastBilledDate(lastBilledDate);
			billingLogs.setNextBilledDate(nextBillingDate);
			billingLogs.setRequest(request.toString());
			billingLogs.setResponse(body);
			billingLogs.setPackType(entity.getPackType());
			billingLogs.setType(entity.getType());
			billingLogs.setStatus(entity.getStatus());
//			billingLogs.setBillingDate(entity.getBillingDate());
//			billingLogs.setProcessDate(entity.getProcessDate());
			billingLogs.setService(entity.getService());
			billingLogs.setLanguage(entity.getLanguage());
			billingLogs.setMAct(entity.getMAct());

			Thread.sleep(5000);
			if (entity.getBillingType().equalsIgnoreCase("one")) {
				if(entity.getStatus().equalsIgnoreCase("Failed"))
					{
					billingLogs.setFailedStatus("one");
					logsRepo.save(billingLogs);
					
					billingRepo.delete(entity);
					}
				else {
					billingLogs.setFailedStatus("one");
					logsRepo.save(billingLogs);
				}

			} else if (entity.getBillingType() == null || entity.getBillingType().equalsIgnoreCase("auto")) {
				if (entity.getStatus().equalsIgnoreCase("Failed")) {
					if (entity.getType().equalsIgnoreCase("sub")) {
						billingLogs.setFailedStatus("0");
						billingLogs.setTxnId(entity.getTxnId());
						logsRepo.save(billingLogs);
					} else {
						billingLogs.setFailedStatus(entity.getBillingStatus());
						billingLogs.setTxnId(entity.getTxnId());
						logsRepo.save(billingLogs);
					}
					billingRepo.delete(entity);

//					billingRepo.delete(entity);
				} else {
					billingLogs.setFailedStatus("Success");
					billingLogs.setTxnId(entity.getTxnId());
					logsRepo.save(billingLogs);
					

				}
			}

			System.out.println("Data Save IN table Billing Logs");

			System.out.println("Successfully Deleted from tbl billing");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void saveInTableBillingSuccess(BillingEntity success, String request, String response) {
		try {

			TblBillingSuccess billingSuccess = new TblBillingSuccess();

			billingSuccess.setAmount(success.getAmount());
			billingSuccess.setAni(success.getAni());
			billingSuccess.setBillingDate(LocalDate.now());
			billingSuccess.setBillingDateTime(LocalDateTime.now());
			billingSuccess.setPackType(success.getPackType());
			if (success.getMAct() != null && success.getMAct().equalsIgnoreCase("Migration")) {
				billingSuccess.setType("REN");
			} else {
				billingSuccess.setType(success.getType());
			}
			billingSuccess.setMAct(success.getMAct());
			billingSuccess.setProcessDate(success.getProcessDate());
			billingSuccess.setProcessDateTime(success.getProcessDateTime());
			billingSuccess.setService(success.getService());
			billingSuccess.setStatus(success.getStatus());

//			billingSuccess.setRequest(success.getRequest());
//			billingSuccess.setResponse(success.getResponse());
			billingSuccess.setBillingDate(success.getBillingDate());
			billingSuccess.setProcessDate(success.getProcessDate());
			billingSuccess.setService(success.getService());
			billingSuccess.setLanguage(success.getLanguage());
			billingSuccess.setTxnId(success.getTxnId());
			repo.save(billingSuccess);
			System.out.println("Data Save In tbl_billing_success");
			Thread.sleep(5000);
			billingRepo.delete(success);
			System.out.println("Successful Biling Entity is Delete from table billing ");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void saveInSub(BillingEntity entity, LocalDateTime lastBilledDate, LocalDateTime nextBillingDate) {
		try {
			TblSubscription newRecord = new TblSubscription();

			LocalDate date = LocalDate.now();
			LocalDate newDate = null;

			if (entity.getPackType().equalsIgnoreCase("Daily")) {
				newDate = LocalDate.now().plusDays(1);
			} else if (entity.getPackType().equalsIgnoreCase("Weekly")) {
				newDate = LocalDate.now().plusWeeks(1);
			} else if (entity.getPackType().equalsIgnoreCase("monthly")) {
				newDate = LocalDate.now().plusMonths(1);
			}

			System.out.println("INSERT NEW DATA IN SUB");
			newRecord.setAmount(entity.getAmount());
			newRecord.setAni(entity.getAni());
			newRecord.setSubDateTime(LocalDateTime.now());
			newRecord.setLastBilledDateTime(lastBilledDate);
			newRecord.setNextBilledDateTime(nextBillingDate);
			newRecord.setStatus("Active");
			newRecord.setService(entity.getService());
			newRecord.setPack(entity.getPackType());
			newRecord.setLanguage(entity.getLanguage());
			newRecord.setMAct(entity.getMAct());
			newRecord.setNextBilledDate(newDate);
			newRecord.setTxnId(entity.getTxnId());
			if (entity.getBillingType() == null) {
				newRecord.setBillingType("auto");
			} else {
				newRecord.setBillingType(entity.getBillingType());
			}

			subscriptionRepository.save(newRecord);

			System.out.println("Ani is not found New Record Save...");

			service.sendSms(entity);

			TblUser user = tblUserRepo.findByAni(newRecord.getAni());

			if (user == null) {
				TblUser tblUser = new TblUser();
				tblUser.setAni(String.valueOf(entity.getAni()));
				tblUser.setDateTime(LocalDateTime.now());
				tblUserRepo.save(tblUser);
				System.out.println("Record  Saved In TblRecord");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void updateDataInSub(TblSubscription sub, BillingEntity entity, LocalDateTime lastBilledDate,
			LocalDateTime nextBillingDate) 
	{
		try {

			sub.setLastBilledDate(LocalDate.now());
			LocalDateTime date = LocalDateTime.now();
			System.out.println("The value of pack inside updateDateInSub" + entity.getType());

			if (entity.getPackType().equalsIgnoreCase("Daily")) {
				date = LocalDateTime.now().plusDays(1);
			}
			if (entity.getPackType().equalsIgnoreCase("Weekly")) {
				date = LocalDateTime.now().plusDays(7);
			}
			if (entity.getPackType().equalsIgnoreCase("Monthly")) {
				date = LocalDateTime.now().plusMonths(1);
			}

			sub.setPack(entity.getPackType());
			sub.setStatus("Active");
//			sub.setLastBilledDate(LocalDate.now());
//			sub.setNextBilledDate(LocalDate.now());
			sub.setLastBilledDateTime(lastBilledDate);
			sub.setNextBilledDateTime(date);
			sub.setNextBilledDate(date.toLocalDate());
			sub.setTxnId(sub.getTxnId());
			subscriptionRepository.save(sub);
			// Adding the Data in tbl_user if user is new
			List<TblUser> getRecord = tblUserRepo.getTblUser(sub.getAni());
			if (getRecord.size() != 0) {
				for (TblUser user : getRecord) {

					user.setAni(sub.getAni());
					user.setDateTime(LocalDateTime.now());
					tblUserRepo.save(user);
					System.out.println("Data Updated In User Table");
				}
			}
			System.out.println("Record is updated in subscription Table");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
