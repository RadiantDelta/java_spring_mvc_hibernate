package ru.madbrains.spring_mvc.company.employer;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Employee<T> implements Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employer_generator")
    @SequenceGenerator(name = "employer_generator", sequenceName = "developers_seq", allocationSize = 0)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private T role;

    public Employee() {

    }

    public Employee(String name, int age, T role){
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public String getName(){   return this.name; }
    public int getAge(){   return this.age; }
    public void setName(String name){this.name = name;}
    public void setAge(int age){this.age = age;}
    public void setRole(T role){this.role = role;}

    public T getRole(){
        return role;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", role=" + role +
                '}';
    }
}
