




	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

import prs.util.DBUtil;


	public class UserDB {
		
		private Connection getConnection() throws SQLException {
			String dbUrl = "jdbc:mysql:localhost:3306/prs";
			String userName = "prs_user";
			String password = "sesame";
			try {

				Class.forName("com.mysql.jdbc.Driver").newInstance();

			}

			catch (ClassNotFoundException cnfe) {

				System.out.println(cnfe);
				

			} catch (InstantiationException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			} catch (IllegalAccessException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();
				

			}

			Connection connection = DriverManager.getConnection(dbUrl, userName, password);

			return connection;
		}
		


		public List<User> getAll() {

			String sql = "SELECT * FROM user";

			List<User> users = new ArrayList<>();

			try (Connection connection = DBUtil.getConnection();

				 PreparedStatement ps = connection.prepareStatement(sql);

				 ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {

					String userName = rs.getString(2);

					String password = rs.getString(3);

					String firstName = rs.getString(4);

					String lastName = rs.getString(5);

					String phoneNumber = rs.getString(6);
					
					String email = rs.getString(7);

					User u = new User(userName, password, firstName, lastName, phoneNumber, email);

					users.add(u);
					
				}	
				
			} catch (SQLException e) {

				e.printStackTrace();

			}

			return users;

		}


		public List<User> get(String firstName, String lastName) {
			String sql = "SELECT* FROM user WHERE firstName = ? AND lastName = ?";
			List <User> users = new ArrayList<>();
			try (Connection connection = DBUtil.getConnection();
					PreparedStatement ps = connection.prepareStatement(sql)) {
				ps.setString(1, firstName);
				ps.setString(2, lastName);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String userName = rs.getString(1);

					String password = rs.getString(2);

					String fN = rs.getString(3);

					String lN = rs.getString(4);

					String phoneNumber = rs.getString(5);
					
					String email = rs.getString(6);

					
					
					User u = new User(userName, password, fN, lN, phoneNumber, email);

					users.add(u);

					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return users;
		}
	

		// not implemented yet
		public static boolean add(String userName, String password, String firstName, String lastName, String phoneNumber,
								  String email) {
			String sql = "INSERT INTO user (username, password, firstname, password, phonenumber, email)"  
					+" VALUES (?, ?, ?, ?, ?, ?)";
			try (Connection connection = DBUtil.getConnection();
					PreparedStatement ps = connection.prepareStatement(sql)) {
				ps.setString(1, userName);
				ps.setString(2, password);
				ps.setString(3, firstName);
				ps.setString(4, lastName);
				ps.setString(5, phoneNumber);
				ps.setString(6, email);
				
				ps.executeUpdate();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}

		


		public String get() {
			// TODO Auto-generated method stub
			return null;
		}


		public boolean add() {
			// TODO Auto-generated method stub
			return false;
		}


		public boolean update() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean delete() {
			// TODO Auto-generated method stub
			return false;
		}

	
	}



