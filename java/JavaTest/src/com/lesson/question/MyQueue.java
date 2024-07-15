package com.test.question;

public class MyQueue {
	
	private String[] list;
	private int index; //현재 추가될 요소의 위치 & size
	
	public MyQueue() {
		this.list = new String[4];
		this.index = 0;
	}
	
	public MyQueue(int capacity) {
		this.list = new String[capacity];
		this.index = 0;
	}
	
	@Override
	public String toString() {
		
		String temp = "";
		
		temp += "\r\n";
		temp += "length: " + this.list.length + "\r\n";
		temp += "index: " + this.index + "\r\n";
		temp += "[\r\n";
		for (int i=0; i<this.list.length; i++) {
			temp += "  " + i + ":" + this.list[i] + "\r\n";
		}
		temp += "]\r\n";
		
		return temp;
	}

	public void add(String value) {
		
		if (checkLength()) {
			doubleList();
		}
		
		this.list[this.index] = value;
		this.index++;
		
	}

	private void doubleList() {
		
		String[] temp = new String[this.list.length * 2];
		
		for (int i=0; i<this.list.length; i++) {
			temp[i] = this.list[i];
		}
		
		this.list = temp;
	}

	private boolean checkLength() {
		
		return this.index == this.list.length;
	}

	public int size() {
		
		return this.index;
	}

	public String poll() {
		
		if (this.index == 0) {
			return null;
		}
		
		String temp = this.list[0];
		
		for (int i=0; i<this.list.length-1; i++) {
			this.list[i] = this.list[i+1];
		}
		
		this.index--;
		
		return temp;
	}

	public String peek() {
		
		if (this.index == 0) {
			return null;
		}
		
		return this.list[0];
	}

	public void clear() {
		
//		for (int i=0; i<this.list.length; i++) {
//			this.list[i] = null;
//		}
//		
//		this.index = 0;
		
		
//		this.list = new String[4]; //덮어쓰기
//		this.index = 0;
		
		
		this.index = 0;
		
	}

	public void trimToSize() {
		
		String[] temp = new String[this.index];
		
		for (int i=0; i<temp.length; i++) {
			temp[i] = this.list[i];
		}
		
		this.list = temp;
		
	}

}



















