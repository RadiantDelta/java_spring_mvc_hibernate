package ru.madbrains.spring_mvc.company.employer;

public class QA extends Employee<ITRole> {

    public QA (String name, int age){
        super(name, age, ITRole.QA);
    }

    @Override
    public void work() {
        System.out.println(this.getName() + " is testing");
    }
}
