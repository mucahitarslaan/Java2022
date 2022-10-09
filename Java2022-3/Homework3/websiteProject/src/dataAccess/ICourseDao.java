package dataAccess;

import entities.Category;
import entities.Course;

public interface ICourseDao {
    void add(Course course);
    void delete(Course course);
    void update(Course course);
    void get(Course course);
}
