package models;

import java.util.Objects;

public class User {

    private String userName;
    private String userCompanyPosition;
    private String userCompanyRole;
    private int departmentId;
    private int id;


    public User(String userName, String userCompanyPosition, String userCompanyRole, int departmentId) {
        this.userName = userName;
        this.userCompanyPosition = userCompanyPosition;
        this.userCompanyRole = userCompanyRole;
        this.departmentId = departmentId;

    }


//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getUserCompanyPosition() {
//        return userCompanyPosition;
//    }
//
//    public void setUserCompanyPosition(String userCompanyPosition) {
//        this.userCompanyPosition = userCompanyPosition;
//    }
//
//    public String getUserCompanyRole() {
//        return userCompanyRole;
//    }
//
//    public void setUserCompanyRole(String userCompanyRole) {
//        this.userCompanyRole = userCompanyRole;
//    }
//
//    public int getDepartmentId() {
//        return departmentId;
//    }
//
//    public void setDepartmentId(int departmentId) {
//        this.departmentId = departmentId;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
}
