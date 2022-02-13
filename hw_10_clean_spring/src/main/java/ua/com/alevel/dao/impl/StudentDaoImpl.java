package ua.com.alevel.dao.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentDaoImpl implements StudentDao {

    private final EntityManagerFactory entityManagerFactory;

    public StudentDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void create(Student entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    public void update(Student entity) {EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    public void delete(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.createQuery("delete from Student s where s.id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Student findById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = null;
        try {
            student = entityManager.find(Student.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Student> students = Collections.emptyList();
        try {
            students = entityManager.createQuery("select s from Student s")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return students;
    }

    @Override
    public boolean existById(Integer id) {
        return false;
    }
}
