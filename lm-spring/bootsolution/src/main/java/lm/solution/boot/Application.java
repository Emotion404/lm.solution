package lm.solution.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot 入口类
 *
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

//	@Value("${book.author}")
//	private String bookAuthor;
//	@Value("${book.name}")
//	private String bookName;

//	@Value("${server.port}")
//	private Integer port;





	/**
	 * 这是一个标准的 java main 方法，
	 * 主要作用是作为项目启动的入口
	 */
	public static void main(String[] args) {

		// 启动 spring boot 应用项目
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);

	}

//	@Bean
//	public Connector httpConnector(){
//
//		Connector connector=new Connector("org.apache.coyote.httpll.HttpllNioProtocol");
//		connector.setScheme("http");
//		connector.setPort(8080);
//		connector.setSecure(false);
//		connector.setRedirectPort(port);
//		return connector;
//
//	}

//	@Bean
//	public EmbeddedServletContainerFactory servletContainerFactory(){
//
//		TomcatEmbeddedServletContainerFactory tomcat =new TomcatEmbeddedServletContainerFactory(){
//
//			@Override
//			protected void postProcessContext(Context context){
//
//				SecurityConstraint securityConstraint=new SecurityConstraint();
//				securityConstraint.setUserConstraint("CONFIDENTIAL");
//				SecurityCollection collection=new SecurityCollection();
//				collection.addPattern("/*");
//				securityConstraint.addCollection(collection);
//				context.addConstraint(securityConstraint);
//
//			}
//
//		};
//
//		tomcat.addAdditionalTomcatConnectors(httpConnector());
//		return tomcat;
//
//	}

}
