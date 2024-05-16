package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@Autowired
	MyService service;

	@Autowired
	private PersonService personService;

	@Autowired
	private IdeaService ideaService;

	@Autowired
	private IdeaThemeService ideaThemeService;

	private static final Logger logger = LoggerFactory.getLogger(MyController.class);

	@GetMapping("/")
	public String getHome(Model model) {
		model.addAttribute("morning", "Good morning");
		model.addAttribute("afternoon", "Hello");
		model.addAttribute("night", "Good night");

		Person p = new Person();
		p.setName("徳川家康");
		p.setAge(18);

		model.addAttribute("person", p);

		return "home";
	}

	@GetMapping("/contact")
	public String getContact() {
		return "contact";
	}

	//	@GetMapping("/idea")
	//	public String getIdea() {
	//		return "idea";
	//	}

	@PostMapping(value = "/idea", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String idea(@RequestBody IdeaForm form) {
		String ideaText = form.getIdea();
		String title = "適当なタイトル";
		System.out.println("Received idea: " + ideaText); // コンソールに出力

		// アイディアを保存
		ideaService.saveIdea(title, ideaText);

		return ideaText;
	}

	// すべてのアイディアテーマを取得
	@GetMapping("/idea")
	public String getThemes(Model model) {
		List<IdeaTheme> themes = ideaThemeService.getAllThemes();
		model.addAttribute("themes", themes);
		for (IdeaTheme theme : themes) {
			System.out.println(theme.getTitle()); // コンソールに出力	
		}
		return "idea"; // Thymeleafテンプレート名
	}
	
	 @GetMapping("/themes")
	    public String getAllThemes(Model model) {
	        List<IdeaTheme> themes = ideaThemeService.getAllThemes();
	        model.addAttribute("themes", themes);
	        return "idea";
	    }

	
	

	//	アイディアテーマの追加
	@PostMapping("/themes")
	@ResponseBody
	public IdeaTheme addIdeaTheme(@RequestBody IdeaTheme newTheme) {
		System.out.println("akfjwlkjfoiajwoijwa");
		System.out.println(newTheme.toString());
		return ideaThemeService.addTheme(newTheme);
	}

	// アイディアテーマの削除
	@DeleteMapping("/themes/{id}")
	@ResponseBody
	public String deleteIdeaTheme(@PathVariable int id) {
		try {
			ideaThemeService.deleteTheme(id);
			return "アイディアテーマが削除されました";
		} catch (Exception e) {
			logger.error("Error deleting idea theme", e);
			return "削除に失敗しました";
		}
	}
	
	
	@GetMapping("/search")
    public String searchThemes(@RequestParam("query") String query, Model model) {
        List<IdeaTheme> themes = ideaThemeService.searchThemes(query);
        model.addAttribute("themes", themes);
        return "idea";
    }
	
	

	@GetMapping("/persons")
	public String getPersons(Model model) {
		List<Person> persons = personService.getAllPersons();
		model.addAttribute("persons", persons);
		return "persons";
	}

	@GetMapping("/users/{name}")
	public String getUsers(@PathVariable String name, Model model) {
		System.out.println("name = " + name);
		model.addAttribute("message", name + "さん、こんにちは！");
		return "hello";
	}

	@GetMapping("/sample1_input")
	public String sample1_Input(Model model) {
		model.addAttribute("title", "入力画面1です。");
		return "sample1_input";
	}

	@GetMapping("/sample1_result")
	public String sample1_Result(@RequestParam String paramA, @RequestParam String paramB, @RequestParam String paramC,
			Model model) {
		model.addAttribute("paramA", paramA);
		model.addAttribute("paramB", paramB);
		model.addAttribute("paramC", paramC);
		return "sample1_result";
	}

	@GetMapping("/sample2_input")
	public String sample2_input(Model model) {
		model.addAttribute("title", "入力画面2です。");
		return "sample2_input";
	}

	@PostMapping("/sample2_result")
	public String sample2_result(ThreeTextForm form, Model model) {
		System.out.println("paramA : " + form.getParamA());
		System.out.println("paramB : " + form.getParamB());
		System.out.println("paramC : " + form.getParamC());
		model.addAttribute("form", form);
		return "sample2_result";
	}

	@GetMapping("/sample3_input")
	public String sample3_input(Model model) {
		model.addAttribute("title", "入力画面3です。");
		model.addAttribute("form", new ThreeTextForm_Validated());
		return "sample3_input";
	}

	@PostMapping("/sample3_result")
	public String sample3_result(@Validated @ModelAttribute("form") ThreeTextForm_Validated form,
			BindingResult bindingResult, Model model) {

		System.out.println("paramA : " + form.getParamA());
		System.out.println("paramB : " + form.getParamB());
		System.out.println("paramC : " + form.getParamC());

		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "入力画面3の再入力です。");
			model.addAttribute("form", form);
			return "sample3_input";
		}

		model.addAttribute("form", form);

		return "sample3_result";
	}

	@GetMapping("/personList")
	public String getPersonLIst(Model model) {
		model.addAttribute("list", service.getPersonList());
		return "personList";
	}
	
    @GetMapping("/use_restapi")
    public String index() {
        return "use_restapi"; // templates/weather.html を返す
    }

}
