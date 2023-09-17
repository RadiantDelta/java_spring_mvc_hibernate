package ru.madbrains.spring_mvc.company.employer;

public class PM extends Employee<ITRole> {

    public PM(String name, int age ){
        super(name, age, ITRole.PM);
    }
    @Override
    public void work() {
        System.out.println(this.getName() + " is managing project");
    }
}
