package com.abc.factory;

import com.abc.service.IStudentService;
import com.abc.service.StudentServiceImpl;

//Factory design Pattern code

public class StudentServiceFactory {
	
	private static IStudentService studentServiceImpl;
	
	static {
		studentServiceImpl = new StudentServiceImpl();
	}
	public static IStudentService getService() {
		return studentServiceImpl;
		
	}
}
