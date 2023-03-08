package com.abc.factory;

import com.abc.controller.IStudentController;
import com.abc.controller.StudentControllerimpl;

//Factory Design pattern code
public class StudentControllerFactory {
	
	private static IStudentController studentController;
	
	static {
		studentController=new StudentControllerimpl();
	}
	
	public static IStudentController getController() {
		return studentController;	
	}
}
