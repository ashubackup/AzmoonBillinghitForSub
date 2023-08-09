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
					billingService.hitBilling(billingEntities,"0");
				}
				
				
				
			}
		}
		
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();	
		}

	}
}