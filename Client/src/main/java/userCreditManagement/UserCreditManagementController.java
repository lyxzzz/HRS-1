package userCreditManagement;

import java.rmi.RemoteException;
import java.text.ParseException;

import VO.CreditRecordVO;
import promotionMemberGrade.PromotionMemberGradeController;
import userBLServiceImpl.Credit;
import userBLServiceImpl.PromotionInfo;


public class UserCreditManagementController {
		/**
		 * 更新会员等级
		 * @param id String型，界面传入的客户账户
		 * @param credit long型，界面层传入的信用值
		 * @throws RemoteException 
		 * @see bussinesslogic.Customer
		 */
		public void updateLevel(String id, long credit) throws RemoteException {
			Credit.getInstance().updateLevel(id, credit);
		}
		/**
		 * 根据信用记录更新信用值
		 * @param vo CreditRecordVO型，界面输入的信用记录
		 * @see bussinesslogic.Customer
		 */
		public void updateCreditRecord(CreditRecordVO vo) throws RemoteException, ParseException {
			Credit.getInstance().updateCredit(vo);
		}
		/**
		 * 根据会员等级提供折扣
		 * @param level Integer型，界面层传入的会员等级
		 * @return 返回此等级的折扣
		 */
		public Double getDiscount(Integer level) {
			PromotionInfo mg=new PromotionMemberGradeController();
			return mg.getDiscountOfLevel(level);
		}
		/**
		 * 更新所有客户的会员等级
		 * @return 
		 */
		public boolean updateAllLevel() {
			try {
				return Credit.getInstance().updateAllLevel();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return false;
		}
}
