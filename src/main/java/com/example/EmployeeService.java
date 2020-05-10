package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class EmployeeService {
// przypisanie danych z database do instancji klasy
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT ID, FirstName, LastName, Email, Salary, Role FROM employees",
                (rs, rowNum) -> new Employee(rs.getInt("ID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), rs.getString("Salary"), rs.getString("Role")));
    }
//edycja
    public void update(Employee employee) {
        jdbcTemplate.update("UPDATE employees SET FirstName=?, LastName=?, Email=?, Salary=?, Role=? WHERE ID=?",
                employee.getFirstname(), employee.getLastname(), employee.getEmail(), employee.getSalary(), employee.getRole(), employee.getId());
    }

//usunięcie
    public void delete(Employee employee) {
        jdbcTemplate.update("DELETE FROM employees WHERE ID=?",
                employee.getId());
    }

//dodanie
    public void add(String fname, String lname, String email, String salary, String role) {

        jdbcTemplate.update("INSERT INTO `webapp`.`employees` (`FirstName`, `LastName`, `Email`, `Salary`, `Role`) " +
                        "VALUES (?,?,?,?,?)",
                fname, lname, email, salary, role);
}

}
