package lab4.services;

import com.opencsv.CSVReader;
import lab4.dao.DepartmentDao;
import lab4.dao.StudentDao;
import lab4.models.Department;
import lab4.models.Person;
import lab4.models.Student;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.List;

//TODO: по аналогии с javaRush додлеать методы + дописать сервисы к остальным дао
public class StudentService {
    private final StudentDao studentDao = new StudentDao();
    private final DepartmentDao departmentDao = new DepartmentDao();


    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public Student findStudent(int id) {
        return studentDao.findStudentById(id);
    }

    public void saveStudent(Student student) {
        studentDao.save(student);
    }

    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }

    public void updateStudent(Student student) {
        studentDao.update(student);
    }


    public Student findStudentById(int id) {
        return studentDao.findStudentById(id);
    }

    public void saveStudentFromCSV(Student student) {
        student.setDepartment(departmentDao.findDepartmentById(student.getDepartmentId()));
        saveStudent(student);
    }

    public List<Student> getStudentsOfTeachersWithName(String name){
        return studentDao.getStudentsOfTeachersWithName(name);
    }
}
