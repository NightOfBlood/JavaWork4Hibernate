package lab4.services;

import lab4.dao.StudentDao;
import lab4.dao.TeacherDao;
import lab4.models.Student;
import lab4.models.Teacher;

import java.util.List;

public class TeacherService {
    private final TeacherDao teacherDao = new TeacherDao();

    public List<Teacher> getAllTeachers(){
        return teacherDao.getAllTeachers();
    }

    public Teacher findTeacher(int id) {
        return teacherDao.findTeacherById(id);
    }

    public void saveTeacher(Teacher teacher) {
        Teacher teacherById = teacherDao.findTeacherById(teacher.getId());
        if(teacherById==null)
            teacherDao.save(teacher);
        else
            teacherDao.update(teacher);

    }

    public void deleteTeacher(Teacher teacher) {
        teacherDao.delete(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        teacherDao.update(teacher);
    }


    public Teacher findTeacherById(int id) {
        return teacherDao.findTeacherById(id);
    }
}

