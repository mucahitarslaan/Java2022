package dataAccess;

import entities.Category;
import entities.Instructor;

public class HibernateInstructorDao implements IInstructorDao{
    @Override
    public void add(Instructor instructor) {
        System.out.println("Instructor added to database via Hibernate : " + instructor.getFirstName() + " " + instructor.getLastName());
    }

    @Override
    public void delete(Instructor instructor) {
        System.out.println("Instructor deleted from database via Hibernate : " + instructor.getFirstName() + " " + instructor.getLastName());
    }

    @Override
    public void update(Instructor instructor) {
        System.out.println("Instructor updated in database via Hibernate : " + instructor.getFirstName() + " " + instructor.getLastName());
    }

    @Override
    public void get(Instructor instructor) {
        System.out.println("Instructor was fetched from database via Hibernate : " + instructor.getFirstName() + " " + instructor.getLastName());
    }
}
