package service;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import repo.ICategoryRepository;

import java.util.List;

public class CategoryService implements  ICategoryService{

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.delete(id);
    }
}
