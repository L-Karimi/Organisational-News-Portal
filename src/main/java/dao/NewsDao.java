package dao;
import models.*;
import java.util.List;

public interface NewsDao {

    void add(News news);
    void addNewsToDepartment(News news, DepartmentDao.Department department);


    List<News> getAll();
    News findById(int id);
    List<News> getAllNewsByDepartment(int departmentId);

    List<News> getNewsByDepartment(int departmentId);



    void update(int id, String newsTitle, String newsContent,int departmentId);

    void deleteById(int id);
    void clearAll();

}