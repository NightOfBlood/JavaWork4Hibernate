package lab4.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
//department
public class Department extends AbstractModel{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    protected Teacher teacher;
    @Transient
    private int teacherId;
    //TODO:
    @OneToMany(mappedBy = "department", cascade = CascadeType.REFRESH, orphanRemoval = true)
    protected List<Student> students;
    //protected List<Integer> studentsIds=new ArrayList<>();



    @Column(name = "name")
    protected String name;

    public Department() {
        super();
    }

    public Department(String[] info) {
        super(info);
        name = info[1];
        teacherId = Integer.parseInt(info[2]);
        /*for(int i = 2; i<info.length; i++)
            studentsIds.add( Integer.parseInt(info[i]));*/
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public void addStudent(Student student) {
        students =  students==null?new ArrayList<>() : students;
        students.add(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "This Department name is " + name ;
    }
}
