package com.test.question.classproblem;

public class Refrigerator {
	private Item[] items = new Item[100];

	public void add(Item item) {
		int index = count();
		
		if(items.length <= index) {
			System.out.println("냉장고가 꽉 차 있습니다");
			return;
		}
		
		items[index] = item;
		System.out.printf("'%s'를 냉장고에 넣었습니다\n", items[index].getName());
	}

	public Item get(String name) {
		Item item = null;
		int idx = 0;
		
		for(; idx<items.length; idx++) {
			String temp = items[idx] == null ? null : items[idx].getName();
			if(temp == null) {
				System.out.printf("냉장고에 '%s'가 없습니다\n", name);
				break;
			} else if(temp.equals(name)) {
				item = items[idx];
				break;
			}
		}
		
		for(int i=idx + 1; i<items.length; i++) {
			items[i - 1] = items[i];
			if(items[i] == null) {
				break;
			}
		}
		
		return item;
	}

	public int count() {
		int idx = 0;
		
		for(; idx<items.length; idx++) {
			if(items[idx] == null) {
				break;
			}
		}
		
		return idx;
	}

	public void listItem() {
		System.out.println("[냉장고 아이템 목록]");

		for(int i=0; i<items.length; i++) {
			if(items[i] != null) {
				System.out.println(items[i].toString());
			}
		}
	}
	
	
}
