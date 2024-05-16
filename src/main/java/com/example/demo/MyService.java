package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class MyService {
	public ArrayList<Person> getPersonList() {
		ArrayList<Person> list = new ArrayList<>();
		// クレオパトラ
		list.add(new Person("Cleopatra", 39, "Egypt"));

		// アインシュタイン
		list.add(new Person("Albert Einstein", 76, "Germany"));

		// アイザック・ニュートン
		list.add(new Person("Isaac Newton", 84, "England"));

		// シェイクスピア
		list.add(new Person("William Shakespeare", 52, "England"));

		// マリー・キュリー
		list.add(new Person("Marie Curie", 66, "Poland"));
		
		return list;
	}
}
