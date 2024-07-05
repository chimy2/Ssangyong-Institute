package com.test.question.classproblem;

import java.util.regex.Pattern;

public class Employee {
	private String name;		//이름
	private String department;	//부서
	private String position;	//직책
	private String tel;			//연락처
	private Employee boss;		//직속상사
	
	//getter, setter 구현
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(!checkLen(name) || !checkKorean(name)) {
			return;
		}
		this.name = name;
	}

	private boolean checkKorean(String name) {
		char c;
		for(int i=0; i<name.length(); i++) {
			c = name.charAt(i);
			if(c < '가' || c > '힣') {
				return false;
			}
		}
		return true;
	}

	private boolean checkLen(String name) {
		if(name.length() >= 2 && name.length() <=5) {
			return true;
		}
		return false;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		String[] departments = { "영업부", "기획부", "총무부", "개발부", "홍보부" };
		
		for(int i=0; i<departments.length; i++) {
			if(departments[i].equals(department)) {
				this.department = department;
				return;
			}
		}
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		String[] positions = { "부장", "과장", "대리", "사원" };
		
		for(int i=0; i<positions.length; i++) {
			if(positions[i].equals(position)) {
				this.position = position;
				return;
			}
		}
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
//		1)
		String regExp = "010-\\d{4}-\\d{4}";
		
		if(Pattern.matches(regExp, tel)) {
			this.tel = tel;
		}
//		2)
		if(!tel.startsWith("010-") 
				|| tel.length() != 13 || !checkNumber(tel.substring(4))) {
			return;
		}
		this.tel = tel;
	}

	private boolean checkNumber(String nums) {
		char c;
		for(int i=0; i<nums.length(); i++) {
			if(i == 4) continue;
			c = nums.charAt(i);
			if(c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}

	public Employee getBoss() {
		return boss;
	}

	public void setBoss(Employee boss) {
		if(boss == null || this.department.equals(boss.department)) {
			this.boss = boss;
		}
	}

	public void info() {
		String result = "";
		result += String.format("[%s]\r\n", this.name);
		result += String.format("- 부서: %s\r\n", this.department);
		result += String.format("- 직위: %s\r\n", this.position);
		result += String.format("- 연락처: %s\r\n", checkNull(this.tel));
		result += String.format("- 직속상사: %s\r\n", checkNull(this.boss));
		
		System.out.println(result);
	}

	private String checkNull(Object obj) {
		if(obj == null) {
			return "없음";
		} else if(obj instanceof Employee) {
			Employee boss = (Employee) obj;
			return boss.getName();
		}
		return obj.toString();
	}
}
