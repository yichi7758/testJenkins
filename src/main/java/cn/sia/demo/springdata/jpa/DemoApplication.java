package cn.sia.demo.springdata.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import cn.sia.demo.springdata.jpa.domain.model.Person;
import cn.sia.demo.springdata.jpa.domain.repository.CompanyRepository;
import cn.sia.demo.springdata.jpa.domain.repository.DepartmentRepository;
import cn.sia.demo.springdata.jpa.domain.repository.PersonRepository;

import java.util.Date;
import java.text.SimpleDateFormat;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//@Bean
	CommandLineRunner demo(CompanyRepository cr, DepartmentRepository dr, PersonRepository pr) {
		return (args) -> {
			List<Person> people = pr.findByLastName("wang");

			System.out.println("DEBUG: start to print out names with last name : wang");
			people.forEach(person -> System.out.println(person.getName()));


			System.out.println("DEBUG: start to print out people whose birthday is earlier than 1985-01-01");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse("1985-01-01");

			System.out.println(date.toString());
			List<Person> p = pr.findByBirthdayBefore(date);
			p.forEach(person -> System.out.println(person.getName() + " " + person.getBirthday().toString()));

		};
	}
}
