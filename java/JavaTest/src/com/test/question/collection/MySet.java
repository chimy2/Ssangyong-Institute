package com.test.question.collection;

public class MySet {
	private String[] list;
	private int index;
	private int searchIndex;
	
	public MySet() {
		this.list = new String[4];
		this.index = 0;
		this.searchIndex = 0;
	}
	
	public boolean add(String value) {
		int index = indexOf(value);
		
		if(index > -1) {
			return false;
		} else {
			if(this.list.length == this.index) {
				increaseListSize();
			}
			this.list[this.index] = value; 
			this.index++;
			return true;
		}
	}
	
	public void increaseListSize() {
		String[] temp = new String[this.list.length * 2];
		
		for(int i=0; i<this.index; i++) {
			temp[i] = this.list[i];
		}
		
		this.list = temp;
	}
	
	public int indexOf(String value) {
		int index = -1; 
		
		for(int i=0; i<this.index; i++) {
			if(this.list[i].equals(value)) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	public int size() {
		return this.index;
	}
	
	public boolean remove(String value) {
		int index = indexOf(value);
		if(index > -1) {
			for(int i=index; i<this.index - 1; i++) {
				this.list[i] = this.list[i + 1];
			}
			this.index--;
			return true;
		} else {
			return false;
		}
	}
	
	public void clear() {
		this.index = 0;
	}
	
	public boolean hasNext() {
		if(this.searchIndex < this.index) {
			return true;
		}
		return false;
	}
	
	public String next() {
		if(this.searchIndex < this.index) {
			return this.list[searchIndex++];
		} else {
			return null;
		}
	}
}
