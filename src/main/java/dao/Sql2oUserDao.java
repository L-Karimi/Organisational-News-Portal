package dao;
import models.News;
import models.User;

import java.util.ArrayList;
import java.util.List;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

public class Sql2oUserDao implements UserDao{

    private final Sql2o sql2o;

    public Sql2oUserDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(User user) {
        String sql = "INSERT INTO users (userName, userCompanyPosition, userCompanyRole, departmentId) VALUES (:userName, :userCompanyPosition, :userCompanyRole, :departmentId)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM users")
                    .executeAndFetch(User.class);
        }
    }

    @Override
    public User findUserById(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsersByDepartment(int departmentId) {
        return null;
    }

    @Override
    public void update(int id, String userName, String userCompanyPosition, String useCompanyRole, int departmentId) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}
