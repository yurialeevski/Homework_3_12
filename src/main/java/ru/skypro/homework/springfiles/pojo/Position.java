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
}
