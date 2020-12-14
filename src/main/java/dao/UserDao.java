package dao;
import models.*;
import java.util.List;

public interface UserDao {


    void add (User user);


    List<User> getAllUsers();
    User findUserById(int id);
    List<User> getAllUsersByDepartment(int departmentId);


    void update(int id, String userName,  String userCompanyPosition, String useCompanyRole, int departmentId);


    void deleteById(int id);
    void clearAll();

}