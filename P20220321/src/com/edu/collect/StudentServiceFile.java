package com.edu.collect;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class StudentServiceFile implements StudentService {

	List<Student> students;

	public StudentServiceFile() {
		File file = new File("student.dat");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			bis.read(null)
			
			fis.close();
			bis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void insertStudent(Student student) {

	}

	@Override
	public Student getStudent(int sno) {
		return null;
	}

	@Override
	public List<Student> studentList() {
		return null;
	}

	@Override
	public void modifyStudent(Student student) {

	}

}
