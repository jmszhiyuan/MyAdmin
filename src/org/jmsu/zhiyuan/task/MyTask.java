package org.jmsu.zhiyuan.task;

public class MyTask implements Runnable {

	public MyTask() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		System.out.println("每隔10秒执行一次......");
	}

}
