package ir.lazydeveloper.service;

import ir.lazydeveloper.model.Accessor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegisterServiceTest {

    private static final String ACCESSOR_CODE = "test@gmail.com";
    private static RegisterService instance = null;

    @BeforeAll
    static void setup() {
        instance = RegisterService.getInstance();
    }

    @Test
    @Order(1)
    void getInstance() {
        assertNotNull(instance);
    }

    @Test
    @Order(2)
    void testSave() {
        Accessor accessor = new Accessor();
        accessor
                .setAccessorCode(ACCESSOR_CODE);
        accessor.setNoOfAttempts(0);
        accessor.setPassword(BCrypt.hashpw("123456", BCrypt.gensalt()));
        accessor.setEnabled('1');
        accessor.setModTime(LocalDateTime.now());
        instance.save(accessor);
        assertNotNull(accessor.getId());
    }

    @Test
    void isEmailExists() {
        boolean emailExists = instance.isEmailExists(ACCESSOR_CODE);
        assertTrue(emailExists);
    }
}
