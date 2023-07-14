package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.Service.BillingService;

//@Component
public class DeleteExtraNumberFromTableBilling 
{
	
	@Autowired
	BillingService billingService;
	
//	@Scheduled(fixedDelay = 10000)
//	
	public void deleteData()
	{
//		System.out.println("Please Wait Query is Executed::::");
//		billingService.deleteBillingData();
//		System.out.println("Successfully Deleted::::");
	}

}
