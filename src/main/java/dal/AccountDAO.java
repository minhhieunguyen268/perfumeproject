/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;

/**
 *
 * @author Jackt
 */
public class AccountDAO extends DBConnect{
    
   
  // Thêm tài khoản mới vào cơ sở dữ liệu
    public void addAccount(Account account) {
        String query = "INSERT INTO Account (username, password) VALUES (?, ?)";
        try {
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getPassword()); // Mật khẩu đã được mã hóa
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Account login(String username, String password){
        String query = "select * from Account where username = ? and password = ?";
        try{
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setString(1,username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Account acc = new Account(rs.getInt(1), rs.getString(2), rs.getString(3));
                return acc;
            }
        }catch(Exception e){
           e.printStackTrace();
        }
         return null;
    }
    
    public boolean getUser(String username){
        String query = "select * from Account where username = ?";
        
        try {
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if(rs.next() == true){
                return true;
            }
        } catch (Exception e) {
        }
        return false; 
    }
}
