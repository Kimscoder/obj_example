package com.jdbc.quiz;

import com.jdbc.quiz.Quiz고객;
import com.jdbc.quiz.Quiz제품;
import com.jdbc.quiz.Quiz주문;
import com.jdbc.quiz.QuizInput;
public class QuizMain {

	public static void main(String[] args) throws Exception{
		
		QuizInput inp = new QuizInput();
		
		while(true) {
			inp.input();
			String a =inp.getNum();
			switch(a){
			case "1":/*
				Quiz고객 out1 = new Quiz고객();
				out1.output1();
				System.out.println();*/
				System.out.println(a);
				break;
				
			case "2":
				Quiz제품 out2 = new Quiz제품();
				out2.output2();
				System.out.println();
				break;
			case "3":
				Quiz주문 out3= new Quiz주문();
				out3.output3();
				System.out.println();
				break;
			}
			
		}
}

}
