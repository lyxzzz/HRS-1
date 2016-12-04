package PromotionBLServiceImpl;

import java.rmi.RemoteException;

import PO.PromotionPO;
import VO.HotelVO;
import VO.MemberLevelSystemVO;
import dataService.DataFactoryService;
import dataService.PromotionDataService;
import rmi.RemoteHelper;

public class UpdateMemberLevelSystem {
	private DataFactoryService df;
	private PromotionDataService pds;
	private MemberLevelSystemVO vo;
	
	private static UpdateMemberLevelSystem updateMemberLevelSystem;
	
	private UpdateMemberLevelSystem() {
		df=RemoteHelper.getInstance().getDataFactoryService();
		PromotionPO po = pds.getMemberLevelSystem();
		vo = new MemberLevelSystemVO(po);
		try {
			pds = (PromotionDataService)df.getDataService("Promotion");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static UpdateMemberLevelSystem getUpdateMemberLevelSystemInstance() {
		if(updateMemberLevelSystem == null) {
			updateMemberLevelSystem = new UpdateMemberLevelSystem();
		}
		return updateMemberLevelSystem;
	}
	
	
	public void updateMemberLevelSystem(long credit[],double discount[]){
		vo.creditOfLevel=credit;
		vo.discountOfLevel=discount;
		PromotionPO po = new PromotionPO(vo.creditOfLevel,vo.discountOfLevel);
		
		try {
			pds.update(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}