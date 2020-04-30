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

    private Binder<Employee> binder = new Binder<>(Employee.class);

    private Grid<Employee> grid = new Grid(Employee.class);
    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private TextField email = new TextField("Email");
    private TextField salary = new TextField("Salary");
    private TextField role = new TextField("Role");
    private Button save = new Button("Save", e -> saveEmployee());

    @Override
    protected void init(VaadinRequest request) {
        updateGrid();
        grid.setColumns("firstname", "lastname", "email", "salary", "role");
        grid.addSelectionListener(e -> updateForm());
        grid.setWidth("1000");

        binder.bindInstanceFields(this);

        VerticalLayout test = new VerticalLayout(firstName, lastName, email, salary, role, save);
        HorizontalLayout layout = new HorizontalLayout(grid, test);
        setContent(layout);

    }

    private void updateGrid() {
        List<Employee> employees = service.findAll();
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

}
