package com.jdbc.quiz;

import java.util.Scanner;

public class QuizInput {

	private String num;
	
	public void input() {
		System.out.println("메뉴를 선택하세요"+"\n");
		System.out.println("1.고객리스트");
		System.out.println("2.제품리스트");
		System.out.println("3.주문리스트");
		Scanner scann = new Scanner(System.in);
		System.out.print("입력 :");
		setNum(scann.nextLine());
		getNum();
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
}
