/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *
 * @author Jackt
 */
public class ProductDAO extends DBConnect{
    
    
        public List<Product> readListProduct() {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM Product";
        try {
            PreparedStatement stmt = c.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // Lấy dữ liệu từ ResultSet và tạo đối tượng Product
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getInt("category_id"),
                        rs.getInt("cell_id")
                );
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }


    // Phương thức thêm một sản phẩm vào bảng Product
    public void addProduct(Product product) {
        String query = "INSERT INTO Product (name, price, description, image, category_id, cell_id) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());  // Sử dụng setDouble thay vì setBigDecimal
            stmt.setString(3, product.getDescription());
            stmt.setString(4, product.getImage());
            stmt.setInt(5, product.getCategoryId());
            stmt.setInt(6, product.getCellId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Phương thức cập nhật thông tin sản phẩm
    public void updateProduct(Product product) {
        String query = "UPDATE Product SET name = ?, price = ?, description = ?, image = ?, category_id = ?, cell_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());  // Sử dụng setDouble thay vì setBigDecimal
            stmt.setString(3, product.getDescription());
            stmt.setString(4, product.getImage());
            stmt.setInt(5, product.getCategoryId());
            stmt.setInt(6, product.getCellId());
            stmt.setInt(7, product.getId()); // Cập nhật theo id của sản phẩm
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Phương thức xóa một sản phẩm theo id
    public void deleteProduct(int id) {
        String query = "DELETE FROM Product WHERE id = ?";
        try {
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Phương thức lấy sản phẩm theo id
    public Product getProductById(int id) {
        String query = "SELECT * FROM Product WHERE id = ?";
        try {
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Lấy giá trị price dưới dạng double
                double price = rs.getDouble("price");

                // Tạo đối tượng Product với kiểu dữ liệu double cho giá
                return new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        price,
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getInt("category_id"),
                        rs.getInt("cell_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Trả về null nếu không tìm thấy sản phẩm
    }
}
