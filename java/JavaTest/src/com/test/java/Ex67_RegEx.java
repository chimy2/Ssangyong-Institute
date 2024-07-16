package com.test.java;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex67_RegEx {
	public static void main(String[] args) {
		/*
		 * 정규 표현식, Regular Expression
		 * - 정규식
		 * - "특정 패턴"을 가지는 문자열을 검색하는 도구
		 * 
		 * 정규 표현식 요소(문법)
		 * 
		 * 1. x
		 * 	- x는 임의의 문자 1개
		 * 	ex) a > a
		 * 	ex) abc > abc
		 * 	ex) 홍길동 > 홍길동
		 * 
		 * 2. .
		 * 	- 임의의 문자 1개(wildcard)
		 * 	ex) . > 문자 1개
		 * 	ex) .. > 문자 2개
		 * 	ex) a.c > abc, aac, acc, adc, aec, a1c, a홍c..
		 * 	ex) a..c > abbc, a12c, a가나c
		 * 
		 * 3. 출현횟수
		 * 	- 바로 앞의 문자(집합)의 출현 횟수를 표현
		 * 		3.1 생략
		 * 			- 바로 앞의 대상의 출현 횟수가 생략X, 중복X
		 * 			- 출현 횟수: 1
		 * 				ex) abc > abc
		 * 				ex) 홍길동 > 홍길동
		 * 
		 * 		3.2 ?
		 * 			- 바로 앞의 대상의 출현 횟수가 생략O, 중복X
		 * 			- 출현 횟수: 0 ~ 1
		 * 				ex) a?bc > abc, bc
		 * 				ex) 홍?길동 > 안녕~ 길동아~ 네 이름은 홍길동이지? 
		 * 				ex) 홍길?동 > 홍길동, 홍동
		 * 				ex) 홍길동? > 홍길동, 홍길
		 * 				ex) (자바)?코드 > 자바코드가 있습니다. 그런데 코드에 에러가 있어요.
		 * 				ex) a?a?abc > abc, aabc, aaabc
		 * 
		 * 		3.3 +
		 * 			- 바로 앞의 대생의 출현 횟수가 생략X, 중복O
		 * 			- 출현 횟수: 1 ~ 무한대
		 * 				ex) a+bc > abc, aabc, aaaaaaaaaabc, ..
		 * 				ex) 홍+길동 > 홍길동, 홍홍길동, ..
		 * 				ex) (자바)+코드 > 자바코드, 자바자바코드, ..
		 * 
		 * 		3.4 *
		 * 			- 바로 앞의 대생의 출현 횟수가 생략O, 중복O
		 * 			- 출현 횟수: 0 ~ 무한대
		 * 				ex) a*bc > bc, abc, aaaaaaaaaabc, ..
		 * 				ex) 홍*길동 > 길동, 홍길동, 홍홍길동, ..
		 * 				ex) (자바)+코드 > 코드, 자바코드, 자바자바코드, ..
		 * 
		 * 4. 선택, Choice
		 *  - 연산자(or) 역할
		 *  - [] 안에 문자 중 1개를 선택
		 *  	4.1 [열거값]
		 *  		ex) 제 나이는 12살입니다. 제동생은 10살이에요. 키는 160cm입니다. 몸무게는 50kg입니다.
		 *  			> 나이를 찾고 싶다 > [0-9]
		 *  			> 한글을 찾고 싶다 > [가-힣]
		 *  		ex) [홍김박최]길동 > 홍길동, 김길동, 박길동, 최길동
		 *  		ex) [홍김박최]?길동 > 길동, 홍길동, 김길동, 박길동, 최길동
		 *  		ex) [홍김박최]+길동 > 홍길동, 김길동, 박길동, 최길동, 박최길동
		 *  		
		 *  		🌟🌟🌟 []에서 연속된 문자(코드)를 간단하게 표현하는 방법
		 *  		ex) 숫자 > [0123456789] > [0-9]
		 *  		ex) 숫자 > [01236789] > [0-9](X) > [0-36-9](O)
		 *  		ex) 영어 소문자 > [abcdefghijklmnopqrstuvwxyz] > [a-z]
		 *  		ex) 영어 대문자 > [A-Z]
		 *  		ex) 영문자 > [A-Za-z], [a-zA-Z] > [A-z](X)
		 *  		ex) 한글 > [가-힣]
		 *  
		 *  		ex) 주민등록번호 > [0-9]{6}-[0-9]{7}
		 *  		ex) 전화번호 > 010-[0-9]{3,4}-[0-9]{4}
		 *  		ex) 홍씨 이름 세글자? > 홍길동, 홍순신, 홍재석, 홍아지, 홍양이 > 홍[가-힣]{2}
		 *  		ex) 영문자 + 숫자 > [A-Za-z0-9]
		 *  		ex) 영문자 + 숫자 + 한글 > [A-Za-z0-9가-힣]
		 *  		ex) 식별자 적합한 문자(영어 + 숫자 + _) > [A-Za-z0-9_]
		 *  
		 *  	4.2 [^열거값]
		 *  		- 4.1의 부정형
		 *  		- 열거값을 제외한 나머지 검색
		 *  		ex) [0-9]+ > [^0-9]+
		 * 
		 * 5. 출현횟수
		 * 	- 바로 앞의 문자(집합)의 출현 횟수를 표현
		 * 	- ?, +, * > 더 세밀한 패턴 지정이 가능
		 * 		5.1 {n}
		 * 			- n: 출현 횟수
		 * 			ex) a{1}bc > abc
		 * 			ex) a{2}bc > aabc
		 * 			ex) a{3}bc > aaabc
		 * 
		 * 		5.2 {n,m}
		 * 			- n: 최소 출현 횟수
		 * 			- m: 최대 출현 횟수
		 * 			ex) a{1,2}bc > abc, aabc
		 * 			ex) a{2,3}bc > aabc, aaabc
		 * 			ex) a{0,2}bc > bc, abc, aabc
		 * 
		 * 		5.3	{n,}
		 * 			- n: 최소 출현 횟수
		 * 			- m 생략: 무한대
		 * 			ex) a{1,}bc > abc, aabc, aaabc
		 * 			ex) a{0,}bc > bc, abc, aabc, aaabc
		 * 
		 * 			ex) a?bc > a{0,1}bc
		 * 			ex) a+bc > a{1,}bc
		 * 			ex) a*bc > a{0,}bc
		 * 
		 * 6. 처음과 끝 
		 * 	- 입력 컨트롤 or 입력 값 등을 대상으로 사용
		 * 		6.1 ^
		 * 			- 뒤의 표현으로 반드시 시작
		 * 			ex) ^홍길동 > str.startsWith("홍")
		 * 		6.2 $
		 * 			- 앞의 표현으로 반드시 끝
		 * 			ex) 홍길동$ > str.endsWith("동")
		 * 
		 * 7. 줄임표현
		 * 	7.1 \d or \D
		 * 		- Digital, 숫자
		 * 		- [0-9] == \d
		 * 		- [^0-9] == \D
		 * 		ex) [0-9]{6}-[0-9]{7} > \d{6}-\d{7} 
		 * 
		 * 	7.2 \w or \W
		 * 		- Word > 영어 대소문자 + 숫자 + _ 조합
		 * 		ex) [A-Za-z0-9_]{2,5} > \w{2,5}
		 * 		
		 * 	7.3 \s or \S
		 * 		- 공백 문자(스페이스, 탭, 엔터)
		 * 		ex) \s+
		 * 
		 */
		
//		m1();
//		m2();
//		m3();
//		m4();
//		m5();
		m6();
	}

	private static void m6() {
//		유효성 검사 > 회원가입 
//		1. 아이디 > 필수값, 4~12자 이내, 영문자+숫자+_, 숫자로 시작X
//		2. 암호 > 필수값, 4~12자 이내
//		3. 이름 > 필수값, 한글 2~5자 이내
//		4. 나이 > 필수값, 숫자 범위(1~120)
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("[회원가입");
		while(true) {
			System.out.print("아이디: ");
			String id = scan.nextLine();
			
			if(invalidId(id)) {	//유효성 검사 > 잘못된 것을 찾아라
				System.out.println("필수값, 4~12자 이내, 영문자+숫자+_, 숫자로 시작X");
			} else {
				break;
			}
		}
		while(true) {
			System.out.print("암호: ");
			String pw = scan.nextLine();
			
			if(invalidPw(pw)) {	//유효성 검사 > 잘못된 것을 찾아라
				System.out.println("필수값, 4~12자 이내");
			} else {
				break;
			}
		}
		while(true) {
			System.out.print("이름: ");
			String name = scan.nextLine();
			
			if(invalidName(name)) {	//유효성 검사 > 잘못된 것을 찾아라
				System.out.println("필수값, 2~5자 이내, 한글만");
			} else {
				break;
			}
		}
		while(true) {
			try {
				System.out.print("나이: ");
				int age = scan.nextInt();
				
				if(invalidAge(age)) {	//유효성 검사 > 잘못된 것을 찾아라
					System.out.println("필수값, 숫자만, 1~120");
				} else {
					break;
				}
			} catch (Exception e) {
				System.out.println("숫자를 입력하세요.");
			} finally {
				scan.nextLine();
			}
		}
		
		System.out.println("회원 가입 진행");
		System.out.println("완료");
	}

	private static boolean invalidAge(int age) {
		if(age < 1 || age > 120) {
			return true;
		}
		return false;
	}

	private static boolean invalidName(String name) {
		String regex = "^[가-힣]{2,5}$";
		Pattern p1 = Pattern.compile(regex);
		Matcher m1 = p1.matcher(name);
		
		return !m1.find();
	}

	private static boolean invalidPw(String pw) {
		if(pw == null || pw.equals("")) {
			return true;
		} if(pw.length() < 4 || pw.length() > 12) {
			return true;
		}
		return false;
	}

	private static boolean invalidId(String id) {
//		필수
//		4~12자 이내
//		영문자+숫자+_
//		숫자로 시작X
		
		String regex = "^[A-Za-z_][A-Za-z0-9_]{3,11}$";
		Pattern p1 = Pattern.compile(regex);
		Matcher m1 = p1.matcher(id);
		
		return !m1.find();
	}

	/*
	private static boolean invalidId(String id) {
//		필수
//		4~12자 이내
//		영문자+숫자+_
//		숫자로 시작X
		
		if(id == null || id.equals("")) {
			return true;
		} if(id.length() < 4 || id.length() > 12) {
			return true;
		}
		
		for(int i=0; i<id.length(); i++) {
			char c = id.charAt(i);
			
			if((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') 
					&& (c < '0' || c > '9') && c != '_') {
				return true;
			}
		}
		
		char c2 = id.charAt(0);
		if(c2 >= '0' || c2 <= '9') {
			return true;
		}
		
		return false;
	}
	*/

	private static void m5() {
		String txt = "안녕하세요. 홍길동입니다. 당신 이름도 길동이에요? 아~ 김길동이군요. "
				+ "저쪽에 최길동도 있어요. 그리고 남궁길동도 있습니다.";
//		요구사항] 모든 길동이 찾기!!
		String regex = "";
		
//		Pattern p1 = Pattern.compile("[홍김최(남궁)]길동");	//X
		Pattern p1 = Pattern.compile("(홍|김|최|남궁)(길동)");
		
		Matcher m1 = p1.matcher(txt);
		
		while(m1.find()) {
			System.out.println("찾은 이름: " + m1.group());
//			System.out.println("성: " + m1.group().substring(0, 1));
//			System.out.println("이름: " + m1.group().substring(1));
			System.out.println("성: " + m1.group(1));
			System.out.println("이름: " + m1.group(2));
			System.out.println();
		}
	}

	private static void m4() {
		String txt = "1970년대 초반에 발명되었다. 'E-mail'이라는 표현은 test@test.com1990년대에나 통용되기 시작했고, 전자 우편(electronic mail)이라는 용어는 팩스같이 전자기기를 통한 문서의 교환 방법에 구분 없이 사용되었기 때문에 이메일의 발명 시점을 정확히 집어서 말하긴 힘들다. 1969년 ARPANET이 만들어지면서 메시지들을 전송하려는 시도가 있었으며, 1971년에는 골뱅이(@) 문자를 사용하는 메일이 처음으로 보내졌고, 메일 규격을 표준화하려는 시도가 1973년 RFC 561 등으로부터 시작되었다. 현재 사용되는 것과 같은 메일 전송 규약인 SMTP의 첫 표준 RFC 821이 등장한 것은 1982년.\r\n"
				+ "\r\n"
				+ "간혹 인도계 미국인 소년 시바 아야두라이(V.A. Shiva Ayyadurai)가 1978년에 이메일을 최초로 발명했다고 하는 기사를 찾을 수 있으나#, 이는 당사자의 일방적인 주장으로, 이것을 보도했던 워싱턴 포스트에서도 정정보도를 낸 바 있다. 이메일의 최초 사용자라고 일반적으로 인정받는 사람은 ARPANET의 작업에 참여했던 레이 톰린슨이다. 인터넷은 원래 웹 서핑 하려고 만들어졌던 게 아니라, 문자정보를 주고 받기 위해 만들어진 네트워크였다. 즉, 이메일은 인터넷의 탄생 목적과 연관이 있다. 메일주소 중간에 @를 사용해서 사용자 계정 이름과 이메일 서버 이름을 구분하는 방식 역시 1971년에 인터넷의 전신인 ARPANET 시절 처음 등장했을 정도로 그 역사가 깊다.[2]\r\n"
				+ "\r\n"
				+ "국내에선 인터넷이 대중화되기 전,admin@google.com 그러니까 PC통신 시절에도 '전자 메일'이라는 이름으로 비슷한 게 있었지만 이 시절에는 서비스 제공자끼리 협조가 안 돼서 같은 서비스 가입자끼리만 주고받을 수 있었다는 점이 좀 다르다. (예: 이 프로그램을 사용하시다가 궁금하신 점이 있으면 천리안 namu0821이나 하이텔 namuking으로 메일 보내주세요.) 시간이 지나면서 인터넷이 대중화되자 이들 PC통신 서비스도 인터넷 이메일의 편지함을 자사의 전자메일과 연동시키는 방법으로 인터넷에서도 이메일을 주고받을 수 있도록 했다.";
		
//		이메일 주소 검색
		String regex = "(\\w+)@([a-zA-Z_]+?\\.[a-zA-Z]{2,3})";
				
//		정규식 사이트 > http://regexlib.com
		
		Pattern p1 = Pattern.compile(regex);
		
		Matcher m1 = p1.matcher(txt);
		
		while(m1.find()) {
			System.out.println(m1.group());
			System.out.println("아이디: " + m1.group(1));
			System.out.println("도메인: " + m1.group(2));
			System.out.println();
		}
	}

	private static void m3() {
//		자바 > 정규식 클래스 제공
		String txt = "안녕하세요. 홍길동입니다. 제 연락처는 010-1234-5678입니다. "
				+ "혹시 연락이 안되면 010-8765-9876로 연락주세요. 010-2345-0394입니다.";
		
//		txt 안에 전화번호가 포함되어 있는지?
		String regex = "[0-9]{3}-[0-9]{3,4}-[0-9]{4}";
		
//		정규 표현식 객체
		Pattern p1 = Pattern.compile(regex);
		
//		검색 + 결과
		Matcher m1 = p1.matcher(txt);
		/*
		System.out.println(m1.find());	//대상(txt)에서 정규식 패턴과 일치하는 부분을 발견했습니다.
		
		if(m1.find()) {
			System.out.println("txt내에서 전화번호를 발견O");
		} else {
			System.out.println("txt내에서 전화번호를 발견X");
		}
		*/
		int count = 0;
		while(m1.find()) {
			System.out.println("[전화번호 발견]");
			System.out.println("전화번호: " + m1.group());
			System.out.println();
			count++;
		}
		System.out.println("전화번호를 총 " + count + "회 발견했습니다.");
		
		regex = "([0-9]{3})-([0-9]{3,4})-([0-9]{4})";
		p1 = Pattern.compile(regex);
		m1 = p1.matcher(txt);
		
		while(m1.find()) {
			System.out.println("[전화번호 발견]");
			System.out.println("전화번호: " + m1.group());
			System.out.println("전화번호: " + m1.group(0));
			System.out.println("통신사: " + m1.group(1));	//괄호로 묶은 그룹을 순서대로 가져옴
			System.out.println("앞자리: " + m1.group(2));
			System.out.println("뒷자리: " + m1.group(3));
			System.out.println();
		}
	}

	private static void m2() {
		String names = "홍길동,아무개,강아지,고양이,병아리";
		
		String[] list = names.split(",");
		
		for(String name : list) {
			System.out.println(name);
		}
		System.out.println();
		
		names = "홍길동,아무개,강아지;고양이,병아리";
		
		for(String name : list) {
			if(name.contains(";")) {
				String[] sublist = name.split(";");
				System.out.println(Arrays.toString(sublist));
			} else {
				System.out.println(name);
			}
		}
		System.out.println();
		
		list = names.split("[,;/]");
		
		for(String name : list) {
			System.out.println(name);
		}
		System.out.println();
		
		names = "홍길동..아무개,강아지;고양이 병아리";
		
		list = names.split("[,;\\s.]+");
		for(String name : list) {
			System.out.println(name);
		}
		System.out.println();
		
	}

	private static void m1() {
//		자바 > 여러 메서드가 정규 표현식을 지원한다.
		
//		게시판 > 글쓰기 > 개인정보 마스킹
		String txt = "안녕하세요. 홍길동입니다. 제 연락처는 010-1234-5678입니다. "
				+ "혹시 연락이 안되면 010-8765-9876로 연락주세요.";
		
//		System.out.println(txt.replace("010-1234-5678", "XXX-XXXX-XXXX"));
		
		System.out.println(txt.replaceAll("[0-9]{3}-[0-9]{3,4}-[0-9]{4}", "XXX-XXXX-XXXX"));
		
		txt += " 010.2345.0394입니다.";
		System.out.println(
				txt
				.replaceAll("[0-9]{3}.[0-9]{3,4}.[0-9]{4}", "XXX-XXXX-XXXX")
				);
		
		System.out.println(txt.replaceFirst("[0-9]{3}-[0-9]{3,4}-[0-9]{4}", "XXX-XXXX-XXXX"));
	}
}
