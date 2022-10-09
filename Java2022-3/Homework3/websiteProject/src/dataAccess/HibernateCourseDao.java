package dataAccess;

import entities.Category;
import entities.Course;

public class HibernateCourseDao implements ICourseDao{
    @Override
    public void add(Course course) {
        System.out.println("Course added to database via Hibernate : " + course.getCourseName());
    }

    @Override
    public void delete(Course course) {
        System.out.println("Course deleted from database via Hibernate : " + course.getCourseName());
    }

    @Override
    public void update(Course course) {
        System.out.println("Course updated in database via Hibernate : " + course.getCourseName());
    }

    @Override
    public void get(Course course) {
        System.out.println("Course was fetched from database via Hibernate : " + course.getCourseName());
    }
}
