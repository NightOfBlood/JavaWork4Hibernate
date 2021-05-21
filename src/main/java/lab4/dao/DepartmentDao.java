package lab4.dao;

import lab4.HibernateSessionFactoryUtil;
import lab4.models.Person;
import lab4.models.Student;
import lab4.models.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
//TODO: по аналогии с javaRush додлеать методы + дописать дао к остальным моделям
public class DepartmentDao {
    public List<Department> getAllDepartments(){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Department").list();
    }

    public void save(Department department) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(department);
        tx1.commit();
        session.close();
    }

    public void update(Department department) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(department);
        tx1.commit();
        session.close();
    }

    public void delete(Department department) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(department);
        tx1.commit();
        session.close();
    }

    public Department findDepartmentById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Department.class, id);
    }

}
