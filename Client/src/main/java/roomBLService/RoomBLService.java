package roomBLService;

/**
 * 负责实现房间功能的服务接口
 * @author 刘宗侃
 */

public interface RoomBLService {
	
	/**
     * 酒店工作人员更新单个房间的状态
     * 
     * @param hotelID String型，酒店帐号
     * @param roomNumber String型，房间号
     * @param roomType String型，房型
     * @param roomState String型，房间状态
     */
	public void updateRoomInfo(String hotelID, String roomNumber, String roomType, String roomState);
	/**
     * 判断能否酒店是否有足够房间
     * 
     * @param hotelID String型，酒店ID
     * @param roomType String型，房型
     * @param roomNumber int型，预定的房间数量
     */
	public boolean whetherSuccess(String hotelID, String roomtype,int roomNumber);
	/**
     * 客户下单更新酒店被预定的房间的状态
     * 
     * @param hotelID String型，酒店ID
     * @param roomType String型，房型
     * @param roomNumber String型，预定的房间数量
     */
	public void updateRoomState(String hotelID, String roomType,int roomNumber);
	/**
     * 得到酒店的所有空闲房间的最低价格，若无空闲房间，返回 -1 
     * 
     * @param hotelID String型，酒店ID
     * @return 此酒店的所有空闲房间的最低价格
     */
	public int getRoomLowestPrice(String hotelID);
	/**
     * 得到酒店的某房间类型的价格
     * 
     * @param hotelid String型，酒店的id
     * @param roomType String型，一种房间类型
     * @return 返回酒店的某房间类型的价格
     */
	public int getRoomPrice(String hotelid, String roomType);
	
	
	
	//------------------------------------------------------------
//    /**
//     * 修改房间信息
//     * 
//     * @param in MessageInput型，界面输入的修改信息
//     * @return 返回ResultMessage枚举值中的一项
//     * @see bussinesslogic.Room
//     */
//	public ResultMessage messageupdate(MessageInput in);
//	
//	
//	
//    /**
//     * 修改酒店含有的房间信息
//     * 
//     * @param in MessageInput型，界面输入的修改信息
//     * @return 返回ResultMessage枚举值中的一项
//     * @see bussinesslogic.Room
//     */
//	public ResultMessage messageadd(MessageInput in);
//	
//	
//	/**
//     * 获得订单上的客户的个人信息和入住退房时间
//     * 
//     * @param vo OrderVO型，一个OrderVO，订单值对象
//     * @return RoomVO返回一个房间值对象
//     * @see bussinesslogic.Room
//     */
//	public RoomVO messageadd(OrderVO  vo);
//	
//	
//	/**
//     * 返回可入住房间
//     * 
//     * @return ArrayList<RoomVO>,一个房间值对象列表
//     * @see bussinesslogic.Room
//     */
//	public ArrayList<RoomVO> getRoom();
//	
//	
}
