package com.log4p.services;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService.Iface {

    private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

    public Category get(long id) throws TException {
        log.debug("get category is called");

        Category c = new Category();
        c.setId(id);
        c.setName("Category " + id);

        return c;
    }

    public List<Category> getChildren(long parentId) throws TException {
        log.debug("get children is called");

        List<Category> categories = new ArrayList<Category>();

        for (int i = 0; i < 10; i++) {
            Category c = new Category();
            c.setId(i);
            c.setName("Category " + i);
            categories.add(c);
        }

        return categories;
    }
}