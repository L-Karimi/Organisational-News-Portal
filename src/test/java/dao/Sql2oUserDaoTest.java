package dao;
import models.User;
import org.junit.*;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import static org.junit.Assert.*;


public class Sql2oUserDaoTest {

    private static Connection conn;
    private static Sql2oDepartmentDao departmentDao;
    private static Sql2oNewsDao newsDao;
    private static Sql2oUserDao userDao;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/myorg_test";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "lucy");
        departmentDao = new Sql2oDepartmentDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        userDao = new Sql2oUserDao(sql2o);
//        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        departmentDao.clearAll();
        newsDao.clearAll();
        userDao.clearAll();
//        conn.close();
    }

    @AfterClass
    public static void shutDown() throws Exception{
//        conn.close();
        System.out.println("connection closed");
    }


    public User setUpUser(){
        User testUser = new User("Millie", "Secretary", "Writer", 12);
        userDao.add(testUser);
        return testUser;
    }

    public User setUpAltUser(){
        User testAltUser = new User("Mildred", "Janitor", "Recording", 8);
        userDao.add(testAltUser);
        return testAltUser;
    }

    @Test
    public void instantiatesCorrectly(){
        User testUser = setUpUser();
        assertEquals(true, testUser instanceof User);
    }

    @Test
    public void returnsTheRightId(){
        User testUser = setUpUser();
        assertEquals(testUser.getId(), testUser.getId());
    }

}