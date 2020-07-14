package com.java.servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ListExam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Character> array = new ArrayList<Character>();
		
		for (int i=0; i<5; i++) {
			System.out.print(i + "번째 학점 입력: ");
			char ch = sc.next().charAt(0);
			array.add(ch);
		}
		
		for (int i=0; i<array.size(); i++) {
			char grade = array.get(i);
			System.out.println((i+1)+"번째 학점: ");
			switch(grade) {
			case 'A':System.out.println("4.0");break;
			}
		}
	}
		
}
