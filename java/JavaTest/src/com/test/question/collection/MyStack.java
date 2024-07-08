package com.test.question.collection;

public class MyStack {
	private String[] list;
	private int index;
	
	public MyStack() {
		this.list = new String[4];
	}
	
	public boolean push(String value) {
		if(this.list.length == this.index) {
			increaseListSize();
		}
		this.list[index] = value;
		this.index++;
		return true;
	}
	
	private void increaseListSize() {
		String[] temp = new String[this.list.length * 2];
		
		for(int i=0; i<this.list.length; i++) {
			temp[i] = this.list[i];
		}
		
		this.list = temp;
	}

	public String pop() {
		this.index--;
		String last = this.list[index];
		this.list[index] = null;
		return last;
	}
	
	public int size() {
		return this.index;
	}
	
	public String peek() {
		return this.list[index - 1];
	}
	
	public void clear() {
		String[] temp = new String[this.list.length];
		this.list = temp;
		this.index = 0;
	}
	
	public void trimToSize() {
		String[] temp = new String[this.index];
		
		for(int i=0; i<this.index; i++) {
			temp[i] = list[i];
		}
		
		this.list = temp;
	}
}
