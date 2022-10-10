package business;

import core.logger.IBaseLogger;
import dataAccess.IInstructorDao;
import entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class InstructorManager {
    private final IBaseLogger[] m_loggers;
    private final IInstructorDao m_instructorDao;
    private final List<Instructor> instructorList;

    public InstructorManager(List<Instructor> instructorList, IBaseLogger[] m_loggers, IInstructorDao m_instructorDao) {
        this.instructorList = instructorList;
        this.m_loggers = m_loggers;
        this.m_instructorDao = m_instructorDao;
    }

    public void add(Instructor instructor) throws Exception
    {
        if (!instructorList.contains(instructor))
            throw new Exception("Please enter a different Instructor");
        else
            instructorList.add(instructor);

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
