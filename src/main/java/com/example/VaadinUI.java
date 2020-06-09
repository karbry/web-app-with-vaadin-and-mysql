package com.example;

import com.vaadin.data.Binder;


import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import javafx.scene.control.DatePicker;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.flow.component.textfield.NumberField;
import java.util.List;

//@CssImport("sciezka")
@SpringUI

public class VaadinUI extends UI {

    @Autowired
    private EmployeeService service;
    private Employee employee;
    private List<Employee> employees;
    private Binder<Employee> binder = new Binder<>(Employee.class);

    private Grid<Employee> grid = new Grid(Employee.class);
    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private TextField email = new TextField("Email");
    private TextField salary = new TextField("Salary");
    private TextField role = new TextField("Role");
    private Button save = new Button("Save", e -> saveEmployee());
    private Button delete = new Button("Delete", e -> deleteEmployee());
    private Button add = new Button("Add", e -> addEmployee());
    //private DatePicker date = new DatePicker();

    @Override
    protected void init(VaadinRequest request) {
        updateGrid();
        grid.setColumns("firstname", "lastname", "email", "salary", "role");
        grid.addSelectionListener(e -> updateForm());
        grid.setWidth("1000");

        binder.bindInstanceFields(this);

        VerticalLayout input = new VerticalLayout(firstName, lastName, email, salary, role, save, delete, add);
        HorizontalLayout layout = new HorizontalLayout(grid, input);
        setContent(layout);

    }

    private void updateGrid() {
        employees = service.findAll();
        grid.setItems(employees);

    }

    private void updateForm() {

        employee = grid.asSingleSelect().getValue();
        binder.setBean(employee);
    }

    private void saveEmployee() {
        service.update(employee);
        updateGrid();
    }

    private void deleteEmployee() {
        service.delete(employee);
        updateGrid();
    }

    private void addEmployee() {

        service.add(firstName.getValue(), lastName.getValue(), email.getValue(), salary.getValue(), role.getValue());
        updateGrid();

    }

}
