package lab4;

import com.opencsv.CSVReader;
import lab4.models.AbstractModel;
import lab4.models.Department;
import lab4.models.Student;
import lab4.models.Teacher;
import lab4.services.DepartmentService;
import lab4.services.StudentService;
import lab4.services.TeacherService;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String PATH;

    public static void main(String[] args) throws Throwable {
        if (args.length > 0) {
            System.out.println("More than 0 args");
            PATH = args[0];
        } else {
            System.out.println("0 args");
            PATH = "E:\\Дгту\\Современные технологии программирования\\data.csv";
        }

        StudentService studentService = new StudentService();
        List<Student> withName = studentService.getStudentsOfTeachersWithName("ов");
        withName.forEach(s-> System.out.println("s = " + s));
        //uploadDataFromCsv();

    }

    private static void uploadDataFromCsv() throws Throwable {
        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Department> departments = new ArrayList<>();
        readFile(PATH, new Class[]{Student.class, Department.class, Teacher.class},
                new ArrayList[]{students,departments, teachers});
        TeacherService teacherService = new TeacherService();
        teachers.forEach(teacherService::saveTeacher);
        DepartmentService departmentService = new DepartmentService();
        departments.forEach(departmentService::saveDepartmentFromCSV);
        StudentService studentService = new StudentService();
        students.forEach(studentService::saveStudentFromCSV);
    }

    private static <T extends AbstractModel> void readFile(String path,
                                                           Class<T>[] classes,
                                                           ArrayList[] lists) throws Throwable {
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(path), Charset.forName("windows-1251")));
            List<String[]> allRows = reader.readAll();
            int i = 0;
            int indexOfClass = 0;
            while (i < allRows.size()) {
                Class<T> aClass = classes[indexOfClass];
                Constructor<T> constructor = aClass.getConstructor(String[].class);

                while (i < allRows.size() && allRows.get(i).length > 1) {
                    String[] row = allRows.get(i);
                    T t = constructor.newInstance((Object) row);
                    lists[indexOfClass].add(t);
                    i++;
                }

                i++;
                indexOfClass++;
            }
        } catch (Exception e) {
            throw e instanceof InvocationTargetException ? e.getCause() : e;
        }
    }
}
