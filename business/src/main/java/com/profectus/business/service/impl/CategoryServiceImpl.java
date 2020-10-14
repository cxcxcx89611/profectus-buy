package com.profectus.business.service.impl;

import com.profectus.business.dao.CategoryRepository;
import com.profectus.business.model.Category;
import com.profectus.business.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }
}
