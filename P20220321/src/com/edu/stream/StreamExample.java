package com.edu.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

class Student implements Comparable<Student> {
	String name;
	String gender;
	int score;
	int point;

	// 생성자.
	public Student(String name, String gender, int score) {
		super();
		this.name = name;
		this.gender = gender;
		this.score = score;
	}

	public Student(String name, String gender, int score, int point) {
		super();
		this.name = name;
		this.gender = gender;
		this.score = score;
		this.point = point;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Student student) {
		// this 와 student 비교: this, student => 음수. 내림차순: 양수.
//		if(this.score < student.score) {
//			return -1000;
//		} else {
//			return 9000;
//		}
		return (this.score + this.point) - (student.score + student.point); // 60, 70=>음수.
	}

}

public class StreamExample {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("홍길동", "남자", 70));
		list.add(new Student("김순희", "여자", 80));
		list.add(new Student("김부식", "남자", 85));
		list.add(new Student("박한나", "여자", 88));
		// 평균구하기.
		int sum = 0, cnt = 0;
		double avg = 0;
		for (Student student : list) {
			if (student.gender.equals("남자")) {
				sum += student.score;
				cnt++;
			}
		}
		avg = sum / (double) cnt;
		System.out.println("컬렉션평균: " + avg);
		Stream<Student> stream = list.stream(); // 스트림생성.
		OptionalDouble od = stream//
				.filter((s) -> s.gender.equals("남자"))//
				.mapToInt(s -> s.score)//
				.average();
		avg = od.getAsDouble();
		System.out.println("스트림평균: " + avg);

//		stream.forEach((Student t) -> {
//			System.out.println("이름: " + t.name + ", 성별: " //
//					+ t.gender + ", 점수: " + t.score);
//		});
	}
}
