package uiService;

import java.util.Calendar;
import java.util.List;

import HotelWorkerView.ProcessOrderView;
import VO.OrderVO;
import common.Operate;
import common.UserType;

public interface ProcessOrderUiService {
	public String getHotelId();
	
	public void setView(ProcessOrderView view);
	
	public List<OrderVO> getAllOrders(String hotelId);
	
	public List<OrderVO> getUnfinishedOrders(String hotelId);
	
	public List<OrderVO> getFinishedOrders(String hotelId);
	
	public List<OrderVO> getAbnormalOrders(String hotelId);
	
	public boolean processUnfinishedOrder(String orderId);
	
	public boolean processAbnormalOrder(String orderId,String delayTime);
	
	public void updateListModel(String comboboxValue);
	
	public void processOrderButtonClicked();
	
	public void delayOrderButtonClicked();

	public void back();

	public void cancelAbnormalOrder();

	public void recover(Calendar calendar, String orderNo, Operate appeal, String strategy, int value, String userID);

	public List<OrderVO> getCanceledOrders(String hotelId);

	public String getUserID(String orderNo);

	public void dealwithAbnormalOrder(String userID);

	public UserType getUserType();


}
