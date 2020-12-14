package dao;

import models.News;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;


public class Sql2oNewsDaoTest {

    private static Connection conn;
    private static Sql2oDepartmentDao departmentsDao;
    private static Sql2oNewsDao newsDao;
    private static Sql2oUserDao usersDao;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/myorg_test";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "lucy");
        departmentsDao = new Sql2oDepartmentDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        usersDao = new Sql2oUserDao(sql2o);
//        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        departmentsDao.clearAll();
        newsDao.clearAll();
        usersDao.clearAll();
//        conn.close();
    }

    @AfterClass
    public static void shutDown() throws Exception{
//        conn.close();
        System.out.println("connection closed");
    }


    public News setUpNews(){
        News testNews = new News("Money", "The finances are crazy");
        newsDao.add(testNews);
        return testNews;
    }

    public News setUpAltNews(){
        News altTestNews = new News("Terms", "Conditions", 2);
        newsDao.add(altTestNews);
        return altTestNews;
    }

    @Test
    public void returnsTheIdOfNewsInstanceCorrectly(){
        News testNews = setUpNews();
        assertEquals(testNews.getId(), testNews.getId());
    }

    @Test
    public void news_instantiatesCorrectly_true(){
        News testNews = setUpNews();
        assertEquals(true, testNews instanceof News);
    }
    @Test
    public void deletingADepartmentAlsoUpdatesTheNewDepartmentJointTable(){
        DepartmentDao.Department testDepartment = new DepartmentDao.Department("Finance", "Money", 1232);
        departmentsDao.add(testDepartment);
        DepartmentDao.Department altTestDepartment = new DepartmentDao.Department("Food", "catering", 100);
        departmentsDao.add(altTestDepartment);

        News testNews = setUpNews();
        newsDao.add(testNews);

        newsDao.addNewsToDepartment(testNews, testDepartment);
        newsDao.addNewsToDepartment(testNews, altTestDepartment);

        newsDao.deleteById(testDepartment.getId());
        assertEquals(0, newsDao.getNewsByDepartment(testDepartment.getId()).size());

    }

}