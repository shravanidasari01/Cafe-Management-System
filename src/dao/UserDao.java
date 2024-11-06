package dao;

import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author leneo
 */
public class UserDao {

    public static void save(User user1) {
        String query = "insert into user1(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('" + user1.getName() + "','" + user1.getEmail() + "','" + user1.getMobileNumber() + "','" + user1.getAddress() + "','" + user1.getPassword() + "','" + user1.getSecurityQuestion() + "','" + user1.getAnswer() + "','false')";
        DbOperations.setDataOrDelete(query, "Registered Successfully! Wait for Admin Approval!");
    }
    
    public static User login(String email, String password) {
        User user1 = null;
        try {
            ResultSet rs = DbOperations.getData("select *from user1 where email='" + email + "' and password='" + password + "'");
            while (rs.next()) {
                user1 = new User();
                user1.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user1;
    }

    public static User getSecurityQuestion(String email) {
        User user1 = null;
        try {
            ResultSet rs = DbOperations.getData("Select *from user1 where email = '" + email + "'");
            while(rs.next()){
                user1=new User();
                user1.setSecurityQuestion(rs.getString("securityQuestion"));
                user1.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user1;
    }
    public static void update(String email, String newPassword){
    String query = "update user1 set password = '" + newPassword +"' where email='"+email +"'";
    DbOperations.setDataOrDelete(query, "Password Changed Successfully");
}
    public static ArrayList<User> getAllRecords(String email){
        ArrayList<User> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select *from user1 where email like '%"+email+"%'");
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setAddress(rs.getString("address"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    public static void changeStatus(String email, String status){
        String query = "update user1 set status='"+status+"' where email ='"+email+"'";
        DbOperations.setDataOrDelete(query,"Status Changed Successfully");
    }
    public static void changePassword(String email, String oldPassword, String newPassword){
     try{
          ResultSet rs =DbOperations.getData("select *from user1 where email ='"+email+"' and password='"+oldPassword+"'");
          if(rs.next()){
          update(email, newPassword);
          }
          else{
              JOptionPane.showMessageDialog(null, "Old Password is Wrong");
          }
     }
     catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
     }
}
}