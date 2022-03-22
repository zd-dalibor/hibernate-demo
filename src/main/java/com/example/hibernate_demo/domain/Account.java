package com.example.hibernate_demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
public class Account extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -7773281081533034633L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @ToString.Exclude
    @JoinColumn(name = "userId")
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Account account = (Account) o;
        return id != null && Objects.equals(id, account.id) && Objects.equals(firstName, account.firstName) &&
                Objects.equals(lastName, account.lastName) && Objects.equals(dateOfBirth, account.dateOfBirth);
    }
}
