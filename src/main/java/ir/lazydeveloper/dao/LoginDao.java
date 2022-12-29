package ir.lazydeveloper.dao;

import ir.lazydeveloper.common.ORMConfig;
import ir.lazydeveloper.model.Accessor;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.Optional;

public class LoginDao implements AutoCloseable {

    private EntityManager entityManager;

    public Optional<Accessor> getPasswordByEmail(Accessor accessor) throws SQLException {
        entityManager = ORMConfig.getEntityManager();
        return entityManager.createQuery("SELECT A FROM Accessor A  WHERE A.accessorCode = :accessorCode")
                .setParameter("accessorCode", accessor.getAccessorCode())
                .getResultStream().findFirst();
    }

    @Override
    public void close() {
        entityManager.close();
    }
}
