package ir.lazydeveloper.service;

import ir.lazydeveloper.common.ORMConfig;
import ir.lazydeveloper.dao.AbstractRepository;
import ir.lazydeveloper.model.Accessor;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class RegisterService extends AbstractRepository<Accessor> {

    private static final RegisterService registerService = new RegisterService();

    public static RegisterService getInstance() {
        return registerService;
    }

    public boolean isEmailExists(Accessor accessor) {
        return isEmailExists(accessor.getAccessorCode());
    }

    public boolean isEmailExists(String accessorCode) {
        EntityManager entityManager = ORMConfig.getEntityManager();
        Query query = entityManager.createQuery("FROM Accessor a WHERE a.accessorCode = :accessorCode");
        query.setParameter("accessorCode", accessorCode);
        return query.getResultStream().findFirst().isPresent();
    }

}
