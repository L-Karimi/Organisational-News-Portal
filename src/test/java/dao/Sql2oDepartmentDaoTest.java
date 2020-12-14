package dao;

import models.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;


public class Sql2oDepartmentDaoTest {

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
    }

    @AfterClass
    public static void shutDown() throws Exception{
//        conn.close();
        System.out.println("connection closed");
    }


    public DepartmentDao.Department setUpDepartment (){
        DepartmentDao.Department department =  new DepartmentDao.Department("Servicing", "Repairs", 205);
        departmentsDao.add(department);
        return department;
    }

    public DepartmentDao.Department setUpAltDepartment(){
        DepartmentDao.Department altDepartment = new DepartmentDao.Department("Shipping", "Sailing", 329);
        departmentsDao.add(altDepartment);
        return altDepartment;
    }

    public User setUpUser(){
        User user = new User("Michelle", "Secretary", "Writing", 2);
        usersDao.add(user);
        return user;
    }

    public User setUpAltUser(){
        User altUser = new User("Gideon","Manager", "Oversight", 2);
        usersDao.add(altUser);
        return altUser;
    }

    @Test
    public void savesOneInstanceCorrectlyAndGetsRightId_true(){
        DepartmentDao.Department testDepartment = new DepartmentDao.Department("Servicing", "Repairs", 208);
        assertEquals(0, testDepartment.getId());
    }


    @Test
    public void deletingADepartmentAlsoUpdatesTheJointTable(){
        DepartmentDao.Department testDepartment = setUpDepartment();
        departmentsDao.add(testDepartment);
        DepartmentDao.Department altTestDepartment = setUpAltDepartment();
        departmentsDao.add(altTestDepartment);

        User testUser = setUpUser();
        usersDao.add(testUser);

        departmentsDao.addDepartmentToUser(testDepartment, testUser);
        departmentsDao.addDepartmentToUser(altTestDepartment, testUser);

        departmentsDao.deleteById(testDepartment.getId());

        assertEquals(0, departmentsDao.getAllUsersByDepartment(testDepartment.getId()).size());
    }

}