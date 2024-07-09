package com.test.question.collection;

public class MyQueue {
	private String[] list;
	private int length;
	
	
	public MyQueue() { 
		this.list = new String[4];
		this.length = 0;
	}
	
	public MyQueue(int capacity) {
		this.list = new String[capacity];
		this.length = 0;
	}
	
	public boolean add(String value) {
		if(this.list.length == this.length) {
			increaseListSize();
		}
		this.list[this.length] = value;
		this.length++;
		return true;
	}
	
	private void increaseListSize() {
		String[] temp = new String[this.list.length * 2];
		
		for(int i=0; i<this.length; i++) {
			temp[i] = this.list[i];
		}
		
		this.list = temp;
	}

	public String poll()  {
		String first = list[0];
		for(int i=0; i<this.length-1; i++) {
			this.list[i] = this.list[i + 1];
		}
		this.length--;
		return first;
	}
	
	public int size() {
		return this.length;
	}
	
	public String peek() {
		return this.list[0];
	}
	
	public void clear() {
		for(int i=0; i<this.length; i++) {
			this.list[i] = null;
		}
		this.length = 0;
	}
	
	public void trimToSize() {
		String[] temp = new String[this.length];
		
		for(int i=0; i<this.length; i++) {
			temp[i] = list[i];
		}
		
		this.list = temp;
	}
	
	@Override
	public String toString() {
		String temp = "";
		
		temp += "\r\n";
		temp += "length: "  + this.list.length + "\r\n";
		temp += "index: " + this.length + "\r\n";
		temp += "[\r\n";
		for(int i=0; i<this.list.length; i++) {
			temp += " " + i + ":" + this.list[i] + "\r\n";
		}
		temp +="]\r\n";
		
		return temp;
	}
}
