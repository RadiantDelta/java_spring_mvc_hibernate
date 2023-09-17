package ru.madbrains.spring_mvc.company;

import ru.madbrains.spring_mvc.company.employer.Employee;
import ru.madbrains.spring_mvc.company.employer.ITRole;

import java.util.Objects;


public class ITCompany extends EmployerManager<Employee<ITRole>> {
    //@Value("MadBrains")
    private String name;

    private Employee<ITRole> director;

    public ITCompany( String companyName) {
        super();
        this.name = companyName;
    }

    public void startWork(){
        getEntities().forEach(worker -> {
            worker.work();
            System.out.println(worker.getName() + " is " + worker.getRole());
        });

    }

    public void setDirector(Employee<ITRole> director) {
        this.director = director;
    }

    public Employee<ITRole> getDirector() {
        return  director;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override

    public String toString() {
        return "ITCompany{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ITCompany itCompany = (ITCompany) o;
        return Objects.equals(name, itCompany.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
