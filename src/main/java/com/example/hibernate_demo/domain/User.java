package com.example.hibernate_demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
public class User extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 3297976561296256906L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ToString.Exclude
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id) && Objects.equals(username, user.username)
                && Objects.equals(password, user.password);
    }
}
