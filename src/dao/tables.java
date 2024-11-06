
package dao;

import javax.swing.JOptionPane;


public class tables {
    public static void main(String[] args){
        try{
           
           String userTable = "create table user1(id int primary key, name varchar(200),email varchar(200),mobileNumber varchar(200),address varchar(200),password varchar(200),securityQuestion varchar(200),answer varchar(200),status varchar(20),UNIQUE (email))";
           String adminDetails = "insert into user1(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('Admin','admin@gmail.com','9234568912','solapur','admin','what is the name of your favorite book?','Shyamchi Aai','true')";
           String categoryTable = "create table category(id int primary key, name varchar(200))";
           String productTable = "create table product(id int primary key , name varchar(200),category varchar(200), price varchar(200))";
           String billTable = "create table bill(id int primary key, name varchar(200), mobileNumber varchar(200),email varchar(200),date varchar(50),total varchar(200),createdBy varchar(200))";
           DbOperations.setDataOrDelete(userTable, "User Table Created Successfully");
           DbOperations.setDataOrDelete(adminDetails, "Admin Details Added Successfully");
           DbOperations.setDataOrDelete(categoryTable, "Category Table Created Successfully");
           DbOperations.setDataOrDelete(productTable, "Product Table Created Successfully");
           DbOperations.setDataOrDelete(billTable, "Bill Table Created Successfully");
        }
    
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
}
}