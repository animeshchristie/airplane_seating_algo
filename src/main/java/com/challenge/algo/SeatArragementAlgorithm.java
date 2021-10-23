package com.challenge.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.challenge.seats.Seats;
import com.challenge.seats.SeatsFactory;

public class SeatArragementAlgorithm {
	
	private int[][] input;
	
	private int totalCols;
	private int maxRows;
	
	private List<Integer[][]> output;
	
	public SeatArragementAlgorithm(int[][] input) {
		super();
		this.input = input;
		
		init();
	}
	
	private void init() {
		totalCols = getTotalCols();
		
		maxRows = getMaxRow();
		
		SeatsFactory.setupSeats("asile", input, totalCols);
		SeatsFactory.setupSeats("window", input, totalCols);
		SeatsFactory.setupSeats("middle", input, totalCols);
	}


	private int getMaxRow() {
		int  max = 0;
		for (int[] block : input) {
			max = (block[1] > max) ? block[1] : max;
		}
		return max;
	}

	private int getTotalCols() {
		int  total = 0;
		for (int[] block : input) {
			total += block[0];
		}
		return total;
	}


	public void arrangePassengers(int totalPassengers) {
		output = new ArrayList<>();
		for (int i = 0; i < input.length; i++) {
			int row = input[i][1];
			int col = input[i][0];
			output.add(new Integer[row][col]);
		}
		
		Map<Integer, Integer> rowIndexes = new HashMap<>();
		Map<Integer, Integer> colIndexes = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			rowIndexes.put(i, 0);
			colIndexes.put(i, 0);
		}
		
		int index = 0;
		for (int i = 0; i < maxRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				
				Integer[][] outputBlock = output.get(index);
				
				int row = rowIndexes.get(index);
				int col = colIndexes.get(index);
				
				if (row >= outputBlock.length) {
					if (col >= outputBlock[0].length) {
						index++;
						j--;
						continue;
					}
					index++;
					j += outputBlock[0].length - 1;
					continue;
				} else if (col >= outputBlock[0].length) {
					index++;
					j--;
					continue;
				}
				
				Seats seat = SeatsFactory.getSeat(j);
				
				if (seat.isSeatCols(j)) {
					Integer nextColNumber = seat.getNextColNumber(totalPassengers);
					outputBlock[row][col] = nextColNumber;
				}
				colIndexes.put(index, col+1);
			}
			
			index = 0;
			for (int k = 0; k < input.length; k++) {
				rowIndexes.put(k, i + 1);
				colIndexes.put(k, 0);
			}
		}
	}
	
	public void printSeatingArrangement() {
		for (Integer[][] integers : output) {
			for (int k = 0; k < integers.length; k++) {
				for (int l = 0; l < integers[k].length; l++) {
					if (null == integers[k][l]) {
						System.out.printf("%4s", " ");
					} else {
						System.out.printf("%4d", integers[k][l]);
					}
				}
				System.out.println();
			}
			System.out.println(" ======================== ");
		}
	}
}
