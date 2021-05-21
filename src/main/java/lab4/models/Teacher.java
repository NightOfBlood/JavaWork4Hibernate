package lab4.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="teacher")

public class Teacher extends Person {

    @Column(name="nameOfSubject")
    protected String nameOfSubject;

    @Column(name="workExperience")
    protected int workExperience;


    //TODO:
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.REFRESH)
    protected List<Department> departments;

    public Teacher(String[] info) {
        super(info);
        if (info.length > 4) {
            nameOfSubject = info[3];
            workExperience = Integer.parseInt(info[4]);
        } else {
            throw new IllegalArgumentException("Not enough parameters for teacher");
        }
    }
    public Teacher() {
        super();
    }

    public String getNameOfSubject() {
        return nameOfSubject;
    }

    public void setNameOfSubject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
    @Override
    public String toString() {
        return super.toString() + "This person is a teacher with a " + workExperience +" years of experience in " + age + "name of subject"  + ".";
    }
}
