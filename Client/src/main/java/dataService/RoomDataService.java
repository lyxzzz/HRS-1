package dataService;
import PO.*;
import dataService.DataService;

import java.rmi.RemoteException;
import java.util.List;

/**负责实现房间数据储存所需要的服务接口
 * @author 刘伟
 * @version 1.0
 * see presentation.Room
 */
public interface RoomDataService  extends DataService{
	/**
	 * 在数据库中增加一个po记录
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see data.Room
	 */
		public void insert(RoomPO po) throws RemoteException;
	/**
	 *在数据库中更新一个po
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see data.Room
	 */
		public void update(RoomPO po) throws RemoteException;
		/**
		 * 得到一个酒店的所有房间列表
		 * @param hotelid String型，逻辑层传来的酒店ID
		 * @return 一个酒店的所有房间列表
		 * @throws RemoteException
		 * @see PO.RoomPO
		 */
		public List<RoomPO> getAllRooms(String hotelid) throws RemoteException;
	}
