package com.example;

public class Employee {

    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String salary; //na razie string, bo numberfield coś nie działa potem trzeba zmienić na float/ int
    private String role;
    private String date; //trzeba ogarnąć konwersje zmiennej typu data z mysql do javy

    public Employee(int id, String firstname, String lastname, String email, String salary, String role/*, String date */) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.salary = salary;
        this.role = role;
        //this.date = date;
    }

    public Employee() {

    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}