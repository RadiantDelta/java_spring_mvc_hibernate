package ru.madbrains.spring_mvc.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.madbrains.spring_mvc.company.ITCompany;
import ru.madbrains.spring_mvc.company.employer.Developer;
import ru.madbrains.spring_mvc.company.employer.Employee;
import ru.madbrains.spring_mvc.company.employer.ITRole;
import ru.madbrains.spring_mvc.company.employer.PM;


import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    //@Qualifier("RequestScopedCompany")
    //@Qualifier("SessionScopedCompany")
    private ITCompany company;

    //@PersistenceContext
    //EntityManager entityManager;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ITCompany getCompany() {

        return company;
    }

    @Override
    @Transactional
    public void addDeveloper(Developer developer) {

      //  company.getEmployers().add(developer);
        entityManager.persist(developer);
        entityManager.detach(developer);
        developer.setAge(30);
        developer.setRole(ITRole.QA);
        //entityManager.merge(developer);
        // entityManager.flush();
    }

    @Override
    public void addPM(PM pm) {
        company.getEntities().add(pm);
    }

    @Override
    public List<Employee<ITRole>> getEmployersByRole(ITRole role) {
        List<Employee<ITRole>> employees = company.getEntities().stream()
                .filter(employer -> employer.getRole().equals(role))
                .collect(Collectors.toList());
        return employees;
    }

    @Override
    @Transactional
    public Employee<ITRole> getEmployerByIndex(int index) {
    //    Employer<ITRole> employer = company.getEntities().get(index);
    //    return employer;
        Developer developer = entityManager.find(Developer.class, index);
        log.info("persistence contains object " + entityManager.contains(developer));
         entityManager.detach(developer); //обезопасим
        log.info("persistence contains object " + entityManager.contains(developer));
        return developer;
    }
}
