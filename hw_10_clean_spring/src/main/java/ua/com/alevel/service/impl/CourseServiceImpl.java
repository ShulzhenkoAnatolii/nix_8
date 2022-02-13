package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dao.CourseDao;
import ua.com.alevel.entity.Course;
import ua.com.alevel.exception.EntityExistException;
import ua.com.alevel.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseDao courseDao;

    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public void create(Course entity) {
        courseDao.create(entity);
    }

    @Override
    public void update(Course entity) {
        if (courseDao.existById(entity.getId()))
            courseDao.update(entity);
    }

    @Override
    public void delete(Integer id) {
        if (courseDao.existById(id)) {
            courseDao.delete(id);
        } else new EntityExistException("entity not found");
    }

    @Override
    public Course findById(Integer id) {
        return courseDao.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }
}
