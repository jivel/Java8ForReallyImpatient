package javaForImpatient.chapterOne;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChapterOne {
	
	public File[] assignmentTwo(File file) {
		return file.listFiles(fileName -> fileName.isDirectory());
		
		//With method expression
		//return file.listFiles(File::isDirectory);
		
		//Java 7 version
		/*return file.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		});*/
	}
	
	public File[] assignmentThree(File file) {
		return file.listFiles((dir, name) ->  name.endsWith(".project"));
		
		//Java 7 version
		/*return file.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".classpath");
			}
		});*/
	}
	
	public File[] assignmentFour(File file) {
		File[] fileNames = file.listFiles();
		
		Arrays.sort(fileNames, (one, two) -> {
			if (one.isDirectory() && two.isDirectory()) {
				return one.toString().compareTo(two.toString());
			} else if (one.isFile() && two.isFile()) {
				return one.toString().compareTo(two.toString());
			} else if (one.isDirectory() && two.isFile()) {
				return -1;
			} else {
				return 1;
			}
		});
		
		return fileNames;
	}
	
	public void assignmentEight() {
		
		String[] names = { "Peter", "Paul", "Mary" };
		List<Runnable> runners = new ArrayList<>();
		
		for (String name : names)
			runners.add(() -> System.out.println(name)); 
		/*
		 * The following for loop prints :
		 * 
		 * Mary
		 * Peter
		 * Paul
		 * 
		 *  That means all the lambda expressions received
		 *  different values from the names list.
		 */
		for (Runnable runner : runners) {
			new Thread(runner).start();
		}	
		
		/*
		 * The following piece of code doesn't compile. Because
		 * in a lambda expression, you can only use variables 
		 * whose value doesn't change. Here value of the
		 * variable "i" is changing.
		 */
		//for (int i=0; i < names.length; i++)
		//	runners.add(() -> System.out.println(names[i])); 
	}
	
	//Assignment 7
	public static Runnable andThen(Runnable one, Runnable two) {
		return () -> {
			one.run();
			two.run();
		};
	}


	public static void main(String[] args) {
		ChapterOne obj = new ChapterOne();
		
		File file = new File("/vssexclude/Test/workspace/Test/parent");
		
		//Assignment 2
		//File[] names = obj.assignmentTwo(file);
		
		//Assignment 3 
		//File[] names = obj.assignmentThree(file);
		
		//Assignment 4
		/*File[] names = obj.assignmentFour(file);
		
		for (File name : names) {
			System.out.println(name.toString());
		}*/
		
		//Assignment 7
		//new Thread(andThen(() -> System.out.println("a"), () -> System.out.println("b"))).start();
		
		//Assignment 8
		obj.assignmentEight();
		
		//Assignment 11
		//I.f();
		J.f();
		//No such method f() in K. Compilation error.
		//K.f();
		
		/*
		 * f() is defined in S and I. But not in R
		 * The following invocation results in
		 * java.lang.IllegalAccessError
		 */
		I i = new R();
		i.f();
	}
}
