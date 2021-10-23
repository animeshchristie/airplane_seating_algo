package com.challenge.seats;

import java.util.HashSet;

public class AsileSeats extends Seats {

	public AsileSeats(int[][] input, int totalCols) {
		super(input, totalCols);
	}

	@Override
	public void setSeatCols() {
		seatCols = new HashSet<>();

		int lastIndex = 0;
		
		int[] fistBlock = input[0];
		if (fistBlock[0] > 1) {
			lastIndex = fistBlock[0] - 1;
			seatCols.add(lastIndex);
		}
		
		int[] lastBlock = input[input.length - 1];
		if (lastBlock[0] > 1) {
			seatCols.add(totalCols - lastBlock[0]);
		}
		
		for (int i = 1; i < input.length - 1; i++) {
			int colsInBlock = input[i][0];
			if (colsInBlock > 1) {
				lastIndex += 1;
				seatCols.add(lastIndex);
				
				lastIndex += input[i][0] - 1;
				seatCols.add(lastIndex);
			}
		}
	}

	@Override
	public void setTotalSeats() {
		int total = 0;
		
		int[] fistBlock = input[0];
		if (fistBlock[0] > 1) {
			total += fistBlock[1];
		}
		
		int[] lastBlock = input[input.length - 1];
		if (lastBlock[0] > 1) {
			total += lastBlock[1];
		}
		
		for (int i = 1; i < input.length - 1; i++) {
			int colsInBlock = input[i][0];
			if (colsInBlock > 1) {
				total += (input[i][1] * 2);
			}
		}
		
		totalSeats = total;
	}
}
