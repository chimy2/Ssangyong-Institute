package ch07.sec02;

public class SmartPhoneExample {
	public static void main(String[] args) {
//		SmartPhone ��ü ����
		SmartPhone myPhone = new SmartPhone("������", "����");
		
//		Phone���κ��� ��ӹ��� �ʵ� �б�
		System.out.println("��: " + myPhone.model);
		System.out.println("����: " + myPhone.color);
		
//		SmartPhone�� �ʵ� �б�
		System.out.println("�������� ����: " + myPhone.wifi);
		
		
//		Phone���κ��� ��ӹ��� �޼ҵ� ȣ��
		myPhone.bell();
		myPhone.sendVoice("��������.");
		myPhone.receiveVoice("�ȳ��ϼ���! ���� ȫ�浿�ε���.");
		myPhone.sendVoice("��~ ��, �ݰ����ϴ�.");
		myPhone.hangUp();
		
//		SmartPhone�� �޼ҵ� ȣ��
		myPhone.setWifi(true);
		myPhone.internet();
		/*
		��: ������
		����: ����
		�������� ����: false
		���� �︳�ϴ�.
		�ڱ�: ��������.
		����: �ȳ��ϼ���! ���� ȫ�浿�ε���.
		�ڱ�: ��~ ��, �ݰ����ϴ�.
		��ȭ�� �����ϴ�.
		�������� ���¸� �����߽��ϴ�.
		���ͳݿ� �����մϴ�.
		*/
	}
}
