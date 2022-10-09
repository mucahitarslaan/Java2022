package business;

import core.logger.IBaseLogger;
import dataAccess.ICategoryDao;
import entities.Category;


public class CategoryManager {
    private final ICategoryDao m_categoryDao;
    private final Category m_category;
    private final IBaseLogger[] m_loggers;


    public CategoryManager(ICategoryDao categoryDao,Category category, IBaseLogger[] loggers) {
        m_categoryDao = categoryDao;
        m_loggers = loggers;
        m_category =category;
    }

    public void add(Category category) throws Exception
    {
    //    if (m_category.getName().equals(category.getName()))
    //        throw new Exception("Enter a different category name");
        m_categoryDao.add(category);

        for (IBaseLogger logger : m_loggers)
        {
            logger.log(category.getName());
        }
    }
    public void delete(Category category)
    {
        m_categoryDao.delete(category);
    }
    public void update(Category category)
    {
        m_categoryDao.delete(category);
    }
    public void get(Category category)
    {
        m_categoryDao.get(category);
    }



}
