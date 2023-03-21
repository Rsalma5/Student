package org.Spring.student.StudentService;

import java.util.List;

import org.Spring.student.Model.Student;
import org.Spring.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService 
{
	@Autowired
	private StudentRepository studentRepository;
	public Student registerStudent(Student Student)
	{
		return studentRepository.save(Student);
	}
	
	public List<Student> getStudents()
	{
		return studentRepository.findAll();
		
	}
	public void deleteStudent(Integer id)
	{
		studentRepository.deleteById(id);
	}
	public Student updateStudent(Student student)
	{
		Integer id = student.getId();
		Student std = studentRepository.findById(id).get();
		std.setName(student.getName());
		std.setAddress(student.getAddress());
		std.setPerc(student.getPerc());
		return studentRepository.save(std);
	}
}
