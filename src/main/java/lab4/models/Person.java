package lab4.models;

import javax.persistence.*;

@MappedSuperclass
public abstract class Person extends AbstractModel {


    @Column(name= "last_name")
    protected String lastName;
    @Column(name = "age")
    protected int age;

    public Person(){
        super();
    }

    public Person(String[] info) {
        super(info);
        if (info.length > 2) {
            lastName = info[1];
            age = Integer.parseInt(info[2]);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "This person lastname is " + lastName + "; age is " + age + "; ";
    }
}
