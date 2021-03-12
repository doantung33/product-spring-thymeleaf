package service;

import model.Category;

import java.util.List;

public interface ICategoryService extends IService<Category> {
    Category findByName(String name);
}
