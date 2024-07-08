package com.test.question.collection;

public class MyArrayList {
	private String[] list;
	private int index;
	
	public MyArrayList() {
		this.list = new String[4];
	}
	
	public boolean add(String value) {
		if(this.list.length == this.index) {
			increaseListSize();
		}
		this.list[index++] = value;
		return true;
	}
	
	private void increaseListSize() {
		String[] temp = new String[this.list.length * 2];
		
		for(int i=0; i<this.list.length; i++) {
			temp[i] = this.list[i];
		}
		
		this.list = temp;
	}

	public String get(int index) {
		return this.list[index];
	}
	
	public int size() {
		return this.index;
	}
	
	public String set(int index, String value) {
		String temp = this.list[index];
		this.list[index] = value;
		return temp;
	}
	
	public String remove(int index) {
		String temp = this.list[index];
			
		for(int i=0; i<this.index - index; i++) {
			this.list[index + i] = this.list[index + i + 1];
		}
		
		this.index--;
		
		return temp;
	}
	
	public boolean add(int index, String value) {
		if(this.list.length == this.index) {
			increaseListSize();
		}
		
		for(int i=this.index - 1; i>=index; i--) {
			this.list[i + 1] = this.list[i];
		}
		
		this.list[index] = value;
		this.index++;
		
		return true;
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
	
	public int lastIndexOf(String value) {
		int index = -1;
		
		for(int i=this.index-1; i>=0; i--) {
			if(this.list[i].equals(value)) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	public void clear() {
		for(int i=0; i<this.index; i++) {
			this.list[i] = null;
		}
		this.index = 0;
	}
	
	public void trimToSize() {
		String[] temp = new String[this.index];
		
		for(int i=0; i<this.index; i++) {
			temp[i] = this.list[i];
		}
		
		this.list = temp;
	}
	
	@Override
	public String toString() {
		String result = "";
		result += "[";
		for(int i=0; i<this.index; i++) {
			result += this.list[i];
			if(i != this.index - 1) {
				result += ", ";
			}
		}
		result += "]\n";
		return result;
	}
}
