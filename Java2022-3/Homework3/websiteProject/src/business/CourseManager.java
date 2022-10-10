package business;

import core.logger.IBaseLogger;
import dataAccess.ICourseDao;
import entities.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {
    private final ICourseDao m_courseDao;
    private final IBaseLogger[] m_loggers;
    private List<Course> courseList;

    public CourseManager(ICourseDao m_courseDao, List<Course> courseList, IBaseLogger[] m_loggers) {
        this.m_courseDao = m_courseDao;
        this.courseList = courseList;
        this.m_loggers = m_loggers;
    }

    public void add(Course course) throws Exception
    {
        if (!courseList.contains(course) && course.getCoursePrice()<0)
            throw new Exception("Please enter a different Course");
        else
            courseList.add(course);
        m_courseDao.add(course);

        for (IBaseLogger logger : m_loggers)
        {
            logger.log(course.getCourseName());
        }
    }
    public void delete(Course course)
    {
        m_courseDao.delete(course);
    }
    public void update(Course course)
    {
        m_courseDao.delete(course);
    }
    public void get(Course course)
    {
        m_courseDao.get(course);
    }
}
