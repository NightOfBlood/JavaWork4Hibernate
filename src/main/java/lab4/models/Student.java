package lab4.models;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student extends Person {

    @Column(name = "course")
    protected int course;
    @Column(name = "favorite_subject")
    protected String favoriteSubject;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_id")
    protected Department department;
    @Transient
    private int departmentId;

    public Student() {
        super();
    }

    public Student(String[] info) {
        super(info);
        if (info.length <=5) {
            throw new IllegalArgumentException("Not enough parameters for student");
        } else {
            departmentId = Integer.parseInt(info[3]);
            course = Integer.parseInt(info[4]);
            favoriteSubject = info[5];
        }
    }

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public int getDepartmentId() {
        return departmentId;
    }

    public int getCourse() {
        return course;
    }
    public void setCourse(int course) {
        this.course = course;
    }

    public String getFavoriteSubject() {
        return favoriteSubject;
    }
    public void setFavoriteSubject(String favoriteSubject) {
        this.favoriteSubject = favoriteSubject;
    }

    @Override
    public String toString() {
        return super.toString() + "This person is a student with a group " + department.getName() + " course " + course + " favorite subject is "
                + favoriteSubject;
    }
}
