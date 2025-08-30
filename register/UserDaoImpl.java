package register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	public void insert(User user) {
		String sql = "INSERT INTO [User](email, username, fullname, password, avatar, roleid,phone,createddate) VALUES (?,?,?,?,?,?,?,?)";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getFullName());
			ps.setString(4, user.getPassWord());
			ps.setString(5, user.getAvatar());
			ps.setInt(6, user.getRoleid());
			ps.setString(7, user.getPhone());
			ps.setDate(8, new java.sql.Date(user.getCreatedDate().getTime()));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from [user] where email = ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from [User] where username = ?";
		try {
			conn = new DBconnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}
	@Override
	public boolean checkExistPhone(String phone) {
	    boolean duplicate = false;
	    String query = "select * from [User] where phone = ?";
	    try {
	        conn = new DBconnection().getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setString(1, phone);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            duplicate = true;
	        }
	        ps.close();
	        conn.close();
	    } catch (Exception ex) {
	    }
	    return duplicate;
	}
}
