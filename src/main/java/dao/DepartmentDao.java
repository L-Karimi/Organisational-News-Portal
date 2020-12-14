package dao;
import models.*;
import java.util.List;

public interface DepartmentDao {


    void add(Department department);
    void addDepartmentToUser(Department department, User user);


    List<Department> getAll();
    Department findById(int id);
    List<User> getAllUsersByDepartment(int departmentId);


    void update(int id, String departmentName, String departmentDescription, int departmentEmployeesNumber);


    void deleteById(int id);
    void clearAll();

    class Department {
        public void setId(int id) {

        }

        public int getId() {

            return 0;
        }
    }
}