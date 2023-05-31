/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author rkrah
 */
public class Person {

    private int id;
    private String full_name;
    private String user_name;
    private String password;
    private String mobile_number;
    private String email;
    private String district;
    private String post_code;

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

   

    public int getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public String getEmail() {
        return email;
    }

    public String getDistrict() {
        return district;
    }

   

}
