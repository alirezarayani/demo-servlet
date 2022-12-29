package ir.lazydeveloper.dao;

import ir.lazydeveloper.common.ORMConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class AbstractRepository<T> extends Parameterized<T> implements Repository<T> {

    protected EntityManager entityManager;

    @Override
    public void save(T t) {
        entityManager = ORMConfig.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(t);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void update(T t) {
        entityManager = ORMConfig.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(t);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void remove(T t) {
        entityManager = ORMConfig.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(t);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public Optional<T> findById(Number id) {
        entityManager = ORMConfig.getEntityManager();
        T t = entityManager.find(this.getClazz(), id);
        entityManager.close();
        return Optional.of(t);
    }

    @Override
    public List<T> findAll() {
        List<T> resultList = entityManager.createQuery("FROM " + this.getClazz() + " t", this.getClazz()).getResultList();
        entityManager.close();
        return resultList;
    }
}
