package ch07.sec04.exam01;

public class Computer extends Calculator {
//	�޼ҵ� �������̵�
	
//	������ �� ��Ȯ�� �������̵��� �Ǿ����� üũ�� ��(���� ����)
	@Override
	public double areaCircle(double r) {
		System.out.println("Computer ��ü�� areaCircle() ����");
		return Math.PI * r * r;
	}
}