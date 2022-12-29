package ir.lazydeveloper.dao;

import ir.lazydeveloper.common.ORMConfig;
import ir.lazydeveloper.model.Accessor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class RegisterDao implements AutoCloseable {

    private EntityManager entityManager;


    public void insert(Accessor accessor) {
        EntityManager entityManager = ORMConfig.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(accessor);
        transaction.commit();
    }

    public Accessor findByEmail(Accessor accessor) {
        EntityManager entityManager = ORMConfig.getEntityManager();
        return entityManager.createQuery("From Accessor Where accessorCode =: accessorCode", Accessor.class)
                .setParameter("accessorCode", accessor.getAccessorCode()).getResultStream().findFirst().orElse(null);
    }

    @Override
    public void close(){
        entityManager.close();
    }
}
