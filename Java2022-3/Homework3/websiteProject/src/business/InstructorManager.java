package business;

import core.logger.IBaseLogger;
import dataAccess.IInstructorDao;
import entities.Instructor;

public class InstructorManager {
    private final Instructor m_instructor;
    private final IBaseLogger[] m_loggers;
    private final IInstructorDao m_instructorDao;

    public InstructorManager(Instructor m_instructor, IBaseLogger[] m_loggers, IInstructorDao m_instructorDao) {
        this.m_instructor = m_instructor;
        this.m_loggers = m_loggers;
        this.m_instructorDao = m_instructorDao;
    }

    public void add(Instructor instructor) throws Exception
    {
    //    if (m_instructor.getFirstName().equals(instructor.getFirstName()) &&
    //            m_instructor.getLastName().equals(instructor.getLastName()) &&
    //            m_instructor.getId() == instructor.getId())
    //        throw new Exception("Enter a different instructor");

        m_instructorDao.add(instructor);

        for (IBaseLogger logger : m_loggers)
        {
            logger.log(instructor.getFirstName() +" "+ instructor.getLastName());
        }
    }

    public void delete(Instructor instructor)
    {
        m_instructorDao.delete(instructor);
    }

    public void update(Instructor instructor)
    {
        m_instructorDao.update(instructor);
    }

    public void get(Instructor instructor)
    {
        m_instructorDao.update(instructor);
    }
}
