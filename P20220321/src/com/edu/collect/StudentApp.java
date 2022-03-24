package com.edu.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {

	List<Student> list = new ArrayList<Student>();
	Scanner scn = new Scanner(System.in);

	// 생성자
	public StudentApp() {
		list.add(new Student(101, "권가희", 50, 60));
		list.add(new Student(102, "유해정", 70, 80));
		list.add(new Student(103, "이유빈", 90, 70));
		list.add(new Student(201, "유해정", 80, 90));
	}

	// 멤버클래스.
	class StudentServiceImpl implements StudentService {
		@Override
		public void insertStudent(Student student) {
			list.add(student); // 추가.
		}

		@Override
		public Student getStudent(int sno) { // 학생번호로 한건 조회.
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getStudentNo() == sno) {
					return list.get(i);
				}
			}
			return null;
		}

		@Override
		public List<Student> studentList() { // 전체 리스트.
			return list;
		}

		@Override
		public void modifyStudent(Student student) { // 수정.
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
			System.exit(0);
		}
	} // end of StudentServiceImpl

	public void execute() {
		StudentService service = new StudentServiceFile();
		// 메뉴: 1.추가 2.리스트 3.한건조회(학생번호) 4.수정 5.삭제 6.이름조회(이름) 9.종료
		while (true) {
			System.out.println("1.추가 2.리스트 3.한건조회 4.수정 9.종료");
			System.out.print("선택>> ");

			int menu = scn.nextInt();
			if (menu == 1) {
				// 학생정보 추가입력. : 학생번호, 이름, 영어, 국어점수.
				System.out.println("학생번호입력>>");
				int stuNo = scn.nextInt();
				System.out.println("학생이름입력>>");
				String name = scn.next();
				System.out.println("영어입력>>");
				int engScore = scn.nextInt();
				System.out.println("국어입력>>");
				int korScore = scn.nextInt();

				Student s1 = new Student(stuNo, name, engScore, korScore);
				service.insertStudent(s1);

			} else if (menu == 2) {
				List<Student> list = service.studentList();
				for (Student s : list) {
					System.out.println(s.toString());
				}

			} else if (menu == 3) { // 한건 조회.
				System.out.println("조회할 학생번호 입력>>");
				int studNo = scn.nextInt();
				Student student = service.getStudent(studNo);
				if (student == null) {
					System.out.println("조회된 결과가 없습니다.");
				} else {
					System.out.println(student.toString());
				}

			} else if (menu == 4) {
				System.out.println("수정할 학생번호입력>>");
				int stuNo = scn.nextInt();
				System.out.println("영어입력>>");
				int engScore = scn.nextInt();
				System.out.println("국어입력>>");
				int korScore = scn.nextInt();

				Student s1 = new Student(stuNo, null, engScore, korScore);
				service.modifyStudent(s1);
				System.out.println("처리가 완료되었습니다.");

			} else if (menu == 5) { // 삭제.

			} else if (menu == 6) { // 이름으로 여러건 조회.
				System.out.println("조회할 학생이름 입력>> ");
				String searchName = scn.next();

				List<Student> list = service.searchStudent(searchName);
				for (Student s : list) {
					System.out.println(s.toString());
				}

			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				service.saveToFile();
				break;
			}
		} // end of while()
		System.out.println("end of program");
	}
}
