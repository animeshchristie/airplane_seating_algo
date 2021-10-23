package com.challenge;

import com.challenge.algo.SeatArragementAlgorithm;

public class MainApp {
	
	//1 cols - windows seats
	//2 cols - window and aisle seats
	//3 cols - window, aisle and middle seats
	
	public static void main(String[] args) {
		int[][] input = {{3,2}, {4,3}, {2,3}, {3,4}};
		
		SeatArragementAlgorithm a = new SeatArragementAlgorithm(input);
		a.arrangePassengers(30);
		a.printSeatingArrangement();
	}		
}
