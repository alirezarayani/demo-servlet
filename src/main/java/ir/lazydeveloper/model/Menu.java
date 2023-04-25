package ir.lazydeveloper.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Getter
@Setter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_seq")
    @SequenceGenerator(name = "menu_seq", sequenceName = "MENU_SEQ")
    private Long id;
    @Column(columnDefinition = "VARCHAR(25)", unique = true, nullable = false)
    private String name;
    @Column(name = "PERSIAN_NAME", columnDefinition = "VARCHAR2(25)", unique = true, nullable = false)
    private String persianName;
    @Column(columnDefinition = "VARCHAR(80)", unique = true, nullable = false)
    private String route;
    private String icon;

    @OneToMany
    @JoinColumn(name = "MENU_ID")
    private List<Menu> menus;
}
