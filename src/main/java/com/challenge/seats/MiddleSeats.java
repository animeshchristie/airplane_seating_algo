package com.challenge.seats;

import java.util.HashSet;
import java.util.Set;

public class MiddleSeats extends Seats {

	public MiddleSeats(int[][] input, int totalCols, Set<Integer> windowCols, Set<Integer> aisleCols) {
		super(input, totalCols);
		
		for (int i = 0; i < totalCols; i++) {
			if (!aisleCols.contains(i) && !windowCols.contains(i)) {
				seatCols.add(i);
			}
		}
	}

	@Override
	public void setSeatCols() {
		seatCols = new HashSet<>();
	}

	@Override
	public void setTotalSeats() {
		int total = 0;
		
		int[] fistBlock = input[0];
		if (fistBlock[0] > 2) {
			total += fistBlock[1] * (fistBlock[0] - 2);
		}
		
		int[] lastBlock = input[input.length - 1];
		if (lastBlock[0] > 2) {
			total += lastBlock[1] * (fistBlock[0] - 2);
		}
		
		for (int i = 1; i < input.length - 1; i++) {
			int colsInBlock = input[i][0];
			if (colsInBlock > 1) {
				total += input[i][1] * (input[i][0] - 2);
			}
		}
		
		totalSeats = total;
	}

}
