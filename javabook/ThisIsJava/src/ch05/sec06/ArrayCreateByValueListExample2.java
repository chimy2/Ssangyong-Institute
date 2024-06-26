package ch05.sec06;

public class ArrayCreateByValueListExample2 {
	public static void main(String[] args) {
//		배열 변수 선언
		int[] scores;
//		배열 변수에 배열을 대입
//		선언한 시점이 아닐 때 값을 변경하고 싶으면 무조건 new 타입[]{} 이렇게 값을 변경해야한다
//		 > {} 그냥 이런식으로는 변경할 수 없음
		scores = new int[] {83, 90, 87};
//		Array constants can only be used in initializers
//		scores = {83, 90, 87};
		
//		배열 항목의 총합을 구하고 출력
		int sum1 = 0;
		for (int i=0; i<3; i++) {
			sum1 += scores[i];
		}
		System.out.println("총합 : " + sum1);
		
//		배열을 매개값으로 주고, printItem() 메소드 호출
		printItem(new int[] {83, 90, 87});
		/*
		총합 : 260
		score[0]: 83
		score[1]: 90
		score[2]: 83
		*/
	}

//	printItem() 메소드 선언
	public static void printItem(int[] scores) {
//		매개변수가 참조하는 배열의 항목을 출력
		for(int i=0; i<3; i++) {
			System.out.println("score[" + i + "]: " + scores[i]);
		}
	}
}
