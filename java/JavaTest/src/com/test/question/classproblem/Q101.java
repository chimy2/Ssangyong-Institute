package com.test.question.classproblem;

public class Q101 {
//	클래스: static
	public static void main(String[] args) {
//		요구사항] 음료를 판매하고 그 매출액과 판매량을 구하시오.
//			- static 멤버를 구현하시오.
//			- Barista
//				- 바리스타 클래스
//				- 행동
//					- Espresso makeEspresso(int bean)
//						- 에스프레소 1잔을 만든다.
//						- int bean : 원두량(g)
//						- return Espreeso : 에스프레소 1잔
//					- Espresso[] makeEspressoes(int bean, int count)
//						- 에스프레소 N잔을 만든다.
//						- int bean : 원두량(g)
//						- int count : 음료 개수(잔)
//						- return Espresso[] : 에스프레소 N잔
//					- Latte makeLatte(int bean, int milk)
//						- 라테 1잔을 만든다.
//						- int baen : 원두량(g)
//						- int milk : 우유량(ml)
//						- return Latte : 라테 1잔
//					- Latte[] makeLattes(int bean, int milk, int count)
//						- 라테 N잔을 만든다.
//						- int baen : 원두량(g)
//						- int milk : 우유량(ml)
//						- int count : 음료 개수(잔)
//						- return Latte[] : 라테 N잔
//					- Americano makeAmericano(int bean, int water, int ice)
//						- 아메리카노 1잔을 만든다.
//						- int baen : 원두량(g)
//						- int water : 물량(ml)
//						- int ice : 얼음 개수(개)
//						- return Americano : 아메리카노 1잔
//					- Americano[] makeAmericanos(int bean, int water, int ice, int count)
//						- 아메리카노 N잔을 만든다.
//						- int baen : 원두량(g)
//						- int water : 물량(ml)
//						- int ice : 얼음 개수(개)
//						- int count : 음료 개수(잔)
//						- return Americano[] : 아메리카노 N잔
//					- void result()
//						- 판매 결과를 출력한다.
//						- 음료 판매량(에스프레소 판매 개수, 라테 판매 개수, 아메리카노 판매 개수)
//						- 원자재 소비량(원두 소비량, 물 소비량, 우유 소비량, 얼음 소비량)
//						- 매출액(원두 판매액, 물 판매액, 우유 판매액, 얼음 판매액)
//			- Coffee
//				- 공용 정보 클래스
//				- 상태
//					- static bean
//						- 총 원두량(g)
//					- static water
//						- 총 물 용량(ml)
//					- static ice
//						- 총 얼음 개수(개)
//					- static milk
//						- 총 우유 용량(ml)
//					- static beanUnitPrice
//						- 원두 단가(원)
//						- 1g당 1원
//					- static waterUnitPrice
//						- 물 단가(원)
//						- 1ml당 0.2원
//					- static iceUnitPrice
//						- 얼음 단가(원)
//						- 1개당 3원
//					- static milkUnitPrice
//						- 우유 단가(원)
//						- 1ml당 4원
//					- static beanTotalPrice
//						- 원두 총 판매액(원)
//					- static waterTotalPrice
//						- 물 총 판매액(원)
//					- static iceTotalPrice
//						- 얼음 총 판매액(원)
//					- static milkTotalPrice
//						- 우유 총 판매액(원)
//					- static americano
//						- 아메리카노 총 판매 개수(잔)
//					- static latte
//						- 라테 총 판매 개수(잔)
//					- static espresso
//						- 에스프레소 총 판매 개수(잔)
//			- Espresso
//				- 에스프레소 클래스
//				- 상태
//					- bean
//						- 에스프레소 생산 시 들어가는 원두량(g)
//				- 행동
//					- void drink()
//						- 커피를 마신다.(출력)
//			- Latte
//				- 라테 클래스
//				- 상태
//					- bean
//						- 라테 생산 시 들어가는 원두량(g)
//					- milk
//						- 라테 생산 시 들어가는 우유량(ml)
//				- 행동
//					- void drink()
//						- 커피를 마신다.(출력)
//			- Americano
//				- 아메리카노 클래스
//				- 상태
//					- bean
//						- 아메리카노 생산 시 들어가는 원두량(g)
//					- water
//						- 아메리카노 생산 시 들어가는 물량(ml)
//					- ice
//						- 아메리카노 생산 시 들어가는 얼음 개수(개)
//				- 행동
//					- void drink()
//						- 커피를 마신다.(출력)
		/*
		호출-----------------------------------------------------------
		//바리스타
		Barista barista = new Barista();
		
		//손님 1
		//에스프레소 1잔 주문 - 원두 30g
		Espresso e1 = barista.makeEspresso(30);
		e1.drink();
		
		//손님 2
		//라테 1잔 주문 - 원두 30g, 우유 250ml
		Latte l1 = barista.makeLatte(30, 250);
		l1.drink();
		
		//손님 3
		//아메리카노 1잔 주문 - 원두 30g, 물 300ml, 각얼음 20개
		Americano a1 = barista.makeAmericano(30, 300, 20);
		a1.drink();
		
		//손님 4
		//에스프레소 10잔 주문 - 원두 25g
		Espresso[] e2 = barista.makeEspressoes(25, 10);
		
		for (Espresso e : e2) {
		      e.drink();
		}
		
		//손님 5
		//라테 5잔 주문 - 원두 25g, 우유 300ml
		Latte[] l2 = barista.makeLattes(25, 300, 5);
		
		for (Latte l : l2) {
		      l.drink();
		}
		
		//손님 6
		//아메리카노 15잔 주문 - 원두 20g, 물 350ml, 각얼음 30개
		Americano[] a2 = barista.makeAmericanos(20, 350, 30, 15);
		
		for (Americano a : a2) {
		      a.drink();
		}
		
		//결산
		barista.result();
		
		출력-----------------------------------------------------------
		원두 30g으로 만들어진 에스프레소를 마십니다. //e1.drink();
		원두 30g, 우유 250ml으로 만들어진 라테를 마십니다. //l1.drink();
		원두 30g, 물 300ml, 얼음 20개로 만들어진 아메리카노를 마십니다. //a1.drink();
		
		//손님 4
		원두 25g으로 만들어진 에스프레소를 마십니다.
		원두 25g으로 만들어진 에스프레소를 마십니다.
		원두 25g으로 만들어진 에스프레소를 마십니다.
		원두 25g으로 만들어진 에스프레소를 마십니다.
		원두 25g으로 만들어진 에스프레소를 마십니다.
		원두 25g으로 만들어진 에스프레소를 마십니다.
		원두 25g으로 만들어진 에스프레소를 마십니다.
		원두 25g으로 만들어진 에스프레소를 마십니다.
		원두 25g으로 만들어진 에스프레소를 마십니다.
		원두 25g으로 만들어진 에스프레소를 마십니다.
		
		//손님 5
		원두 25g, 우유 300ml으로 만들어진 라테를 마십니다.
		원두 25g, 우유 300ml으로 만들어진 라테를 마십니다.
		원두 25g, 우유 300ml으로 만들어진 라테를 마십니다.
		원두 25g, 우유 300ml으로 만들어진 라테를 마십니다.
		원두 25g, 우유 300ml으로 만들어진 라테를 마십니다.
		
		//손님 6
		원두 20g, 물 350ml, 얼음 30개로 만들어진 아메리카노를 마십니다.
		원두 20g, 물 350ml, 얼음 30개로 만들어진 아메리카노를 마십니다.
		원두 20g, 물 350ml, 얼음 30개로 만들어진 아메리카노를 마십니다.
		원두 20g, 물 350ml, 얼음 30개로 만들어진 아메리카노를 마십니다.
		원두 20g, 물 350ml, 얼음 30개로 만들어진 아메리카노를 마십니다.
		원두 20g, 물 350ml, 얼음 30개로 만들어진 아메리카노를 마십니다.
		원두 20g, 물 350ml, 얼음 30개로 만들어진 아메리카노를 마십니다.
		원두 20g, 물 350ml, 얼음 30개로 만들어진 아메리카노를 마십니다.
		원두 20g, 물 350ml, 얼음 30개로 만들어진 아메리카노를 마십니다.
		원두 20g, 물 350ml, 얼음 30개로 만들어진 아메리카노를 마십니다.
		원두 20g, 물 350ml, 얼음 30개로 만들어진 아메리카노를 마십니다.
		원두 20g, 물 350ml, 얼음 30개로 만들어진 아메리카노를 마십니다.
		원두 20g, 물 350ml, 얼음 30개로 만들어진 아메리카노를 마십니다.
		원두 20g, 물 350ml, 얼음 30개로 만들어진 아메리카노를 마십니다.
		원두 20g, 물 350ml, 얼음 30개로 만들어진 아메리카노를 마십니다.
		
		//barista.result();
		=================================
		판매 결과
		=================================
		
		---------------------------------
		음료 판매량
		---------------------------------
		에스프레소 : 11잔
		아메리카노 : 16잔
		라테 : 6잔
		
		---------------------------------
		원자재 소비량
		---------------------------------
		원두 : 765g
		물 : 5,550ml
		얼음 : 470개
		우유 : 1,750ml
		
		---------------------------------
		매출액
		---------------------------------
		원두 : 765원
		물 : 1,110원
		얼음 : 1,410원
		우유 : 7,000원
		 */
		//바리스타
		Barista barista = new Barista();
		
		//손님 1
		//에스프레소 1잔 주문 - 원두 30g
		Espresso e1 = barista.makeEspresso(30);
		e1.drink();
		
		//손님 2
		//라테 1잔 주문 - 원두 30g, 우유 250ml
		Latte l1 = barista.makeLatte(30, 250);
		l1.drink();
		
		//손님 3
		//아메리카노 1잔 주문 - 원두 30g, 물 300ml, 각얼음 20개
		Americano a1 = barista.makeAmericano(30, 300, 20);
		a1.drink();
		
		//손님 4
		//에스프레소 10잔 주문 - 원두 25g
		Espresso[] e2 = barista.makeEspressoes(25, 10);
		
		for (Espresso e : e2) {
		      e.drink();
		}
		
		//손님 5
		//라테 5잔 주문 - 원두 25g, 우유 300ml
		Latte[] l2 = barista.makeLattes(25, 300, 5);
		
		for (Latte l : l2) {
		      l.drink();
		}
		
		//손님 6
		//아메리카노 15잔 주문 - 원두 20g, 물 350ml, 각얼음 30개
		Americano[] a2 = barista.makeAmericanos(20, 350, 30, 15);
		
		for (Americano a : a2) {
		      a.drink();
		}
		
		//결산
		barista.result();
	}
}
