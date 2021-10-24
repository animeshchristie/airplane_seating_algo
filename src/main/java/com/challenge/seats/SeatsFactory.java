package com.challenge.seats;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SeatsFactory {
	static Map<String, Seats> seats = new HashMap<>();

	public static Seats setupSeats(String seatType, int[][] input, int totalCols) {
		Seats s = null;
		if ("asile".equals(seatType)) {
			s = new AsileSeats(input, totalCols);
			s.setStartNumber(1);
		} else if ("window".equals(seatType)) {
			s = new WindowSeats(input, totalCols);
			Seats aisleSeat = seats.get("asile");
			if (null != aisleSeat) {
				s.setStartNumber(aisleSeat.getTotalSeats() + 1);
			} else {
				s.setStartNumber(1);
			}
		} else if ("middle".equals(seatType)) {
			Seats aisleSeat = seats.get("asile");
			Seats windowSeat = seats.get("window");
			if (null != aisleSeat) {
				s = new MiddleSeats(input, totalCols, windowSeat.getSeatCols(), aisleSeat.getSeatCols());
				s.setStartNumber(aisleSeat.getTotalSeats() + windowSeat.getTotalSeats() + 1);
			} else {
				s = new MiddleSeats(input, totalCols, windowSeat.getSeatCols(), Set.of());
				s.setStartNumber(windowSeat.getTotalSeats() + 1);
			}
		} 
		seats.put(seatType, s);
		return s;
		
	}
	
	public static Seats getSeat(int col) {
		for (Seats s : seats.values()) {
			if (s.isSeatCols(col)) {
				return s;
			}
		}
		return null;
	}
}
