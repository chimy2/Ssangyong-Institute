package com.test.question.classproblem;

public class Packer {
	static int pencilCount;
	static int eraserCount;
	static int ballPoinPenCount;
	static int rulerCount;
	
	private final int ALLCONTENTS = 0;
	private final int PENCIL = 1;
	private final int ERASER = 2;
	private final int BALLPOINTPEN = 3;
	private final int RULER = 4;
	

	public void packing(Pencil pencil) {
		String[] grades = { "4B", "3B", "2B", "B", "HB", "H", "2H", "3H", "4H" };
		boolean check = false; 
		
		for(int i=0; i<grades.length; i++) {
			if(grades[i].equals(pencil.getHardness())) {
				check = true;
				break;
			}
		}
		
		if(check) {
			System.out.println("포장 전 검수 : " + pencil.info());
			pencilCount++;
			System.out.println("포장을 완료했습니다.");
		} else {
			System.out.println("포장 전 검수 : 잘못된 연필입니다.");
			System.out.println("포장에 실패했습니다.");
		}
	}

	public void packing(Eraser eraser) {
		String[] sizes = { "Large", "Medium", "Small" };
		boolean check = false; 
		
		for(int i=0; i<sizes.length; i++) {
			if(sizes[i].equals(eraser.getSize())) {
				check = true;
				break;
			}
		}
		
		if(check) {
			System.out.println("포장 전 검수 : " + eraser.info());
			eraserCount++;
			System.out.println("포장을 완료했습니다.");
		} else {
			System.out.println("포장 전 검수 : 잘못된 지우개입니다.");
			System.out.println("포장에 실패했습니다.");
		}
	}

	public void packing(BallPointPen ballPointPen) {
		double[] thicknesses = { 0.3, 0.5, 0.7, 1.0, 1.5 };
		String[] colors = { "red", "blue", "green", "black"};
		boolean check = false; 
		
		for(int i=0; i<thicknesses.length; i++) {
			if(thicknesses[i] == ballPointPen.getThickness()) {
				check = true;
				break;
			}
		}
		
		for(int i=0; i<colors.length; i++) {
			if(colors[i].equals(ballPointPen.getColor())) {
				check = true;
				break;
			}
		}
		
		if(check) {
			System.out.println("포장 전 검수 : " + ballPointPen.info());
			ballPoinPenCount++;
			System.out.println("포장을 완료했습니다.");
		} else {
			System.out.println("포장 전 검수 : 잘못된 볼펜입니다.");
			System.out.println("포장에 실패했습니다.");
		}
	}

	public void packing(Ruler ruler) {
		int[] lengths = { 30, 50 , 100 };
		String[] shapes = { "줄자", "운형자", "삼각자" };
		boolean check = false; 

		for(int i=0; i<lengths.length; i++) {
			if(lengths[i] == ruler.getLength()) {
				check = true;
				break;
			}
		}
		
		for(int i=0; i<shapes.length; i++) {
			if(shapes[i].equals(ruler.getShape())) {
				check = true;
				break;
			}
		}
		
		if(check) {
			System.out.println("포장 전 검수 : " + ruler.info());
			rulerCount++;
			System.out.println("포장을 완료했습니다.");
		} else {
			System.out.println("포장 전 검수 : 잘못된 자입니다.");
			System.out.println("포장에 실패했습니다.");
		}
	}

	public void countPacking(int type) {
		System.out.println("=====================");
		System.out.println("포장 결과");
		System.out.println("=====================");
		
		if(type == ALLCONTENTS) {
			System.out.printf("연필 %d회\n", pencilCount);
			System.out.printf("지우개 %d회\n", eraserCount);
			System.out.printf("볼펜 %d회\n", ballPoinPenCount);
			System.out.printf("자 %d회\n", rulerCount);
		} else if(type == PENCIL) {
			System.out.printf("연필 %d회\n", pencilCount);
		} else if(type == ERASER) {
			System.out.printf("지우개 %d회\n", eraserCount);
		} else if(type == BALLPOINTPEN) {
			System.out.printf("볼펜 %d회\n", ballPoinPenCount);
		} else if(type == RULER) {
			System.out.printf("자 %d회\n", rulerCount);
		}
		
		System.out.println();
	}



	
}
