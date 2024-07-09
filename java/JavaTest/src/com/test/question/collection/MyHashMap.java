package com.test.question.collection;

public class MyHashMap {
	private Entry[] list;
	private int index;
	
	public MyHashMap() {
		this.list = new Entry[4];
		this.index = 0;
	}
	
	public String put(String key, String value) {
		String temp = null;
		int index = indexOfKey(key);
		
		if(index == -1) {
			if(this.list.length == this.index) {
				increaseListSize();
			}

			this.list[this.index] = new Entry(key, value); 
			this.index++;
		} else {
			this.list[index].setValue(value);
		}
		
		return temp;
	}
	
	private void increaseListSize() {
		Entry[] temp = new Entry[this.list.length * 2];
		
		for(int i=0; i<this.index; i++) {
			temp[i] = list[i];
		}
		
		list = temp;
	}

	public String get(String key) {
		for(int i=0; i<this.index; i++) {
			if(this.list[i].getKey().equals(key)) {
				return this.list[i].getValue();
			}
		}
		return null;
	}
	
	public int size() {
		return this.index;
	}
	
	public String remove(String key) {
		int index = indexOfKey(key);
		
		if(index > -1) {
			String temp = this.list[index].getValue();
			
			for(int i=index; i<this.index - 1; i++) {
				this.list[i] = this.list[i + 1];
			}
			
			this.index--;
			
			return temp;
		} else {
			return null;
		}
	}
	
	private int indexOfKey(String key) {
		int index = -1;
		
		for(int i=0; i<this.index; i++) {
			if(this.list[i].getKey().equals(key)) {
				return i;
			}
		}
		
		return index;
	}
	
	public boolean containsKey(String key) {
		if(indexOfKey(key) > -1) {
			return true;
		}
		return false;
	}
	
	public boolean containsValue(String value) {
		for(int i=0; i<this.index; i++) {
			if(this.list[i].getValue().equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	public void clear() {
		this.index = 0;
	}
	
	public void trimToSize() {
		Entry[] temp = new Entry[this.index];
		
		for(int i=0; i<this.index; i++) {
			temp[i] = this.list[i];
		}
		
		this.list = temp;
	}
	
	@Override
	public String toString() {
		String temp = "\r\n[";
		
		for(int i=0; i<this.index; i++) {
			temp += "\t" + this.list[i] + "\r\n";
		}
		
		temp += "]\r\n";
		return temp;
	}
}

class Entry {
	String key;
	String value;
	
	public Entry(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "key = " + this.key + ", value = " + this.value;
	}
}