package com.test.question.classproblem;

public class Q097 {
//	클래스: Refrigerator
	public static void main(String[] args) {
//		요구사항] Refrigerator 클래스와 Item 클래스를 설계하시오.
//			- Refrigerator 객체의 정보
//				- Item을 최대 100개까지 담을 수 있다.(멤버 변수 = Item 배열)
//			- Refrigerator 객체의 사용
//				- Item을 냉장고에 넣는다. void add(Item item);
//				- Item을 냉장고에서 꺼낸다. Item get(String name);
//				- 냉장고에 있는 Item의 개수를 확인한다. int count();
//				- 냉장고에 있는 Item을 확인한다. void listItem();
//			- Item 객체의 정보
//				- 식품명, 유통기한
		
		/*
		기초코드-----------------------------------------------------------
		class Refrigerator {
		   private Item[] items = new Item[100];
		
		   public void add(Item item) {
		   }
		   
		   public Item get(String name) {
		   }
		
		   public int count() {
		   }
		
		   public void listItem() {
		   }
		}
		
		class Item {
		   private String name;
		   private Calendar expiration;
		}
		
		호출-----------------------------------------------------------
		Refrigerator r = new Refrigerator();
		
		Item item1 = new Item();
		item1.setName("김치");
		item1.setExpiration("2024-07-21");
		r.add(item1);//냉장고에 넣기
		
		Item item2 = new Item();
		item2.setName("깍두기");
		item2.setExpiration("2024-07-14");
		r.add(item2);//냉장고에 넣기
		
		Item item3 = new Item();
		item3.setName("멸치볶음");
		item3.setExpiration("2024-07-16");
		r.add(item3);//냉장고에 넣기
		
		Item item4 = r.get("깍두기");//냉장고에서 꺼내기
		System.out.printf("%s의 유통기한 : %s\n", item4.getName(), item4.getExpiration());
		
		System.out.printf("냉장고 안의 총 아이템 개수 : %d개\n", r.count());
		
		r.listItem();
		
		출력-----------------------------------------------------------
		'김치'를 냉장고에 넣었습니다. //r.add(item1);
		'깍두기'를 냉장고에 넣었습니다. //r.add(item2);
		'멸치볶음'를 냉장고에 넣었습니다. //r.add(item3);
		
		깍두기의 유통기한 : 2024-07-14 //printf();
		냉장고 안의 총 아이템 개수 : 2개 //printf();
		
		[냉장고 아이템 목록] //r.listItem();
		김치(2024-07-21) 
		멸치볶음(2024-07-16)
		 */
		Refrigerator r = new Refrigerator();
		
		Item item1 = new Item();
		item1.setName("김치");
		item1.setExpiration("2024-07-21");
		r.add(item1);//냉장고에 넣기
		
		Item item2 = new Item();
		item2.setName("깍두기");
		item2.setExpiration("2024-07-14");
		r.add(item2);//냉장고에 넣기
		
		Item item3 = new Item();
		item3.setName("멸치볶음");
		item3.setExpiration("2024-07-16");
		r.add(item3);//냉장고에 넣기
		
		Item item4 = r.get("깍두기");//냉장고에서 꺼내기
		System.out.printf("%s의 유통기한 : %s\n", item4.getName(), item4.getExpiration());
		
		System.out.printf("냉장고 안의 총 아이템 개수 : %d개\n", r.count());
		
		r.listItem();
	}
}
