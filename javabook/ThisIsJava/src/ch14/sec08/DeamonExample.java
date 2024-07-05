package ch14.sec08;

public class DeamonExample {
	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		
		System.out.println("메인 스레드 종료");
		/*
		작업 내용을 저장함
		작업 내용을 저장함
		메인 스레드 종료
		*/
	}
}
