package com.ktds.mcj.vending.machine;

import java.util.Scanner;

public class Buyer {

	private int myMoney;
	private int cokeStock;
	private int cyderStock;
	private int fantaStock;
	
	//음료수의 갯수는 0이라고 생각하여 받는 파라미터는 돈 뿐이다 

	public Buyer(int money) {
		this.myMoney = money;
	}
	
	public int getMoney() {
		return myMoney;
	}

	public void setMoney(int money) {
		this.myMoney = money;
	}

	public int getCokeStock() {
		return cokeStock;
	}

	public void setCokeStock(int cokeStock) {
		this.cokeStock = cokeStock;
	}

	public int getCyderStock() {
		return cyderStock;
	}

	public void setCyderStock(int cyderStock) {
		this.cyderStock = cyderStock;
	}

	public int getFantaStock() {
		return fantaStock;
	}

	public void setFantaStock(int fantaStock) {
		this.fantaStock = fantaStock;
	}
	
	/**
	 * 자판기에 돈을 넣고 구매한다.
	 * @param vendingMachine
	 * @param insertedMoney
	 */
	public void buy(VendingMachine vendingMachine, int insertedMoney) {
		this.myMoney -= insertedMoney;
		vendingMachine.sell(insertedMoney, this);
	}
	
	public int selectMenu() {
		Scanner input = new Scanner(System.in);
		int menu = input.nextInt();
		return menu;
	}
	
	/**
	 * 자판기에서 음료를 꺼낸다.
	 * @param drinkType
	 */
	public void putDrink(int drinkType) {
		if ( drinkType == 1 ) {
			cokeStock++;
		}
		else if ( drinkType == 2 ) {
			cyderStock++;
		}
		else if ( drinkType == 3 ) {
			fantaStock++;
		}
	}
	
	/**
	 * 자판기에서 잔돈을 거슬러 받는다.
	 * @param remainMoney
	 */
	public void getRemainMoney(int remainMoney) {
		this.myMoney += remainMoney;
	}
	
	@Override
	public String toString() {
		String message = String.format("구입한 콜라 개수 : %d | 구입한 사이다 개수 : %d | 구입한 환타 개수 : %d\n잔액 :%d", cokeStock, cyderStock, fantaStock, myMoney);
		return message;
	}

}
