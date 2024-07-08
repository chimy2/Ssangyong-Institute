package com.test.question.collection;

public class MyQueue {
	private String[] list;
	private int length;
	
	
	public MyQueue() { 
		list = new String[4];
	}
	
	public boolean add(String value) {
		if(this.list.length == this.length) {
			increaseListSize();
		}
		this.list[length] = value;
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
}
