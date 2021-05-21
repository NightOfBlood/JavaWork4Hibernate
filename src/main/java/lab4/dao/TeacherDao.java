package lab4.dao;

import lab4.HibernateSessionFactoryUtil;
import lab4.models.Person;
import lab4.models.Student;
import lab4.models.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
//TODO: по аналогии с javaRush додлеать методы + дописать дао к остальным моделям
public class TeacherDao {
    public List<Teacher> getAllTeachers(){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Teacher").list();
    }

    public void save(Teacher teacher) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(teacher);
        tx1.commit();
        session.close();
    }

    public void update(Teacher teacher) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(teacher);
        tx1.commit();
        session.close();
    }

    public void delete(Teacher teacher) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(teacher);
        tx1.commit();
        session.close();
    }

    public Teacher findTeacherById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Teacher.class, id);
    }

}
