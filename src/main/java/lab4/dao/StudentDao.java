package lab4.dao;

import lab4.HibernateSessionFactoryUtil;
import lab4.models.Person;
import lab4.models.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
//TODO: по аналогии с javaRush додлеать методы + дописать дао к остальным моделям
public class StudentDao {
    public List<Student> getAllStudents(){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Student").list();
    }

    public void save(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(student);
        tx1.commit();
        session.close();
    }

    public void update(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(student);
        tx1.commit();
        session.close();
    }

    public void delete(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(student);
        tx1.commit();
        session.close();
    }

    public Student findStudentById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Student.class, id);
    }


    public List<Student> getStudentsOfTeachersWithName(String name) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("From Student as stud where stud.department.teacher.lastName like '%"+name+"%'").list();

    }
}
