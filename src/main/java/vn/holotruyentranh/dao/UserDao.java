package vn.holotruyentranh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import vn.holotruyentranh.beans.User;

public class UserDao {
	private JdbcTemplate jdbcTemplate;

	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public void save(User user) {
		String sql = "INSERT INTO user (IDuser, mail, password, username, created, updated, IDteam, IDtransper, IDper) VALUES (NULL, '"
				+ user.getMail() + "', '" 
				+ user.getPassword() + "', '" 
				+ user.getUsername() + "', '"
				+ user.getCreated() + "', '"
				+ user.getUpdated() + "', '"
				+ user.getIDteam() + "', '"
				+ user.getIDtransper() + "', '"				
				+ user.getIDper() + "')";
		jdbcTemplate.update(sql);
	}

	public void delete(int id) {
		String sql = "DELETE FROM user WHERE IDuser = " + id + "";
		jdbcTemplate.update(sql);
	}

	public void update(User user) {
		String sql = "UPDATE user SET mail = '" + user.getMail() + 
				"', password = '" + user.getPassword() + 
				"', username = '" + user.getUsername() + 
				"', created = '" + user.getCreated() + 
				"', updated = '" + user.getUpdated() +
				"', IDteam = '" + user.getIDteam() +
				"', IDtransper = '" + user.getIDtransper() +
				"', IDper = '" + user.getIDper() +
				"' WHERE IDuser = " + user.getIDuser() + "";
		jdbcTemplate.update(sql);
	}
	
	public User findOne(int id) {
	    String sql = "SELECT * FROM user WHERE IDuser =" + id;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {
	 
	        @Override
	        public User extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	User user = new User();
					user.setIDuser(rs.getInt(1));
					user.setMail(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setUsername(rs.getString(4));
					user.setCreated(rs.getString(5));
					user.setUpdated(rs.getString(6));
					user.setIDteam(rs.getInt(7));
					user.setIDtransper(rs.getInt(8));
					user.setIDper(rs.getInt(9));
					return user;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	public List<User> findAll() {
		return jdbcTemplate.query("SELECT * FROM user", new RowMapper<User>() {
			public User mapRow(ResultSet rs, int row) throws SQLException {
				User user = new User();
				user.setIDuser(rs.getInt(1));
				user.setMail(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setUsername(rs.getString(4));
				user.setCreated(rs.getString(5));
				user.setUpdated(rs.getString(6));
				user.setIDteam(rs.getInt(7));
				user.setIDtransper(rs.getInt(8));
				user.setIDper(rs.getInt(9));
				return user;
			}
		});
	}
}
