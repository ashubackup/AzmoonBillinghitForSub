//package com.Controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.Entity.UnSubRequest;
//import com.Repository.Tbl_UnsubRequestRepo;
//import com.Service.Tbl_UnsubcriptionService;
//
////@RestController
//@Component
//public class UnsubRequestController 
//
//{
//	@Autowired
//	Tbl_UnsubcriptionService service;
//	
//	@Autowired
//	Tbl_UnsubRequestRepo  repo;
//	
//	@Scheduled(fixedDelay  = 1000)
//	public void getRequest()
//	{
//		try {
//			
//		String status="0";
//		
//		System.out.println("The control inside unsubScheduler");
//		List<UnSubRequest> request = repo.findByStatus(status);
//		
//		if(request.size()!=0)
//		{
//			System.out.println("The value of request"+request);
//			service.unsubRequest(request);
//		}
//		
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
//}
