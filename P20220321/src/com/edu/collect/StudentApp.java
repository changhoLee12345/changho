package com.edu.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {

	List<Student> list = new ArrayList<Student>();
	Scanner scn = new Scanner(System.in);

	class StudentServiceImpl implements StudentService {

		@Override
		public void insertStudent() {
			System.out.println("insert");
		}

		@Override
		public Student getStudent(int sno) {
			System.out.println("getstudent");

			return null;
		}

		@Override
		public List<Student> studentList() {
			System.out.println("studentLinst");
			return null;
		}

		@Override
		public void modifyStudent(Student student) {
			System.out.println("modify");

		}

	}

	public void execute() {
		StudentService service = new StudentServiceImpl();
		while (true) {
			// 메뉴: 1.추가 2.리스트 3.한건조회 4.수정 9.종료
			System.out.println("menu:");

			int menu = scn.nextInt();

			if (menu == 1) {
				service.insertStudent();

			} else if (menu == 2) {
				service.getStudent(1);

			} else if (menu == 3) {

			} else if (menu == 4) {

			} else if (menu == 9) {
				break;
			}
		}
		System.out.println("end of program");
	}
}
