package ru.madbrains.spring_mvc.service;

import ru.madbrains.spring_mvc.company.ITCompany;
import ru.madbrains.spring_mvc.company.employer.Developer;
import ru.madbrains.spring_mvc.company.employer.Employee;
import ru.madbrains.spring_mvc.company.employer.ITRole;
import ru.madbrains.spring_mvc.company.employer.PM;

import java.util.List;

public interface CompanyService {

    ITCompany getCompany();
    void addDeveloper(Developer developer);
    void addPM(PM pm);
    List<Employee<ITRole>> getEmployersByRole(ITRole role);
    Employee<ITRole> getEmployerByIndex(int index);


}
