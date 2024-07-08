package ch14.sec09.exam02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExecuteExample {
	public static void main(String[] args) {
//		1000개의 메일 생성
		String[][] mails = new String[1000][3];
		for(int i=0; i<mails.length; i++) {
			mails[i][0] = "admin@my.com";
			mails[i][1] = "member" + i + "@my.com";
			mails[i][2] = "신상품 입고";
		}
		
//		ExecutorService 생성
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
//		이메일을 보내는 작업 생성 및 처리 요청
		for(int i=0; i<1000; i++) {
			final int idx = i;
			executorService.execute(new Runnable() {

				@Override
				public void run() {
					Thread thread = Thread.currentThread();
					String from = mails[idx][0];
					String to = mails[idx][1];
					String content = mails[idx][2];
					System.out.println("[" + thread.getName() + "] " + from + " ==> " + to + ": " + content);
//					어떤 스레드가 어떤 이메일을 처리했는지 알 수 있도록 처리
				}
				
			});
		}
		
//		ExecutorService 종료
		executorService.shutdown();
		
		/*
		[pool-1-thread-2] admin@my.com ==> member1@my.com: 신상품 입고
		[pool-1-thread-2] admin@my.com ==> member5@my.com: 신상품 입고
		[pool-1-thread-3] admin@my.com ==> member2@my.com: 신상품 입고
		....
		[pool-1-thread-2] admin@my.com ==> member981@my.com: 신상품 입고
		[pool-1-thread-1] admin@my.com ==> member980@my.com: 신상품 입고
		[pool-1-thread-4] admin@my.com ==> member995@my.com: 신상품 입고
		 */
	}
}
