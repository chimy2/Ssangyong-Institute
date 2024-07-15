package com.lesson.java;
/*


# Java

## 수업 폴더

수업에서 사용할 폴더를 생성합니다.

- C:\class\code > 소스(파일) 저장 폴더
- C:\class\dev > 설치 프로그램 폴더
- C:\class\code\java > 자바 수업 폴더(Workspace)


---


## Java 개요

### Java 개발 환경 구성(설치)

- JRE, Java Runtime Environment, 자바 실행 환경
	- 자바로 만든 프로그램이 실행할 수 있는 여러가지 환경을 제공한다.
- JDK, Java Development Kit, 자바 개발 도구(SDK)
	- 자바를 사용해서 프로그램을 만드는데 필요한 도구들을 제공한다.


### JDK 종류

- Oracle JDK
- Oracle OpenJDK
- AdoptOpenJDK
- Rad Hat OpenJDK
- AWS Corretto JDK


### JDK 버전(=Java 버전)
- 1.0 ~ 22
- JDK 11 > JDK 17
- JDK 8, JDK 11, JDK 17, JDK 21 > LTS, Long Term Support 버전


### JDK 설치

- https://www.oracle.com/kr/java/technologies/javase/jdk11-archive-downloads.html
- Java SE Development Kit 11.0.22 > Windows x64 Installer > jdk-11.0.22_windows-x64_bin.exe
- 수업에서 사용할 JDK 설치 경로
	- C:\class\dev\jdk-11
- C:\class\dev\jdk-11\bin > *.dll , *.exe > 프로그램(실행 파일)
	- javac.exe
	- java.exe
	- javaw.exe
	- javadoc.exe
	- jar.exe

### 설치 후 추가 설정(선택 > 되도록 권장)

- 환경 변수 등록 > Path
- 새 시스템 변수
	- 변수 이름: JAVA_HOME
	- 변수 값: C:\class\dev\jdk-11
- Path > 새로 만들기 > %JAVA_HOME%\bin


> GUI(Graphic User Interface)
> CLI(Command Line Interface) 


---


## 개발 툴 설치

- 메모장 > 텍스트 편집기라면 모두 가능
- IDE, integrated development environment > 통합 개발 환경


### Java IDE

- Itellij > Community, Ultimate
- Visual Studio Code
- Eclipse
- Eclipse 다운로드
	- Eclipse 4.24 > 2022-06 버전
	- https://www.eclipse.org/downloads/packages/release/2022-06/r > Eclipse IDE for Enterprise Java and Web Developers > Windows x86_64

- Eclise & JDK 버전 참고
	- https://soif0180.tistory.com/entry/Eclipse-%EC%9D%B4%ED%81%B4%EB%A6%BD%EC%8A%A4-%EB%B2%84%EC%A0%84%EB%B3%84-%EC%A0%95%EB%B3%B4-%EB%B0%8F-JDK-%EC%B5%9C%EC%86%8C-%EC%9A%94%EA%B5%AC-%EB%B2%84%EC%A0%84



### Eclipse 설정
- 인코딩 설정
	- Window > Preference > "encoding" 검색 > UTF-8
- 폰트 > 가독성(***)
	- 나눔고딕코딩 > 네이버
	- D2Coding > 네이버
	- Consolas, Bitstream Sans Mono, JetBrains Mono 등..
	
	

---
	
	
## 오전에 했던 행동들.. > 메모장 사용

1. Hello.java 생성
- 코드 작성
- 산출물 > [소스 파일] > 텍스트 파일
	
2. $ javac.exe Hello.java
- 컴파일(Compile) > 1차 컴파일
- 산출물 > Hello.class > [실행 파일] > 프로그램
	
3. $ java.exe Hello
- 실행 > 2차 컴파일 > 기계어 번역 > 실행
- 산출물 > 없음 
	
	
## 오후에 했던 행동들.. > 이클립스 사용

1. Hello.java 생성
- 코드 작성

2. Ctrl + F11
- 1차 컴파일 + 2차 컴파일	
	







프로그래밍 구문
1. 자바는 대소문자 구분한다.(철저하게)
2. 공백 문자(스페이스, 탭, 개행) > 처리? > 자유롭다.



자바 소스파일 > 관리하기 위한 폴더 > 패키지(Package)

- com.test.java > Ex01.java

- com.test.java > Ex02_DataType.java

- com.test.java > Ex03_Variable.java

- com.test.java > Ex04_Variable.java

- com.test.java > Ex05_Escape.java



기본 입출력
- 콘솔 입출력, Console Input Output > IO
- 입력 장치 > 키보드
- 출력 장치 > 모니터

- com.test.java > Ex06_Output.java

- com.test.java > Test.java

- com.test.temp

- com.test.java > Ex07_Input.java

- com.test.java > Ex08_Error.java


형변환

- com.test.java > Ex09_Casting.java


연산자
- com.test.java > Ex10_Operator.java

- com.test.java > Ex11_Operator.java

- com.test.java > Ex12_Operator.java


메서드
- com.test.java > Ex13_Method.java

- com.test.java > Ex14_Method.java

- com.test.java > Ex15_Method.java

- com.test.java > Ex16_LocalVariable.java

- com.test.java > Ex17_Method.java

- com.test.java > Ex18_Method.java




- com.test.java > Ex19_DateTime.java


자바
- 제어문
- 배열(컬렉션)
- 클래스




제어문

- com.test.java > Ex20_If.java

- com.test.java > Ex21_Switch.java

- com.test.java > Ex22_For.java

- com.test.java > Ex23_While.java

- com.test.java > Ex24_For.java



달력 만들기 > 년, 월 > 2024.06

1. 해당 월 > 마지막 일? > 30일

2. 해당 월의 1일 > 무슨 요일? > 토


일	월	화	수	목	금	토
						1
2	3	4	5	6	7	8
9	10	11	12	13	14	15












새 패키지
- com.test.java.array
	- Ex25_Array.java
	- Ex26_Calendar.java
	- Ex27_String.java
	



주민등록번호

95 12 20 - 1 0215 4 7

9-남
0-여
1-남
2-여
3-남
4-여
5
6
7
8




	7  0  0  1  0  1  -  1  0  1  0  1  0  4
    x  x  x  x  x  x     x  x  x  x  x  x
1.  2  3  4  5  6  7     8  9  2  3  4  5

2.  14       5     7     8     2     4 = 40

3. 40 / 11 = 7(나머지)

4. 11 - 7 = 4(차)
   11 - 0 = 11 > 1
   11 - 1 = 10 > 0

	
	
	
	
패키지
- com.test.java.obj
	- Ex28_Class.java
	  

패키지
- com.test.java.obj.inheritance
	- Ex37_Inheritance.java


패키지
- com.test.java.collection
	- Ex50_ArrayList.java
	

패키지
- com.test.java.file
	- Ex54_File.java






*/
















