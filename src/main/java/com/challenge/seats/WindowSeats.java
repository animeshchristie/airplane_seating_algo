package com.challenge.seats;

import java.util.Set;

public class WindowSeats extends Seats {

	public WindowSeats(int[][] input, int totalCols) {
		super(input, totalCols);
	}

	@Override
	public void setSeatCols() {
		seatCols = Set.of(0, totalCols - 1);
	}

	@Override
	public void setTotalSeats() {
		int[] fistBlock = input[0];
		int[] lastBlock = input[input.length - 1];
		
		totalSeats =  fistBlock[1] + lastBlock[1];
	}
}
