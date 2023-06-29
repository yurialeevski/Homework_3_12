package ru.skypro.homework.springfiles.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer id;
    private String role;
    //@OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    //private List<Employee> employees;

    public Position() {
    }

    public Position(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
/*#################################################################
@Entity
@Table(name = "position")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Position {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String name;

}
 #################################################################*/