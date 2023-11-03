package br.com.pauloh.dao;

import java.util.List;

import br.com.pauloh.dao.generic.GenericDAO;
import br.com.pauloh.domain.Course;

public class CourseDAO extends GenericDAO<Course> implements ICourseDAO {
    private GenericDAO<Course> genericDAO;

    public CourseDAO() {
        super();
        this.genericDAO = new GenericDAO<>(Course.class);
    }

    @Override
    public Course create(Course entity) {
        return genericDAO.create(entity);
    }

    @Override
    public Course update(Course entity) {
        return genericDAO.update(entity);
    }

    @Override
    public void delete(Course entity) {
        genericDAO.delete(entity);
    }

    @Override
    public Course findById(Long id) {
        return genericDAO.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return genericDAO.findAll();
    }

}
