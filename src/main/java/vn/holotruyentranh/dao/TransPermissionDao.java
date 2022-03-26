package vn.holotruyentranh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import vn.holotruyentranh.beans.TransPermission;

public class TransPermissionDao {
	private JdbcTemplate jdbcTemplate;

	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public void save(TransPermission transpemission) {
		String sql = "INSERT INTO transpermission (IDtransper, transperName) VALUES (NULL, '"			
				+ transpemission.getTransperName() + "')";
		jdbcTemplate.update(sql);
	}

	public void delete(int id) {
		String sql = "DELETE FROM transpermission WHERE IDtransper = " + id + "";
		jdbcTemplate.update(sql);
	}

	public void update(TransPermission transpemission) {
		String sql = "UPDATE transpermission SET transperName = '" + transpemission.getTransperName() +
				"' WHERE IDtransper = " + transpemission.getIDtransper() + "";
		jdbcTemplate.update(sql);
	}
	
	public TransPermission findOne(int id) {
	    String sql = "SELECT * FROM transpermission WHERE IDtransper =" + id;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<TransPermission>() {
	        @Override
	        public TransPermission extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	TransPermission transpemission = new TransPermission();
					transpemission.setIDtransper(rs.getInt(1));
					transpemission.setTransperName(rs.getString(2));
					return transpemission;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	public List<TransPermission> findAll() {
		return jdbcTemplate.query("SELECT * FROM transpermission", new RowMapper<TransPermission>() {
			public TransPermission mapRow(ResultSet rs, int row) throws SQLException {
				TransPermission transpemission = new TransPermission();
				transpemission.setIDtransper(rs.getInt(1));
				transpemission.setTransperName(rs.getString(2));
				return transpemission;
			}
		});
	}
}
