package com.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.BillingEntity;
import com.Entity.TblSubscription;
import com.Repository.TblBillingRepo;

@Service
public class SubscriptionService {

	@Autowired
	TblBillingRepo repo;
	
	@Autowired
	BillingService service;
	
	
	
	public void saveRenTypeInBilling(List<TblSubscription> subscription)
	{
		try 
		{
			
			for(TblSubscription getRecord : subscription)
			{
				
				
					
//				System.out.println("Control inside");
				long ani = Long.parseLong(getRecord.getAni());
				List<BillingEntity> checkAni = repo.findByAni(ani);
				
				if(checkAni.size()==0) {
				BillingEntity entity = new BillingEntity();
				entity.setAni(Long.parseLong(getRecord.getAni()));
				entity.setBillingDate(LocalDate.now());
				entity.setAmount(getRecord.getAmount());
				entity.setPackType(getRecord.getPack());
				entity.setType("REN");
				entity.setStatus(String.valueOf(getRecord.getPickStatus()));
				entity.setLanguage(getRecord.getLanguage());
				entity.setMAct(getRecord.getMAct());
				entity.setService(getRecord.getService());
				System.out.println("The value of entity is"+entity);
				repo.save(entity);
				System.out.println("REN record is save in tbl_billing");
				
				}
				
//				List<BillingEntity> billing = repo.findByStatusAndType(entity.getStatus(),entity.getType());
//				service.hitBilling(billing);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
