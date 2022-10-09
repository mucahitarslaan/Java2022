package dataAccess;

import entities.Course;
import entities.Instructor;

public interface IInstructorDao {
    void add(Instructor instructor);
    void delete(Instructor instructor);
    void update(Instructor instructor);
    void get(Instructor instructor);
}
