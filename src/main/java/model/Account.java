/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Jackt
 */
public class Account {
    private int id;
    private String username;
    private String password;

    // Constructor
    public Account(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;  // Mật khẩu đã mã hóa (sử dụng các phương thức mã hóa trước khi lưu vào DB)
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // ToString method to print Account info
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +  // Lưu ý không nên in mật khẩu trong môi trường thực tế
                '}';
    }
}
