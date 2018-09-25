import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import prs.util.DBUtil;

public class ProductDB {
	public List<Product> getAll() {
        String sql = "SELECT * FROM PRODUCT";
        List<Product> products = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt(1);
                int vendorID = rs.getInt(2);
                String partNum = rs.getString(3);
                String name = rs.getString(4);
                double price = rs.getDouble(5);
                String unit = rs.getString(6);
                
                Product p = new Product(id, vendorID, partNum, name, price, unit);
                products.add(p);
            }
            return products;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
	}
	public Product get(String partNumber, int VendorID) {
		String sql = "SELECT * FROM product WHERE partnumber = ?"
				+ "AND VendorID = ?";
		try (Connection connection = DBUtil.getConnection();
	             PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, partNumber);
			ps.setInt(2, VendorID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
                int vendorID = rs.getInt(2);
                String partNum = rs.getString(3);
                String name = rs.getString(4);
                double price = rs.getDouble(5);
                String unit = rs.getString(6);
				
                Product product= new Product(vendorID, partNum, name, price, unit);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
	public boolean add(Product p) {
        String sql = "INSERT INTO product(VendorID, PartNumber, Name, Price)" + 
        		"VALUES(?, ?, ?, ?);";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, p.getVendorID());
            ps.setString(2, p.getPartNumber());
            ps.setString(3, p.getName());
            ps.setDouble(4, p.getPrice());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

}
