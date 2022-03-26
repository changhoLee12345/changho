package com.edu.collect;

import java.io.*;
import java.util.*;

public class StudentServiceFile implements StudentService {

	List<Student> list = new ArrayList<Student>();
	File file;

	@Override
	public void insertStudent(Student student) {
		list.add(student);
	}

	@Override
	public Student getStudent(int sno) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStudentNo() == sno) {
				return list.get(i);
			}
		}
		return null;
	}

	@Override
	public List<Student> studentList() {
		return list;
	}

	@Override
	public void modifyStudent(Student student) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStudentNo() == student.getStudentNo()) {
				list.get(i).setEngScore(student.getEngScore()); // 영어점수수정.
				list.get(i).setKorScore(student.getKorScore()); // 국어점수수정.
			}
		}
	}

	@Override
	public void removeStudent(int sno) {

	}

	@Override
	public List<Student> searchStudent(String name) {
		List<Student> searchList = new ArrayList<Student>();
		// 찾았다고 종료X
		for (int i = 0; i < list.size(); i++) {
			// 같은 이름이 있는지 찾아보고 있으면 searchList.add()
			if (list.get(i).getName().equals(name)) {
				searchList.add(list.get(i));
			}
		}
		return searchList;
	}

	@Override
	public void saveToFile() {
		// 작성했던 ArrayList<Student> list => 파일저장.
		try {
			FileWriter fw = new FileWriter("studentList.data");
			BufferedWriter bw = new BufferedWriter(fw);

			for (Student stud : list) {
				bw.write(stud.getStudentNo() + "," + stud.getName() //
						+ "," + stud.getEngScore() + "," + stud.getKorScore());
			}
			bw.close();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
