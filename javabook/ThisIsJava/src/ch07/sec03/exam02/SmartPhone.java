package ch07.sec03.exam02;

public class SmartPhone extends Phone {
//	�ڽ� ������ ����
	public SmartPhone(String model, String color) {
		super(model, color);
//		�θ� Ŭ������ �⺻ �����ڰ� ���� �Ű������� ���� �����ڸ� �����Ƿ�
//		������ �Ұ����ϴ� > �ݵ�� �ۼ��ؾ� ��
		System.out.println("smartPhone(String model, String color) ������ �����");
	}
}
