package lm.solution.boot;

import lm.solution.boot.config.AuthorSettings;
import lm.solution.boot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * spring boot 入口类
 * */
@Controller
/**
 * @SpringBootApplication 是 Spring Boot 项目的核心注解，
 * 主要目的是开启自动配置
 *
 * @SpringBootApplication 组合以下注解：
 * @Configuration
 * @EnableAutoConfiguration
 * @ComponentScan
 *
 * @EnableAutoConfiguration 让 spring boot 根据类路径中的 jar 包为当前项目进行自动配置
 *
 * Spring Boot 会自动扫描 @SpringBootApplication 所在类的同级包以及下级包中的 bean
 * */
@SpringBootApplication
public class Application {

	@Value("${book.author}")
	private String bookAuthor;
	@Value("${book.name}")
	private String bookName;

	@Autowired
	private AuthorSettings authorSettings;

	@RequestMapping("/")
	@ResponseBody
	public String index() {

		return "author name is "+authorSettings.getName()+" and author age is "+authorSettings.getAge();
		//return "book name is:" + bookName + " and author is:" + bookAuthor;
		//return "Hello Spring Boot";

	}

	@RequestMapping("/person")
	public String person(Model model){
		Person single = new Person("aa",11);

		List<Person> people=new ArrayList<>();
		Person p1 = new Person("xx",11);
		Person p2 = new Person("yy",22);
		Person p3 = new Person("zz",33);
		people.add(p1);
		people.add(p2);
		people.add(p3);

		model.addAttribute("singlePerson",single);
		model.addAttribute("people",people);

		return "index";
	}

	/**
	 * 这是一个标准的 java main 方法，
	 * 主要作用是作为项目启动的入口
	 */
	public static void main(String[] args) {

		// 启动 spring boot 应用项目
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);

	}

}
