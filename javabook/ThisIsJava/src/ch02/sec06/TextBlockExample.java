package ch02.sec06;

public class TextBlockExample {
	public static void main(String[] args) {
//		Java13 부터 지원하는 텍스트 블록 문법
//		큰따옴표 3개로 감싸면이스케이프하거나 
//		라인피드 할 필요 없이 작성된 그대로 문자열 저장
//		Java14 부터 텍스트 블록에서 \를 붙여주면 줄바꿈을 하더라도 개행되지 않는다
		String str1 = "" + 
				"{\n" + 
				"\t\"id\":\"winter\",\n" +
				"\t\"name\":\"눈송이\"\n" +
				"}";
		String str2 = """
			{
					"id":"winter",
					"name":"눈송이"
			}
				""";
		System.out.println(str1);
		System.out.println("-------------------------------------");
		System.out.println(str2);
		System.out.println("-------------------------------------");
		String str = """
				나는 자바를 \
				학습합니다.
				나는 자바 고수가 될 겁니다.
				""";
		System.out.println(str);
	}
}
