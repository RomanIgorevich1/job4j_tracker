package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс пользователь, содержит поля:
 *номер паспорта, ФИО пользователя.
 */
public class User {
    private String username;
    private String passport;

    public User(String username, String passport) {
        this.username = username;
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return Objects.equals(passport, user.passport);
    }
}
