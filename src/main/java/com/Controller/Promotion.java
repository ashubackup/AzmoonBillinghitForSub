//package com.Controller;
//
//import java.util.List;
//import java.util.Map;
//
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.Entity.TblDnd;
//import com.Entity.TblPromotion;
//import com.Repository.TblDndRepo;
//import com.Repository.TblPromotionrRepo;
//import com.Repository.Tbl_PlayerRepo;
//import com.Service.PromotionService;
//
//@RestController
//public class Promotion 
//{
//	
//	@Autowired
//	TblPromotionrRepo promotionRepo;
//	
//	@Autowired
//	TblDndRepo dndRepo;
//	
//	@Autowired
//	PromotionService promotionService;
//	
//	@PostMapping("/request")
//	public void getRequest(@RequestBody String value)
//	{
//		try {
//			JSONObject jsonObject = new JSONObject(value);
//			Integer number = (Integer) jsonObject.getInt("number");
//			Integer limit =(Integer) jsonObject.getInt("limit");
//			System.out.println("Value of Limit"+limit);
//			List<TblPromotion> promotion = promotionRepo.getData("0", limit);
//			System.out.println("Value of promotion"+promotion);
//			for(TblPromotion tblPromotion : promotion)
//			{
//				List<TblDnd> dnds = dndRepo.findByAni(tblPromotion.getAni());
//				System.out.println("Value of Dnd"+dnds);
//				System.out.println("size of dnd is"+dnds.size());
//				if(dnds.size()==0) 
//				{
//					promotionService.sendPromotionMessage(tblPromotion,number);
//				}
//				else {
//					tblPromotion.setStatus("DND");
//					promotionRepo.save(tblPromotion);
//					System.out.println("Present In DND");
//				}
//			}
//			
//		}catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("Exception In promotion Controller:::"+e.getMessage());
//		}
//	}
//}
