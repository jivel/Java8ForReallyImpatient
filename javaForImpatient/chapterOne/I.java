package javaForImpatient.chapterOne;

/*
 * Associated with assignment eleven.
 */
public interface I {
	//void f();
	
	default void f() {
		System.out.println("I");
	}
	
	/*static void f() {
		System.out.println("K");
	}*/
}
