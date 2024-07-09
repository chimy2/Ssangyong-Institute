package com.test.question.collection;

public class MyHashMap2 {
	private String[] keys;
	private String[] values;
	private int index;
	
	public MyHashMap2() {
		this.keys = new String[4];
		this.values = new String[4];
		this.index = 0;
	}
	
	public String put(String key, String value) {
		String temp = null;
		int index = searchIndex(true, key);
		
		if(index > -1) {
			temp = values[index];
			values[index] = value; 
		} else {
			if(this.keys.length == this.index) {
				increaseListSize();
			}
			this.keys[this.index] = key;
			this.values[this.index] = value;
			this.index++;
		}
		return temp;
	}
	
	private void increaseListSize() {
		String[] tempKey = new String[this.keys.length * 2];
		String[] tempValue = new String[this.values.length * 2];
		
		for(int i=0; i<this.index; i++) {
			tempKey[i] = keys[i];
			tempValue[i] = values[i];
		}
		
		this.keys = tempKey;
		this.values = tempValue;
	}

	public String get(String key) {
		String temp = null;
		int index = searchIndex(true, key);
		if(index > -1) {
			temp = this.values[index];
		}
		return temp;
	}
	
	public int size() {
		return this.index;
	}
	
	public String remove(String key) {
		String temp = null;
		int index = searchIndex(true, key);
		
		if(index > -1) {
			for(int i=index; i<this.index - 1; i++) {
				this.keys[i] = this.keys[i + 1];
				this.values[i] = this.values[i + 1];
			}
			temp = this.values[index];
			this.index--;
		}
		
		return temp;
	}
	
	public boolean containsKey(String key) {
		if(searchIndex(true, key) > -1) {
			return true;
		}
		return false;
	}
	
	public boolean containsValue(String value) {
		if(searchIndex(false, value) > -1) {
			return true;
		}
		return false;
	}
	
	public int searchIndex(boolean isKey, String search) {
		int index = -1;
		
		for(int i=0; i<this.index; i++) {
			if(isKey && this.keys[i].equals(search) 
					|| !isKey && this.values[i].equals(search)) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	public void clear() {
		this.index = 0;
	}
	
	public void trimToSize() {
		String[] tempKey = new String[this.index];
		String[] tempValue = new String[this.index];
		
		for(int i=0; i<this.index; i++) {
			tempKey[i] = this.keys[i];
			tempValue[i] = this.values[i];
		}
		
		this.keys = tempKey;
		this.values = tempValue;
	}
	
	@Override
	public String toString() {
		String temp = "[\r\n";
		
		for(int i=0; i<this.index; i++) {
			temp += "\tkey = " + keys[i] + ", value = " + values[i] + "\r\n";
		}
		
		temp += "]\r\n";
		return temp;
	}
}