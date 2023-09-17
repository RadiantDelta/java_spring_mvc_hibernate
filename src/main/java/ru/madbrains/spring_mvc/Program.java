package ru.madbrains.spring_mvc;

//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Program {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(CompanyConfig.class);
//
//       // ITCompany company = context.getBean("CompanyComponent", ITCompany.class);
//        ITCompany company = context.getBean(ITCompany.class);
//        System.out.println(company.getName());
//        System.out.println(company.getDirector());

        SpringApplication.run(Program.class, args);
    }
}
