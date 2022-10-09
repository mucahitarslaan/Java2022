import business.CategoryManager;
import business.CourseManager;
import business.InstructorManager;
import core.logger.DatabaseLogger;
import core.logger.EmailLogger;
import core.logger.FileLogger;
import core.logger.IBaseLogger;
import dataAccess.*;
import entities.Category;
import entities.Course;
import entities.Instructor;

public class Main {
    public static void main(String[] args) throws Exception{

        IBaseLogger[] loggers = new IBaseLogger[]{new DatabaseLogger(),new FileLogger(),new EmailLogger()};

        Instructor instructor = new Instructor(1,"Engin", "Demiroğ");
        Course course = new Course(1,"Java 2022", "Java" , 5000, instructor);
        Category category = new Category("Programlama" , "Java" );

        IInstructorDao instructorDao = new JdbcInstructorDao();
        ICourseDao courseDao = new JdbcCourseDao();
        ICategoryDao categoryDao = new JdbcCategoryDao();

        InstructorManager instructorManager = new InstructorManager(instructor,loggers,instructorDao);
        CourseManager courseManager = new CourseManager(courseDao,course,loggers);
        CategoryManager categoryManager = new CategoryManager(categoryDao,category,loggers);

        courseManager.add(course);
        System.out.println("------------------------");
        instructorManager.add(instructor);
        System.out.println("------------------------");
        categoryManager.add(category);

    }
}