package com.secure.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    @NotEmpty(message = " Поле username не должно быть пустым!")
    @Size(min = 2, max = 100, message = "Поле username должно содержать от 2 до 100 символов!")
    private String username;
    @Column(name = "age")
    @Min(value = 0, message = "Возраст не может быть отрицательным!")
    private int age;

    @Column(name = "password")
    private String password;

    public Person(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
