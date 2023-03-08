package com.abc.factory;

import com.abc.dao.IStudentDao;
import com.abc.dao.StudentDaoImpl;

// Factory design pattern code
public class StudentDaoFactory {
	
	private static IStudentDao StudentDaoImpl;
	
	static {
		StudentDaoImpl  = new StudentDaoImpl();
	}
	public static IStudentDao getDao() {
		return StudentDaoImpl;
		
	}
}
