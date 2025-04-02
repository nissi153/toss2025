package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

//@SpringBootApplication : 3가지의 어노테이션을 합쳐논 것
//  : 기본적인 스프링부트 앱 개발환경과 설정을 다 해준다.
//1. @ComponentScan : @Component가 붙은 클래스를 찾아서 Bean으로 등록한다.
//2. @EnableAutoConfiguration : 스프링 프레임워크의 기본적인 기능을 활성화할 때
//                              사용하는 어노테이션이다.
//3. @SpringBootConfiguration : @Configuration이 붙은 클래스를 스프링 프레임워크의
//                              설정 클래스로 등록한다.

// Bean(빈) : 스프링 프레임워크에서 관리하는 자바 클래스 객체를 의미.
//   싱글톤이며 같은 이름의 빈은 선언불가, 첫글자는 영문소문자임. 예) studentScore

//클래스를 빈을 만드는 어노테이션 2가지
//@Bean와 @Component의 차이
//1.@Bean은 Config클래스 안에서 사용되고, 주로 외부 라이브러리 사용시(개발자 제어불가) 사용.
//2.@Component는 주로 개발자가 직접 작성한 클래스에 사용.

@Configuration
class MyConfig { //웹 애플리케이션의 설정 정보를 담는 클래스이다.
	@Bean
	public Student student() {
		System.out.println("bean 생성됨.");
		return new Student();
	}
}
class Student {
	String name = "HONG";
}

@SpringBootApplication
public class Ex01FirstAppApplication {

	public static void main(String[] args) {
		System.out.println("Hello Springboot!");

		//스프링 컨테이너에 등록된 빈(객체)를 사용해 보자.
		ApplicationContext context =
				new AnnotationConfigApplicationContext(MyConfig.class);
		Student obj = (Student) context.getBean("student");
		System.out.println( obj.name );

		//스프링 컨테이너에 등록된 빈 목록을 출력해보자.
		String[] beanDefinionNames = context.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinionNames));

		SpringApplication.run(Ex01FirstAppApplication.class, args);
	}

}
