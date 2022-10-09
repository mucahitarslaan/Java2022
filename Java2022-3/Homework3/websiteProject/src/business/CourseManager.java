package business;

import core.logger.IBaseLogger;
import dataAccess.ICourseDao;
import entities.Category;
import entities.Course;

public class CourseManager {
    private final ICourseDao m_courseDao;
    private final Course m_course;
    private final IBaseLogger[] m_loggers;

    public CourseManager(ICourseDao m_courseDao, Course m_course, IBaseLogger[] m_loggers) {
        this.m_courseDao = m_courseDao;
        this.m_course = m_course;
        this.m_loggers = m_loggers;
    }

    public void add(Course course) throws Exception
    {

    //    if (m_course.getCourseName().equals(course.getCourseName()))
    //        throw new Exception("Enter a different course name");
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
