package TestHotel;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import VO.HotelVO;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;

public class GetHistoryHotelTester {

	@Test
	public void test() {

		HotelBLService hotel = new HotelBLServiceController();
		
		List<HotelVO> list = hotel.getHistoryHotel("01");
		
		assertEquals(0, list.size());
	
	}

}
