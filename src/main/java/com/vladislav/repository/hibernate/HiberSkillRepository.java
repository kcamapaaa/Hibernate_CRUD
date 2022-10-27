package com.vladislav.repository.hibernate;

import com.vladislav.model.Skill;
import com.vladislav.util.HiberUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class HiberSkillRepository implements com.vladislav.repository.SkillRepository {
    @Override
    public Skill getById(Integer id) {
        Skill skill;
        try(Session session = HiberUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            skill = session.get(Skill.class, id);
            session.getTransaction().commit();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return skill;
    }

    @Override
    public List<Skill> getAll() {
        List<Skill> skillsList;
        try(Session session = HiberUtils.getSessionFactory().openSession()) {
            session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Skill> cq = cb.createQuery(Skill.class);
            Root<Skill> root = cq.from(Skill.class);
            cq.select(root);

            Query<Skill> query = session.createQuery(cq);
            skillsList = query.getResultList();

            session.getTransaction().commit();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return skillsList;
    }

    @Override
    public Skill save(Skill skill) {
        try(Session session = HiberUtils.getSessionFactory().openSession()) {
            session.beginTransaction();

            Integer id = (Integer) session.save(skill);
            skill.setId(id);

            session.getTransaction().commit();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return skill;
    }

    @Override
    public Skill update(Skill skill) {
        try(Session session = HiberUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            Skill updatedSkill = session.get(Skill.class, skill.getId());
            if(updatedSkill == null) {
                return null;
            }
            updatedSkill.setName(skill.getName());
            session.update(updatedSkill);
            session.getTransaction().commit();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return skill;
    }

    @Override
    public boolean deleteById(Integer id) {
        try(Session session = HiberUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            Skill deletedSkill = session.get(Skill.class, id);
            if(deletedSkill == null) {
                return false;
            }
            session.delete(deletedSkill);
            session.getTransaction().commit();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
