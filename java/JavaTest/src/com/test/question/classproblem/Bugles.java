package com.test.question.classproblem;

import java.util.Calendar;

public class Bugles {
	private int price;					//가격
	private int weight;					//용량
	private Calendar creationTime;		//생산일자
	private int expiration;				//유통기한
	
	//getter, setter 구현
	public String getPrice() {
		return String.format("%,d", this.price);
	}

	public void setSize(int weight) {
		int[] sizes = { 300, 500, 850 };
		int[] prices = { 850, 1200, 1950 };
		
		for(int i=0; i<sizes.length; i++) {
			if(sizes[i] == weight) {
				this.weight = weight;
				this.price = prices[i];
				break;
			}
		}
	}

	public void setCreationTime(String creationTime) {
		Calendar cal = Calendar.getInstance();
		String[] arr = creationTime.split("-");
		
		int year = Integer.parseInt(arr[0]);
		int month = Integer.parseInt(arr[1]) - 1;
		int day = Integer.parseInt(arr[2]);
		
		cal.set(year, month, day, 0, 0, 0);
		
		this.creationTime = cal;
	}

	public int getExpiration() {
		int result = 0;
		Calendar now = Calendar.getInstance();
		Calendar expirationTime = (Calendar) now.clone();
		int preser = 0;

		int[] sizes = { 300, 500, 850 };
		int[] exp = { 7, 10, 15 };
		
		for(int i=0; i<sizes[i]; i++) {
			if(sizes[i] == this.weight) {
				preser = exp[i] - 1;
				break;
			}
		}
		
		expirationTime.set(Calendar.YEAR, this.creationTime.get(Calendar.YEAR));
		expirationTime.set(Calendar.MONTH, this.creationTime.get(Calendar.MONTH));
		expirationTime.set(Calendar.DATE, this.creationTime.get(Calendar.DATE));
		expirationTime.add(Calendar.DATE, preser);
		
		result = (int) (expirationTime.getTimeInMillis() - now.getTimeInMillis()) / 1000 / 60 / 60 / 24;
		return result;
	}

	public void eat() {
		int remain = getExpiration();
		
		if (remain >= 0) {
			System.out.println("과자를 맛있게 먹습니다.\n");
		}else {
			System.out.println("유통기한이 지나 먹을 수 없습니다.\n");
		}
	}
}
