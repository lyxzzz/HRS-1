package userInformationMaintenance;

import java.rmi.RemoteException;

import VO.UserVO;
import common.ResultMessage;
import userBLServiceImpl.Customer;
import userBLServiceImpl.Log;


public class UserInformationMaintenanceController extends UserBLService_realize{
	/**
	 * 根据客户ID查找客户信息并返回
	 * @param  in MessageInput型，界面输入的客户ID
	 * @return 返回ResultMessage的所有枚举值
	 * @see bussinesslogic.Customer
	 */
	public UserVO findByID(String userID){
			return Customer.getUserInstance().findByID(userID);
	}
	/**
	 * 更新客户信息
	 * @param in MessageInput型，界面输入的更新信息
	 * @return 返回ResultMessage的一个枚举值
	 * @throws RemoteException 
	 * @see bussinesslogic.Customer
	 */
	public void update(UserVO vo,String password) throws RemoteException{
			Customer.getUserInstance().updateUserInfo(vo, password);
			Log.getLogInstance().revisepassword(vo.id, password);
	}
}