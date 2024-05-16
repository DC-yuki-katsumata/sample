package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	IdeaRepository ideaRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("コマンドラインランナー");
//
//		Person p1 = new Person("織田信長", 18, "安土城");
//		Person p2 = new Person("豊臣秀吉", 15, "大阪城");
//		Person p3 = new Person("徳川家康", 10, "江戸城");
//
//		personRepository.save(p1);
//		personRepository.save(p2);
//		personRepository.save(p3);
//
//		 List<Person> list = personRepository.findByNameContaining("家");
//		
//		// 名前を変更
////		for (Person p : list) {
////			if (p.getName().equals("徳川家康")) {
////				p.setName("竹千代");
////				personRepository.save(p);
////			}
////		}
//
//		for (Person p : list) {
//			// インスタンスを文字列として表示
//			System.out.println(p.toString());
//		}
//
//		personRepository.save(p1);
//		personRepository.save(p2);
//		personRepository.save(p3);


        // Ideaインスタンスの作成と保存
        Idea i1 = new Idea("新しいエコ素材", LocalDateTime.now(), "竹を使った紙袋がいいと思います。");
        Idea i2 = new Idea("再生可能エネルギー", LocalDateTime.now(), "風力発電の効率を上げる方法を研究する。");
        Idea i3 = new Idea("プラスチック削減", LocalDateTime.now(), "生分解性プラスチックの利用を促進する。");
        Idea i4 = new Idea("水資源管理", LocalDateTime.now(), "雨水の再利用システムを導入する。");
        Idea i5 = new Idea("都市農業", LocalDateTime.now(), "都市内の空き地で野菜を栽培するプロジェクト。");

        ideaRepository.save(i1);
        ideaRepository.save(i2);
        ideaRepository.save(i3);
        ideaRepository.save(i4);
        ideaRepository.save(i5);

		System.out.println("コマンドラインランナーを実行しました。");
	}

}
