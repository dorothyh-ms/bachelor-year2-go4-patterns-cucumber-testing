package domain.employees;

import domain.users.User;

import java.util.List;

public class Employee extends User {
    private List<EmployeeRole> roles;
}
