package com.abc.main;

import java.util.Scanner;

import com.abc.controller.IStudentController;
import com.abc.factory.StudentControllerFactory;
import com.abc.pojo.Student;

public class MainApp {

	public static void main(String[] args) {
		
		Scanner sc= null;
		String name, age, address, id=null;
		String status =null;
		IStudentController studentController =null;
		Student student=null;
		
		while(true) {
			System.out.println("Welcome to our Application");
			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("Enter the Choice: ");
			sc= new Scanner(System.in);
			int option =sc.nextInt();
			
			switch(option) {
			case 1: 
				//collecting the inputs
				System.out.println("Enter the name:: ");
				name=sc.next();
				System.out.println("Enter the age:: ");
				age=sc.next();
				System.out.println("Enter the address:: ");
				address=sc.next();
				
				//Sending the data to the controller using POJO
				student = new Student();
				student.setSname(name);
				student.setSage(Integer.parseInt(age));
				student.setSaddress(address);
				
				//pure Abstraction (hiding the internal just exposing the service name)
				studentController= StudentControllerFactory.getController();
			    status =studentController.save(student);
				System.out.println(status);
				
				break;
			case 2: 
				//Collecting the values
				System.out.println("Enter the the id:: ");
				id=sc.next();
				
				//pure Abstraction (hiding the internal just exposing the service name)
				studentController=StudentControllerFactory.getController();
				
				//invoking the controller to get the service
				Student stdRecord = studentController.getById(Integer.parseInt(id));
				
				if (stdRecord!=null) {
					System.out.println(stdRecord);
				} else {
					System.out.println("Record not avilable for the given id:: "+ id);
				}
				break;
			case 3: 
				//Collecting the values
				System.out.println("Enter the the id:: ");
				id=sc.next();
				
				//pure Abstraction (hiding the internal just exposing the service name)
				studentController=StudentControllerFactory.getController();
				
				//invoking the controller to get the service
				 stdRecord = studentController.getById(Integer.parseInt(id));
		
				 if (stdRecord!=null) {
					 
				// collecting  the input for updating the record
					System.out.print("CurrentName is:: "+stdRecord.getSname()+",  Enter the newName: ");
					String newName =sc.next();
					
					System.out.print("CurrentAddress is:: "+stdRecord.getSaddress()+",  Enter the newAddress: ");
					String newAddress =sc.next();
					
					System.out.print("CurrentAge is:: "+stdRecord.getSage()+",  Enter the newAge: ");
					String newAge =sc.next();
					
					//sending the updated POJO object details for Controller
					Student newStudent = new Student();
					
					newStudent.setSid(stdRecord.getSid());
					
					
					//Perform validation based on the input provide by the user
					//forName
					if(newName.equals("")|| newName==null) {
						newStudent.setSname(stdRecord.getSname());
					}else {
						newStudent.setSname(newName);
					}
					
					//ForAge
					if(newAge.equals("")|| newAge==null) {
						newStudent.setSage(stdRecord.getSage());
					}else {
						newStudent.setSage(Integer.parseInt(newAge));
					}
					
					//ForAddress
					if(newAddress.equals("")|| newAddress==null) {
						newStudent.setSaddress(stdRecord.getSaddress());
					}else {
						newStudent.setSaddress(newAddress);
					}
					
					System.out.println(newStudent);
					status =studentController.updateById(newStudent);
					System.out.println(status);
					
				 } 
				 else {
					System.out.println("Record not avilable for the Updation:: "+ id);
				 }
				 
				break;
			case 4: 
				//Collecting the values
				System.out.println("Enter the the id:: ");
				id=sc.next();
				
				//pure Abstraction (hiding the internal just exposing the service name)
				studentController=StudentControllerFactory.getController();
				
			    status =studentController.deleteById(Integer.parseInt(id));
				System.out.println(status);
			    
				break;
			default : 
				System.out.println("<<...Invalid choice....>>");
				System.out.println("Thanks for using application....");
				System.exit(0);
			}
			
		}
		
	}

}
