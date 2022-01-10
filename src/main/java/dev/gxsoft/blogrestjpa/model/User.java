package dev.gxsoft.blogrestjpa.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
    private String email;
    private String city;
    private String country;
    private String gender;

    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "is_premium")
    private boolean premiumEnabled;

    @Override
    public String toString() {
        return "User : { " +
                "userId : " + userId +
                ", firstName : " + firstName +
                ", lastName : " + lastName +
                ", email : " + email +
                ", city : " + city +
                ", country : " + country +
                ", gender : " + gender +
                ", dateOfBirth : " + dateOfBirth +
                ", premiumEnabled : " + premiumEnabled +
                "}";
    }
}
