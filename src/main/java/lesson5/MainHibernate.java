package lesson5;

import java.util.List;

public class MainHibernate {
    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

//        for (int i = 0; i < 10; i++) {
//            int mark = (int) Math.round(Math.random() * 10);
//            String name = "s" + i;
//            studentDAO.create(name, mark);
//        }

        List<Student> list = studentDAO.findAll();
        for (Student s : list
        ) {
            System.out.println(s.toString());
        }

        System.out.println(studentDAO.findOne(159));

        studentDAO.delete(159);

        studentDAO.update(160, "newName", 7);

    }
}
