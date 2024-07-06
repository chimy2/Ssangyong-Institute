package com.test.question.classproblem;

import java.util.Calendar;

public class Item {
	private String name;
	private Calendar expiration;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpiration() {
		return String.format("%tF", expiration);
	}

	public void setExpiration(String expirationDate) {
		String[] arr = expirationDate.split("-");
		Calendar date = Calendar.getInstance();
		int year = Integer.parseInt(arr[0]);
		int month = Integer.parseInt(arr[1]) - 1;
		int day = Integer.parseInt(arr[2]);
		
		date.set(year, month, day);
		this.expiration = date;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s)", this.name, this.getExpiration());
	}
}
