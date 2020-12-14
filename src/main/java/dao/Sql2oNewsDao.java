package dao;

import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;


public class Sql2oNewsDao implements NewsDao {
    private final Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(News news) {
        String sql = "INSERT INTO news(newsTitle, newsContent, departmentId) VALUES (:newsTitle, :newsContent, :departmentId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);

        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void addNewsToDepartment(News news, DepartmentDao.Department department) {

    }

    @Override
    public List<News> getAll() {
        return null;
    }

    @Override
    public News findById(int id) {
        return null;
    }

    @Override
    public List<News> getAllNewsByDepartment(int departmentId) {
        return null;
    }

    @Override
    public List<News> getNewsByDepartment(int departmentId) {
        return null;
    }

    @Override
    public void update(int id, String newsTitle, String newsContent, int departmentId) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}

//    public void clearAll() {
//
//    }