import static spark.Spark.*;
import com.google.gson.Gson;
import exceptions.ApiException;
import models.*;
import dao.*;
import org.sql2o.Sql2o;
import org.sql2o.Connection;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class App {

    public static void main(String[] args) {

        staticFileLocation("/public");

        Sql2oDepartmentDao departmentsDao;
        Sql2oNewsDao newsDao;
        Sql2oUserDao usersDao;

        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");


        departmentsDao = new Sql2oDepartmentDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        usersDao = new Sql2oUserDao(sql2o);

        conn = sql2o.open();


        get("/", "application/json", (req, res) ->
                "{\"message\":\"Welcome to the main page of ORGANISATIONAL API.\"}");


        post("/news/new", "application/json", (req, res) -> {
            News news = gson.fromJson(req.body(), News.class);
            newsDao.add(news);
            res.status(201);
            return gson.toJson(news);
        });


        get("/news", "application/json", (req, res) -> {
            System.out.println(newsDao.getAll());

            if(newsDao.getAll().size() > 0) {
                return gson.toJson(newsDao.getAll());
            }
            else{
                return "{\"message\":\"I'm sorry, but no news items are currently listed in the database.\"}";
            }
        });

        get("/news/:id", "application/json", (req, res) -> {
            int newsId = Integer.parseInt(req.params("id"));
            News newsToFind = newsDao.findById(newsId);
            if (newsToFind == null){
                throw new ApiException(404, String.format("No news item with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(newsToFind);
        });

        post("/department/new", "application/json", (req, res)->{
            DepartmentDao.Department department = gson.fromJson(req.body(), (Type) Department.class);
            departmentsDao.add(department);
            res.status(201);
            return gson.toJson(department);
        });

        get("/departments", "application/json", (req, res) -> {
            System.out.println(departmentsDao.getAll());

            if(departmentsDao.getAll().size() > 0){
                return gson.toJson(departmentsDao.getAll());
            }

            else {
                return "{\"message\":\"I'm sorry, but no departments are currently listed in the database.\"}";
            }

        });


        get("/department/:id", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));
            DepartmentDao.Department departmentToFind = departmentsDao.findById(departmentId);
            if (departmentToFind == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(departmentToFind);
        });


        get("/department/:id/news", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));

            DepartmentDao.Department departmentToFind = departmentsDao.findById(departmentId);
            List<News> departmentNews;

            if (departmentToFind == null) {
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }

            departmentNews = newsDao.getAllNewsByDepartment(departmentId);
            res.type("application/json");
            return gson.toJson(departmentNews);
        });


        get("/department/:id/users", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));

            DepartmentDao.Department departmentToFind = departmentsDao.findById(departmentId);
            List<User> departmentUsers;

            if (departmentToFind == null) {
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }

            departmentUsers = usersDao.getAllUsersByDepartment(departmentId);
            res.type("application/json");
            return gson.toJson(departmentUsers);
        });

        post("/user/new", "application/json", (req, res)->{
            User user = gson.fromJson(req.body(), User.class);
            usersDao.add(user);
            res.status(201);
            return gson.toJson(user);
        });

        get("/users", "application/json", (req, res) -> {
            System.out.println(usersDao.getAllUsers());

            if(usersDao.getAllUsers().size() > 0){
                return gson.toJson(usersDao.getAllUsers());
            }

            else{
                return "{\"message\":\"I'm sorry, but no users are currently listed in the database.\"}";
            }
        });



    }
    }
