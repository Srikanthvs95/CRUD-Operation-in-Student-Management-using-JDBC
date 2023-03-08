package com.abc.controller;

import com.abc.factory.StudentServiceFactory;
import com.abc.pojo.Student;
import com.abc.service.IStudentService;

public class StudentControllerimpl implements IStudentController {

	@Override
	public String save(Student student) {
		
		IStudentService studentService=StudentServiceFactory.getService();
		return studentService.save(student);
		
	}

	@Override
	public Student getById(int id) {
		IStudentService studentService=StudentServiceFactory.getService();
		return studentService.getById(id);
	}

	@Override
	public String updateById(Student student) {
		IStudentService studentService=StudentServiceFactory.getService();
		return studentService.updateById(student);
		
	}

	@Override
	public String deleteById(int id) {
		IStudentService studentService=StudentServiceFactory.getService();
		return studentService.deleteById(id);
		
	}

}
