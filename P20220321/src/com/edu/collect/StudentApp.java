package com.edu.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {

	// 필드.
	List<Student> list = new ArrayList<Student>();
	Scanner scn = new Scanner(System.in);

	// 생성자
	public StudentApp() {

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

		@Override
		public String checkResponsibility(String id, String pw) {
			// TODO Auto-generated method stub
			return null;
		}
	} // end of StudentServiceImpl

	// 메인기능 담당하는 execute()
	public void execute() {

		StudentService service = null;
//        service = new StudentServiceImpl();
//        service = new StudentServiceFile();
		service = new StudentServiceOracle();

		while (true) {
			System.out.println("사용자아이디와 비밀번호를 입력하세요.");
			System.out.println("ID>> ");
			String id = scn.next();
			System.out.println("PW>> ");
			String pw = scn.next();

			String result = service.checkResponsibility(id, pw);
			if (result == null) {
				System.out.println("사용권한이 없습니다.");
				continue;
			}
			if (result.equals("ADMIN")) {
				System.out.println("관리자 권한으로 입장.");
			} else if (result.equals("USER")) {
				System.out.println("사용자 권한으로 입장.");
			}
			break;
		}

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
				System.out.println("=========== 학생리스트 =============");
				System.out.println("  학생번호  학생명        영어     국어");
				System.out.println("==================================");
				for (Student s : list) {
					System.out.printf(s.showList(), s.getStudentNo(), s.getName(), s.getEngScore(), s.getKorScore());
				}
				System.out.println("==================================");

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
