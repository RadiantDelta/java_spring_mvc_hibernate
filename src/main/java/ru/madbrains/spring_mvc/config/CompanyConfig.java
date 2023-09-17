package ru.madbrains.spring_mvc.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import ru.madbrains.spring_mvc.company.ITCompany;
import ru.madbrains.spring_mvc.company.employer.Employee;
import ru.madbrains.spring_mvc.company.employer.ITRole;

@Slf4j
@Configuration
@ComponentScan("ru.madbrains.spring_mvc.company")
public class CompanyConfig {
    @Bean
    @Primary
    public ITCompany getITCompany(Employee<ITRole> director) {
        ITCompany company = new ITCompany("MadBrains2");
        company.setDirector(director);
        return company;
    }

    @Bean("RequestScopedCompany")
    @RequestScope
    public ITCompany getRequestScopedCompany(Employee<ITRole> director) {
        log.info("create request scoped bean");
        ITCompany company = new ITCompany("MadBrains2");
        company.setDirector(director);
        return company;
    }

    @Bean("SessionScopedCompany")
    @SessionScope
    public ITCompany getSessionScopedCompany(Employee<ITRole> director) {
        //log.info("create session scoped bean");
        ITCompany company = new ITCompany("MadBrains2");
        company.setDirector(director);
        return company;
    }

    @Bean("PrototypeScopedCompany")
    @Scope("prototype")
    public ITCompany getPrototypeScopedCompany(Employee<ITRole> director) {
        log.info("create prototype scoped bean");
        ITCompany company = new ITCompany("MadBrains2");
        company.setDirector(director);
        return company;
    }

    @Bean
    public ITCompany getAnotherITCompany() {
        return new ITCompany("SomeCompany");
    }

    @Bean
    public Employee<ITRole> getDirector(){
        return new Employee<>("Oleg", 30, ITRole.Director) {
            @Override
            public void work() {
                System.out.println(this.getName() + " is directing");
            }
        };
    }

    @Bean("CompanyName")
    public String getCompanyName() {
        return "MadBrains";
    }

    @Bean("MaxEmployerCount")
    public int getCount() {
        return 100;
    }
}
