package business;

import core.logger.IBaseLogger;
import dataAccess.ICategoryDao;
import entities.Category;
import java.util.List;


public class CategoryManager {
    private final ICategoryDao m_categoryDao;
    private final IBaseLogger[] m_loggers;
    private final List<Category> categoryList;

    public CategoryManager(ICategoryDao categoryDao,List<Category> categoryList, IBaseLogger[] loggers) {
        this.m_categoryDao = categoryDao;
        this.m_loggers = loggers;
        this.categoryList =categoryList;
    }

    public void add(Category category) throws Exception
    {
        if (!categoryList.contains(category))
        {
            throw new Exception("Enter a different Category");
        }else
            categoryList.add(category);
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
