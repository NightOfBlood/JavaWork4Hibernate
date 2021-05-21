package lab4.services;

import com.opencsv.CSVReader;
import lab4.dao.DepartmentDao;
import lab4.dao.StudentDao;
import lab4.dao.TeacherDao;
import lab4.models.Department;
import lab4.models.Person;
import lab4.models.Student;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    private final DepartmentDao departmentDao = new DepartmentDao();
    private final StudentDao studentDao = new StudentDao();
    private final TeacherDao teacherDao = new TeacherDao();

    public List<Department> getAllDepartments(){
        return departmentDao.getAllDepartments();
    }

    public Department findDepartment(int id) {
        return departmentDao.findDepartmentById(id);
    }

    public void saveDepartment(Department department) {
        departmentDao.save(department);
    }

    public void deleteDepartment(Department department) {
        departmentDao.delete(department);
    }

    public void updateDepartment(Department department) {
        departmentDao.update(department);
    }

    public void addStudent(Department department, int studentId) {
        Student student = studentDao.findStudentById(studentId);
        department.addStudent(student);
        departmentDao.save(department);
    }

    public Department findDepartmentById(int id) {
        return departmentDao.findDepartmentById(id);
    }

    public void saveDepartmentFromCSV(Department department) {
        department.setTeacher(teacherDao.findTeacherById(department.getTeacherId()));
        saveDepartment(department);
    }
}
