package com.example;

import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
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
    private TextField date = new TextField("Start date");
    private Button save = new Button("Edit", e -> saveEmployee());
    private Button delete = new Button("Delete", e -> deleteEmployee());
    private Button add = new Button("Add", e -> addEmployee());


    @Override
    protected void init(VaadinRequest request) {
        date.setPlaceholder("yyyy-mm-dd");
        updateGrid();
        grid.setColumns("firstname", "lastname", "email", "salary", "role", "date");
        grid.addSelectionListener(e -> updateForm());
        grid.setWidth("1000");

        binder.bindInstanceFields(this);

        VerticalLayout part1 = new VerticalLayout(firstName, lastName, email);
        VerticalLayout part2 = new VerticalLayout(salary, role, date);
        HorizontalLayout part3 = new HorizontalLayout(save, delete, add);
        HorizontalLayout input = new HorizontalLayout(part1, part2);
        VerticalLayout layout = new VerticalLayout(grid, input, part3);
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
