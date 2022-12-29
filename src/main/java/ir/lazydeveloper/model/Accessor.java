package ir.lazydeveloper.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class Accessor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AccessorSeq")
    @SequenceGenerator(name = "AccessorSeq", sequenceName = "ACCESSOR_SEQ")
    private Long id;
    private String accessorCode;
    private String password;
    private char enabled;
    private int noOfAttempts;
    private LocalDateTime expiryDate;
    private LocalDateTime modTime;
    private String verifyCode;

    public Accessor(String accessorCode, String password) {
        this.accessorCode = accessorCode;
        this.password = password;
    }

    public Accessor() {

    }
}
