package javaForImpatient.chapterOne;

public class AssignmentSix {
	
	public static Runnable uncheck(RunnableEx runner) {
		return () -> {
			try {
				runner.run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}
	
	public static void main(String args[]) {
		System.out.println(Thread.currentThread().getName() + " - yyyy");
		new Thread(uncheck(
				() -> {
					System.out.println(Thread.currentThread().getName() + " - zzzz" );
					Thread.sleep(1000);
				}
				)).start();
	}
}
