package com.springboot.cruddemo;

import com.springboot.cruddemo.dao.StudentDAO;
import com.springboot.cruddemo.dao.StudentDAOImpl;
import com.springboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {

		System.out.println(studentDAO.deleteAll());
	}

	private void deleteStudent(StudentDAO studentDAO) {

		// get the id need to delete
		int studentID = 3;
		// delete
		studentDAO.delete(studentID);

	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		Student student = studentDAO.findById(1);

		// change first name to "Steven"
		student.setFirstName("Harry");

		// update the student
		studentDAO.update(student);

		// display the updated student
		System.out.println(student);


	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Huynh");

		// display list of students
		for(Student temp: theStudents){
			System.out.println(temp);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for(Student temp: theStudents){
			System.out.println(temp);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Read Student by Id");
		Student student = studentDAO.findById(1);

		System.out.println("ID: " + student.getId());
		System.out.println("first name: " + student.getFirstName());
		System.out.println("last name: " + student.getLastName());
		System.out.println("email: " + student.getEmail());
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create the Student object
		System.out.println("Creating multiple Student objects");
		Student tempStudent1 = new Student("Steven", "Huynh", "Steven@gmail.com");
		Student tempStudent2 = new Student("Dragon", "Leo", "Dragon@gmail.com");

		// save the student object
		System.out.println("Saving the Student Object");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);

		// display id of the saved student
		System.out.println("Saved Student ID: " + tempStudent1.getId());
		System.out.println("Saved Student ID: " + tempStudent2.getId());

	}

	private void createStudent(StudentDAO studentDAO) {

		// create the Student object
		System.out.println("Creating the Student object");
		Student tempStudent = new Student("Paul", "Doe", "Paul@gmail.com");

		// save the student object
		System.out.println("Saving the Student Object");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved Student ID: " + tempStudent.getId());


	}


}
