package com.cognitive.cogdemver.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    @NotEmpty(message = "email can't be empty")
    @Email
    private String email;
    private String phone;

    @NotEmpty(message = "password can't be empty")
    @Size(min = 8, message = "Password should be greater than 8 symbols")
    private String password;

    @NotEmpty(message = "username can't be empty")
    @Size(min = 2, max = 50, message = "username should be between 2 and 50 symbols")
    private String username;
    private String name;
    private String surname;

    @NotNull
    private boolean active;

    private String role;
    private LocalDate dateOfCreate;

    public String getUuid() {
        return uuid;
    }

    public User setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public User setActive(boolean active) {
        this.active = active;
        return this;
    }

    public String getRole() {
        return role;
    }

    public User setRole(String role) {
        this.role = role;
        return this;
    }

    public LocalDate getDateOfCreate() {
        return dateOfCreate;
    }

    public User setDateOfCreate(LocalDate dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;

        return active == user.active &&
                Objects.equals(uuid, user.uuid) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(password, user.password) &&
                Objects.equals(username, user.username) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(role, user.role) &&
                Objects.equals(dateOfCreate, user.dateOfCreate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                uuid,
                email,
                phone,
                password,
                username,
                name,
                surname,
                active,
                role,
                dateOfCreate
        );
    }
}
