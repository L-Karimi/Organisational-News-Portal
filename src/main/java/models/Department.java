package models;

import java.util.Objects;

public class Department {
    private String departmentName;
    private String departmentDescription;
    private int departmentEmployeesNumber;
    private int id;


    public Department(String departmentName, String departmentDescription, int departmentEmployeesNumber) {
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
        this.departmentEmployeesNumber = departmentEmployeesNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return departmentEmployeesNumber == that.departmentEmployeesNumber &&
                id == that.id &&
                departmentName.equals(that.departmentName) &&
                departmentDescription.equals(that.departmentDescription);
    }
}