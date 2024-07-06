package com.test.question.classproblem;

public class Barista {
	public Espresso makeEspresso(int bean) {
		Espresso espresso = new Espresso(bean);
		Coffee.bean += bean;
		Coffee.beanTotalPrice += bean * Coffee.beanUnitPrice;
		Coffee.espresso++;
		return espresso;
	}
	
	public Espresso[] makeEspressoes(int bean, int count) {
		Espresso[] espressos = new Espresso[count];
		
		for(int i=0; i<count; i++) {
			espressos[i] = makeEspresso(bean);
		}
		
		return espressos;
	}
	
	public Latte makeLatte(int bean, int milk) {
		Latte latte = new Latte(bean, milk);
		Coffee.bean += bean;
		Coffee.milk += milk;
		Coffee.beanTotalPrice += bean * Coffee.beanUnitPrice;
		Coffee.milkTotalPrice += milk * Coffee.milkUnitPrice;
		Coffee.latte++;
		return latte;
	}
	
	public Latte[] makeLattes(int bean, int milk, int count) {
		Latte[] lettes = new Latte[count];
		
		for(int i=0; i<count; i++) {
			lettes[i] = makeLatte(bean, milk);
		}
		
		return lettes;
	}
	
	public Americano makeAmericano(int bean, int water, int ice) {
		Americano americano = new Americano(bean, water, ice);
		Coffee.bean += bean;
		Coffee.water += water;
		Coffee.ice += ice;
		Coffee.beanTotalPrice += bean * Coffee.beanUnitPrice;
		Coffee.waterTotalPrice += water * Coffee.waterUnitPrice;
		Coffee.iceTotalPrice += ice * Coffee.iceUnitPrice;
		Coffee.americano++;
		return americano;
		
	}
	
	public Americano[] makeAmericanos(int bean, int water, int ice, int count) {
		Americano[] americanos = new Americano[count];
		
		for(int i=0; i<count; i++) {
			americanos[i] = makeAmericano(bean, water, ice);
		}
		
		return americanos;
	}
	
	public void result() {
		System.out.println("=================================");
		System.out.println("판매 결과");
		System.out.println("=================================");
		System.out.println();
		
		System.out.println("---------------------------------");
		System.out.println("음료 판매량");
		System.out.println("---------------------------------");
		System.out.printf("에스프레소 : %,d잔\n", Coffee.espresso);
		System.out.printf("아메리카노 : %,d잔\n", Coffee.americano);
		System.out.printf("라테 : %,d잔\n", Coffee.latte);
		System.out.println();
		
		System.out.println("---------------------------------");
		System.out.println("원자재 소비량");
		System.out.println("---------------------------------");
		System.out.printf("원두 : %,dg\n", Coffee.bean);
		System.out.printf("물 : %,dml\n", Coffee.water);
		System.out.printf("얼음 : %,d개\n", Coffee.ice);
		System.out.printf("우유 : %,dml\n", Coffee.milk);
		System.out.println();
		
		System.out.println("---------------------------------");
		System.out.println("매출액");
		System.out.println("---------------------------------");
		System.out.printf("원두 : %,d원\n", Coffee.beanTotalPrice);
		System.out.printf("물 : %,.0f원\n", Coffee.waterTotalPrice);
		System.out.printf("얼음 : %,d원\n", Coffee.iceTotalPrice);
		System.out.printf("우유 : %,d원\n", Coffee.milkTotalPrice);
		System.out.println();
		
	}
}
