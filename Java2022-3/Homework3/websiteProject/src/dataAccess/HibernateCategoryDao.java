package dataAccess;

import entities.Category;

public class HibernateCategoryDao implements ICategoryDao{
    @Override
    public void add(Category category) {
        System.out.println("Category added to database via Hibernate : " + category.getName());
    }

    @Override
    public void delete(Category category) {
        System.out.println("Category deleted from database via Hibernate : " + category.getName());
    }

    @Override
    public void update(Category category) {
        System.out.println("Category updated in database via Hibernate : " + category.getName());
    }

    @Override
    public void get(Category category) {
        System.out.println("Category was fetched from database via Hibernate : " + category.getName());
    }
}
