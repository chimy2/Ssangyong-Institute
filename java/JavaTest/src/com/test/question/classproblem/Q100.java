package com.test.question.classproblem;

public class Q100 {
//	클래스: static
	public static void main(String[] args) {
//		요구사항] 포장하는 직원 객체를 만드시오. 그 직원을 통해 연필, 지우개, 볼펜, 자를 포장하시오.
//			- static 멤버를 구현하시오.
//			- Packer
//				- 사무용품을 포장하는 직원
//				- 상태
//					- static pencilCount
//						- 연필 포장 개수(개)
//					- static eraserCount
//						- 지우개 포장 개수(개)
//					- static ballPoinPenCount
//						- 볼펜 포장 개수(개)
//					- static rulerCount
//						- 자 포장 개수(개)
//				- 행동
//					- void packing(Pencil pencil)
//						- 연필을 검수하고 포장한다.
//						- Pencil pencil : 연필
//					- void packing(Eraser eraser)
//						- 지우개를 검수하고 포장한다.
//						- Eraser eraser : 지우개
//					- void packing(BallPointPen ballPointPen)
//						- 볼펜을 검수하고 포장한다.
//						- BallPointPen ballPointPen : 볼펜
//					- void packing(Ruler ruler)
//						- 자를 검수하고 포장한다.
//						- Ruler ruler : 자
//					- void countPacking(int type)
//						- 포장한 내용물 개수를 출력한다.
//						- int type : 출력할 내용물의 종류
//							- 0 : 모든 내용물
//							- 1 : 연필
//							- 2 : 지우개
//							- 3 : 볼펜
//							- 4 : 자
//			- Pencil
//				- 연필 클래스
//				- 상태
//					- hardness
//						- 흑연 등급(4B, 3B, 2B, B, HB, H, 2H, 3H, 4H)
//				- 행동
//					- String info()
//						- 연필의 정보를 반환한다.
//			- Eraser
//				- 지우개 클래스
//				- 상태
//					- size
//						- 지우개 크기(Large, Medium, Small)
//				- 행동
//					- String info()
//						- 지우개의 정보를 반환한다.
//			- BallPointPen
//				- 볼펜 클래스
//				- 상태
//					- thickness
//						- 볼펜 심 두께(0.3mm, 0.5mm, 0.7mm, 1mm, 1.5mm)
//					- color
//						- 볼펜 색상(red, blue, green, black)
//				- 행동
//					- String info()
//						- 볼펜의 정보를 반환한다.
//			- Ruler
//				- 자 클래스
//				- 상태
//					- length
//						- 자 길이(30cm, 50cm, 100cm)
//					- shape
//						- 자 형태(줄자, 운형자, 삼각자)
//				- 행동
//					- String info()
//						- 자의 정보를 반환한다.
		/*
		호출-----------------------------------------------------------
		//포장하는 직원
		Packer packer = new Packer();
		
		//연필
		Pencil p1 = new Pencil();
		p1.setHardness("HB");
		packer.packing(p1);
		
		Pencil p2 = new Pencil();
		p2.setHardness("4B");
		packer.packing(p2);
		
		//지우개
		Eraser e1 = new Eraser();
		e1.setSize("Large");
		packer.packing(e1);
		
		//볼펜
		BallPointPen b1 = new BallPointPen();
		b1.setThickness(0.3);
		b1.setColor("black");
		packer.packing(b1);
		
		BallPointPen b2 = new BallPointPen();
		b2.setThickness(1.5);
		b2.setColor("red");
		packer.packing(b2);
		
		//자
		Ruler r1 = new Ruler();
		r1.setLength(30);
		r1.setShape("줄자");
		packer.packing(r1);
		
		//결과 확인
		packer.countPacking(0);
		packer.countPacking(1);
		packer.countPacking(2);
		packer.countPacking(3);
		packer.countPacking(4);
		
		출력-----------------------------------------------------------
		포장 전 검수 : HB 진하기 연필입니다. //packer.packing(p1);
		포장을 완료했습니다.
		포장 전 검수 : 4B 진하기 연필입니다. //packer.packing(p2);
		포장을 완료했습니다.
		포장 전 검수 : Large 사이즈 지우개입니다. //packer.packing(e1);
		포장을 완료했습니다.
		포장 전 검수 : black 색상 0.3mm 볼펜입니다. //packer.packing(b1);
		포장을 완료했습니다.
		포장 전 검수 : red 색상 1.5mm 볼펜입니다. //packer.packing(b2);
		포장을 완료했습니다.
		포장 전 검수 : 30cm 줄자입니다. //packer.packing(r1);
		포장을 완료했습니다.
		
		//packer.countPacking(0);
		=====================
		포장 결과
		=====================
		연필 2회
		지우개 1회
		볼펜 2회
		자 1회
		
		//packer.countPacking(1);
		=====================
		포장 결과
		=====================
		연필 2회
		
		//packer.countPacking(2);
		=====================
		포장 결과
		=====================
		지우개 1회
		
		//packer.countPacking(3);
		=====================
		포장 결과
		=====================
		볼펜 2회
		
		//packer.countPacking(4);
		=====================
		포장 결과
		=====================
		자 1회

		 */
		//포장하는 직원
		Packer packer = new Packer();
		
		//연필
		Pencil p1 = new Pencil();
		p1.setHardness("HB");
		packer.packing(p1);
		
		Pencil p2 = new Pencil();
		p2.setHardness("4B");
		packer.packing(p2);
		
		//지우개
		Eraser e1 = new Eraser();
		e1.setSize("Large");
		packer.packing(e1);
		
		//볼펜
		BallPointPen b1 = new BallPointPen();
		b1.setThickness(0.3);
		b1.setColor("black");
		packer.packing(b1);
		
		BallPointPen b2 = new BallPointPen();
		b2.setThickness(1.5);
		b2.setColor("red");
		packer.packing(b2);
		
		//자
		Ruler r1 = new Ruler();
		r1.setLength(30);
		r1.setShape("줄자");
		packer.packing(r1);
		
		//결과 확인
		packer.countPacking(0);
		packer.countPacking(1);
		packer.countPacking(2);
		packer.countPacking(3);
		packer.countPacking(4);
	}
}
