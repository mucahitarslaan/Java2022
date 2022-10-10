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

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws Exception{

        IBaseLogger[] loggers = new IBaseLogger[]{new DatabaseLogger(),new FileLogger(),new EmailLogger()};

        Instructor instructor1 = new Instructor(1,"Engin", "Demiroğ");
        Instructor instructor2 = new Instructor(2,"Mücahit", "Arslan");
        List<Instructor> instructorList = new ArrayList<>();
        instructorList.add(instructor1);
        instructorList.add(instructor2);


        Course course1 = new Course(1,"Java 2022", "Java" , 5000, instructor1);
        Course course2 = new Course(2,"Java 2022-2", "Java" , -6500, instructor2);
        List<Course> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);


        Category category1 = new Category("Programlama" , "Java" );
        Category category2 = new Category("Programlama" , "Java" );
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(category1);
        categoryList.add(category2);

        IInstructorDao instructorDao = new JdbcInstructorDao();
        ICourseDao courseDao = new JdbcCourseDao();
        ICategoryDao categoryDao = new JdbcCategoryDao();

        InstructorManager instructorManager = new InstructorManager(instructorList,loggers,instructorDao);
        CourseManager courseManager = new CourseManager(courseDao,courseList,loggers);
        CategoryManager categoryManager = new CategoryManager(categoryDao,categoryList,loggers);

        instructorManager.add(instructor1);
        instructorManager.add(instructor2);
        System.out.println("---------------------");

        courseManager.add(course1);
        courseManager.add(course2);
        System.out.println("---------------------");

        categoryManager.add(category1);
        categoryManager.add(category2);

    }
}