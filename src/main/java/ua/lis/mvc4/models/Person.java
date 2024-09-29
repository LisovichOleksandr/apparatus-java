package ua.lis.mvc4.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;

    @NotEmpty(message = "name should not be empty") //ограничение на пустую строку, message - сообщение об ошибке
    @Size(min = 2, max = 30, message = "Name should be between 2 and 20") // ограничения на размер
    private String namelogin;

    @Min(value = 0, message = "Age should be greater than 0") //минимальное значение
    private int age;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid") // проверяет что в строке лежит именно email
    private String email;

    public Person(){
        //id -- по умолчанию 0, name -- null
    }

    public Person(int id, String namelogin, int age, String email) {
        this.id = id;
        this.namelogin = namelogin;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamelogin() {
        return namelogin;
    }

    public void setNamelogin(String namelogin) {
        this.namelogin = namelogin;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
