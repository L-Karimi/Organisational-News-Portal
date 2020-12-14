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
        private int departmentEmployeesNumber;

        public Department(String servicing, String repairs, int i) {

        }

        public void setId(int id) {

        }

        public int getId() {

            return 0;
        }

        public int getDepartmentEmployeesNumber() {
            return departmentEmployeesNumber;
        }

        public void setDepartmentEmployeesNumber(int departmentEmployeesNumber) {
            this.departmentEmployeesNumber = departmentEmployeesNumber;
        }

        public String getDepartmentDescription() {
            return null;
        }

        public String getDepartmentName() {
            return null;
        }
    }
}