package ir.lazydeveloper.service;

import ir.lazydeveloper.dao.LoginDao;
import ir.lazydeveloper.model.Accessor;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
import java.util.Optional;

public class LoginService {

    private final static LoginService loginService = new LoginService();

    public static LoginService getInstance() {
        return loginService;
    }

    public boolean oneFactorLogin(Accessor accessor) throws SQLException {
        boolean isEqual = false;
        try (LoginDao loginDao = new LoginDao()) {
            Optional<Accessor> passwordByEmail = loginDao.getPasswordByEmail(accessor);
            if (passwordByEmail.isPresent()) {
                Accessor accessor1 = passwordByEmail.get();
                isEqual = BCrypt.checkpw(accessor.getPassword(), accessor1.getPassword());
            }
        }
        return isEqual;
    }
}
