package com.vladislav.repository.hibernate;

import com.vladislav.model.Specialty;
import com.vladislav.repository.SpecialtyRepository;
import com.vladislav.util.HiberUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class HiberSpecialtyRepository implements SpecialtyRepository {
    @Override
    public Specialty getById(Integer id) {
        Specialty specialty;
        try (Session session = HiberUtils.getSession()) {
            session.beginTransaction();
            specialty = session.get(Specialty.class, id);
            session.getTransaction().commit();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return specialty;
    }

    @Override
    public List<Specialty> getAll() {
        List<Specialty> specialtyList;
        try (Session session = HiberUtils.getSession()) {
            Query<Specialty> query = session.createQuery("FROM Specialty");
            specialtyList = query.getResultList();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return specialtyList;
    }

    @Override
    public Specialty save(Specialty specialty) {
        try (Session session = HiberUtils.getSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(specialty);
            specialty.setId(id);
            session.getTransaction().commit();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return specialty;
    }

    @Override
    public Specialty update(Specialty specialty) {
        try (Session session = HiberUtils.getSession()) {
            session.beginTransaction();
            Specialty needUpdate = session.get(Specialty.class, specialty.getId());
            if (needUpdate == null) {
                return null;
            }
            needUpdate.setName(specialty.getName());
            session.update(needUpdate);
            session.getTransaction().commit();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return specialty;
    }

    @Override
    public boolean deleteById(Integer id) {
        try (Session session = HiberUtils.getSession()) {
            session.beginTransaction();
            Specialty needToDelete = session.get(Specialty.class, id);
            if (needToDelete == null) {
                return false;
            }
            session.delete(needToDelete);
            session.getTransaction().commit();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
