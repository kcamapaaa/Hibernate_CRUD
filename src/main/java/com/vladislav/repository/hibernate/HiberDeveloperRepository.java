package com.vladislav.repository.hibernate;

import com.vladislav.model.Developer;
import com.vladislav.model.Status;
import com.vladislav.repository.DeveloperRepository;
import com.vladislav.util.HiberUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HiberDeveloperRepository implements DeveloperRepository {
    @Override
    public Developer getById(Integer id) {
        Developer developer;
        try (Session session = HiberUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            developer = session.get(Developer.class, id);
            if(developer == null || developer.getStatus() == Status.DELETED) {
                return null;
            }
            session.getTransaction().commit();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return developer;
    }

    @Override
    public List<Developer> getAll() {
        List<Developer> developerList;
        try (Session session = HiberUtils.getSessionFactory().openSession()) {
            session.beginTransaction();

            Query<Developer> query = session.createQuery("FROM Developer D where D.status = 'ACTIVE'");
            developerList = query.list();

            session.getTransaction().commit();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return developerList;
    }

    @Override
    public Developer save(Developer developer) {
        try (Session session = HiberUtils.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.save(developer);

            session.getTransaction().commit();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return developer;
    }

    @Override
    public Developer update(Developer developer) {
        try (Session session = HiberUtils.getSessionFactory().openSession()) {
            session.beginTransaction();

            Developer updatedDeveloper = session.find(Developer.class, developer.getId());
            if (updatedDeveloper == null || updatedDeveloper.getStatus() == Status.DELETED) {
                return null;
            }
            updatedDeveloper.setFirstName(developer.getFirstName());
            updatedDeveloper.setLastName(developer.getLastName());
            session.update(updatedDeveloper);

            session.getTransaction().commit();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return developer;
    }

    @Override
    public boolean deleteById(Integer id) {
        try (Session session = HiberUtils.getSessionFactory().openSession()) {
            session.beginTransaction();

            Developer deletedDeveloper = session.find(Developer.class, id);
            if (deletedDeveloper == null || deletedDeveloper.getStatus() == Status.DELETED) {
                return false;
            }
            deletedDeveloper.setStatus(Status.DELETED);
            session.update(deletedDeveloper);

            session.getTransaction().commit();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
