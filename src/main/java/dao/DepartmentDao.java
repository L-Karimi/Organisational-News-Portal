package dao;

import models.Department;

public interface DepartmentDao {
    //create
    void add(Department department);
    void addDepartmentToUser(Department department, User user);

}
