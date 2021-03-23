package lesson5;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO {

    public Student findOne(long id) {
        Session session = MySessionFactory.getSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    public List<Student> findAll() {
        Session session = MySessionFactory.getSession();
        List<Student> studentList = session.createQuery("FROM Student").list();
        session.close();
        return studentList;
    }

    public void create(String name, int mark) {
        Session session = MySessionFactory.getSession();
        Student student = new Student(name, mark);
        session.save(student);
        session.close();
    }

    public void update(long id, String name, int mark) {
        Session session = MySessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        //Такой способ почему-то не работает, отдельно mark изменяет, а вот с name не работает
        //Не могу понять, что не так
        //session.createQuery("UPDATE Student SET name = " + name + ", mark = " + mark + " WHERE id=" + id).executeUpdate();
        Student student = session.get(Student.class, id);
        student.setName(name);
        student.setMark(mark);
        session.update(student);
        transaction.commit();
        session.close();
    }

    public void delete(long id) {
        Session session = MySessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("DELETE FROM Student WHERE id = " + id).executeUpdate();
        transaction.commit();
        session.close();
    }

}
