package com.ktds.mcj.vending.machine;

public class VendingMachine {

	private final int COKE = 1;
	private final int CYDER = 2;
	private final int FANTA = 3;
	
	private final int COKE_PRICE = 700;
	private final int CYDER_PRICE = 800;
	private final int FANTA_PRICE = 900;

	private int cokeStock;
	private int cyderStock;
	private int fantaStock;
	private int money;

	public VendingMachine(int money, int cokeStock, int cyderStock, int fantaStock) {
		this.money = money;
		this.cokeStock = cokeStock;
		this.cyderStock = cyderStock;
		this.fantaStock = fantaStock;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
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

	public void sell(int insertedMoney, Buyer buyer) {

		this.money += insertedMoney;

		String menu = "";
		int selectedMenu = 0;

		while (true) {
			// 메뉴 출력
			System.out.println("---------------------------------");
			menu = String.format("1. 콜라(%d원) : %d개  |  2. 사이다(%d원) : %d개  |  3. 환타(%d원) : %d개  |  4. 구매 종료", 
					COKE_PRICE, cokeStock, CYDER_PRICE, cyderStock, FANTA_PRICE, fantaStock);
			System.out.println(menu);
			System.out.println("---------------------------------");

			System.out.print("메뉴를 선택하세요 : ");
			// 사용자가 메뉴를 선택한다.
			selectedMenu = buyer.selectMenu();

			if (selectedMenu == COKE) {
				if (cokeStock > 0) {
					if (insertedMoney >= COKE_PRICE) {
						cokeStock -= 1;
						buyer.putDrink(COKE);
						insertedMoney -= COKE_PRICE;   //insertedMoney = insertedMoney-COKE_PRICE
						//이게 두번째 샀을 때 잔액이 제대로 나오지 않는 이유는 insertedMoney가 계속 더해지기 때문 
						buyer.getRemainMoney(insertedMoney);
						this.money -= insertedMoney;  // x-=y -> x= x-y
						
					} else {
						System.out.println("잔액이 부족합니다.");
					}
				} else {
					System.out.println("재고가 부족합니다.");
				}
			} else if (selectedMenu == CYDER) {
				if (cyderStock > 0) {
					if (insertedMoney >= CYDER_PRICE) {
						cyderStock -= 1;
						buyer.putDrink(CYDER);
						insertedMoney -= CYDER_PRICE;
						
						buyer.getRemainMoney(insertedMoney);
						this.money -= insertedMoney;
						
					} else {
						System.out.println("잔액이 부족합니다.");
					}
				} else {
					System.out.println("재고가 부족합니다.");
				}
			} else if (selectedMenu == FANTA) {
				if (fantaStock > 0) {
					if (insertedMoney >= FANTA_PRICE) {
						fantaStock -= 1;
						buyer.putDrink(FANTA);
						insertedMoney -= FANTA_PRICE;
						
						buyer.getRemainMoney(insertedMoney);
						this.money -= insertedMoney;
						
					} else {
						System.out.println("잔액이 부족합니다.");
					}
				} else {
					System.out.println("재고가 부족합니다.");
				}
			} else if ( selectedMenu == 4 ) {
				System.out.println("안녕! 이제 가세요");
				break;
			}
			
			System.out.println(buyer);
			System.out.println(this);
		}

	}
	
	@Override
	public String toString() {
		String message = String.format("콜라 개수 : %d | 사이다 개수 : %d | 환타 개수 : %d\n수입 :%d", cokeStock, cyderStock, fantaStock, money);
		return message;
	}

}
