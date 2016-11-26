package orderOverview;
import java.util.List;

import VO.OrderVO;
import orderBLImpl.OrderList;
/**
 * 浏览酒店的所有订单，并执行延迟入住操作
 * @author Administrator
 *
 */
public class OrderOverviewController{
	OrderList list;
	public OrderOverviewController() {
		list=new OrderList();
	}
	/**
     * 获得一个酒店的所有订单
     * 
     * @param String HotelID，酒店的id
     * @return List<OrderVO> ，订单的一个列表
	 * @ 
     * @see bussinesslogic.Order
     */
	public List<OrderVO> getAllOrders(String hotelId) {
		return list.getAllOrders(hotelId);
	}
	/**
     * 获得一个酒店的所有未执行订单
     * 
     * @param String HotelID，酒店的id
     * @return List<OrderVO> ，订单的一个列表
	 * @ 
     * @see bussinesslogic.Order
     */
	public List<OrderVO> getUnfinishedOrders(String hotelId)  {
		return list.getUnfinishedOrders(hotelId);
	}
	
	
	
	/**
     * 获得一个酒店的所有已执行订单
     * 
     * @param String HotelID，酒店的id
     * @return List<OrderVO> ，订单的一个列表
	 * @ 
     * @see bussinesslogic.Order
     */
	public List<OrderVO> getFinishedOrders(String hotelId)  {
		return list.getFinishedOrders(hotelId);
	}
	
	
	/**
     * 获得一个酒店的所有异常订单
     * 
     * @param String HotelID，酒店的id
     * @return List<OrderVO> ，订单的一个列表
	 * @ 
     * @see bussinesslogic.Order
     */
	public List<OrderVO> getAbnormalOrders(String hotelId)  {
		return list.getAbnormalOrders(hotelId);
	}
}