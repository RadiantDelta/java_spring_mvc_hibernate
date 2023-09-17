package ru.madbrains.spring_mvc.dto;

import lombok.Data;
import ru.madbrains.spring_mvc.company.ITCompany;
import ru.madbrains.spring_mvc.company.employer.Employee;
import ru.madbrains.spring_mvc.company.employer.ITRole;

import java.util.List;

@Data
public class CompanyDTO {//Data Transfer Object
    private String name;
    private Employee<ITRole> director;
    private List<Employee<ITRole>> employees;
// from business entity to another entity
    public static CompanyDTO from(ITCompany company) {

        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setDirector(company.getDirector());
        companyDTO.setName(company.getName());
        companyDTO.setEmployees(company.getEntities());
        return companyDTO;
    }
}
