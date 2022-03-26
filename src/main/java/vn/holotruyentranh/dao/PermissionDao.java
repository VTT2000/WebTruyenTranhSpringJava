package vn.holotruyentranh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import vn.holotruyentranh.beans.Permission;

public class PermissionDao {
	private JdbcTemplate jdbcTemplate;

	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public void save(Permission permission) {
		String sql = "INSERT INTO permission (IDper, permission) VALUES (NULL, '"			
				+ permission.getPermission() + "')";
		jdbcTemplate.update(sql);
	}

	public void delete(int id) {
		String sql = "DELETE FROM permission WHERE IDper = " + id + "";
		jdbcTemplate.update(sql);
	}

	public void update(Permission permission) {
		String sql = "UPDATE permission SET permission = '" + permission.getPermission() +
				"' WHERE IDper = " + permission.getIDper() + "";
		jdbcTemplate.update(sql);
	}
	
	public Permission findOne(int id) {
	    String sql = "SELECT * FROM permission WHERE IDper =" + id;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Permission>() {
	        @Override
	        public Permission extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	Permission permission = new Permission();
					permission.setIDper(rs.getInt(1));
					permission.setPermission(rs.getString(2));
					return permission;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	public List<Permission> findAll() {
		return jdbcTemplate.query("SELECT * FROM permission", new RowMapper<Permission>() {
			public Permission mapRow(ResultSet rs, int row) throws SQLException {
				Permission permission = new Permission();
				permission.setIDper(rs.getInt(1));
				permission.setPermission(rs.getString(2));
				return permission;
			}
		});
	}
}
