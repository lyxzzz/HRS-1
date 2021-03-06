package userCreditRecord;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.HashMap;
import VO.CreditRecordVO;
import userBLServiceImpl.Credit;
import userBLServiceImpl.CreditRecord;

public class UserCreditRecordController{
	/**
	* 显示信用值
	* @param userID String型，界面输入用户ID
	* @return 返回此用户的信用值
	 * @throws RemoteException 
	* @see bussinesslogic.Customer
	*/
	public long showCredit(String userID) throws RemoteException {
		return Credit.getInstance().showCredit(userID);
	}
	/**
	 * 信用记录显示
	 * @param id String型，界面传入的客户账号
	 * @return 返回信用记录列表
	 * @throws RemoteException 
	 * @see Customer.User
	 */
	public HashMap<String,CreditRecordVO> showCreditRecord(String userID) throws RemoteException, ParseException {
		return CreditRecord.getInstance().showCreditRecord(userID);
	}	
}
