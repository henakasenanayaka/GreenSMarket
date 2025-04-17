package com.servlets;

class user {
    private static String fName;
    private static String lName;
    private static String email;
    private static String password;
    private static String add;
    private static String mobile;

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAdd() {
        return add;
    }

    public String getMobile() {
        return mobile;
    }

    public user(String fName, String lName, String email, String password, String add, String mobile) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.add = add;
        this.mobile = mobile;
    }
}
