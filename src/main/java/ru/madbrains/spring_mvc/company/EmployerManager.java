package ru.madbrains.spring_mvc.company;

import ru.madbrains.spring_mvc.company.employer.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployerManager<T extends Employee> {

    private List<T> entities;

    public EmployerManager() {
        this.entities = new ArrayList<>();
    }


    public int getSize() {return entities.size();}
    public List<T> getEntities() {return entities;}
}
