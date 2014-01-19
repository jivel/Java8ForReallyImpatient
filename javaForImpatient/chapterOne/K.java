package javaForImpatient.chapterOne;

/*
 * Associated with assignment eleven.
 */
public class K implements I, J {

	/*
	 * If f() is abstract in I, J, no issues.
	 * K has the implementation.
	 */	
	/*@Override
	public void f() {

	}*/
	
	/*
	 * If f() is a default method in I.J,
	 * the compilation fails for K until and unless
	 * K has it's own implementation.
	 */
	/*public void f() {
		
	}*/

}
