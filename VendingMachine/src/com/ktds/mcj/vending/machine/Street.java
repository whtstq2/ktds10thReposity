package com.ktds.mcj.vending.machine;

public class Street {

	public void start() {
		Buyer buyer = new Buyer(10000);
		VendingMachine vendingMachine = new VendingMachine(0, 10, 10, 10);
		
		buyer.buy(vendingMachine, 10000);
		/*
		System.out.println(buyer);
		System.out.println(vendingMachine);*/
	}
	
	public static void main(String[] args) {
		new Street().start();
	}
	
}
