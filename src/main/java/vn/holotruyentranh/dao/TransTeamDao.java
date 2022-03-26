package vn.holotruyentranh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import vn.holotruyentranh.beans.TransTeam;

public class TransTeamDao {
	private JdbcTemplate jdbcTemplate;

	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public void save(TransTeam transTeam) {
		String sql = "INSERT INTO transteam (IDteam, team, created) VALUES (NULL, '"
				+ transTeam.getTeam() + "', '"		
				+ transTeam.getCreated() + "')";
		jdbcTemplate.update(sql);
	}

	public void delete(int id) {
		String sql = "DELETE FROM transteam WHERE IDteam = " + id + "";
		jdbcTemplate.update(sql);
	}

	public void update(TransTeam transTeam) {
		String sql = "UPDATE transteam SET team = '" + transTeam.getTeam()+ 
				"', created = '" + transTeam.getCreated() +
				"' WHERE IDteam = " + transTeam.getIDteam() + "";
		jdbcTemplate.update(sql);
	}
	
	public TransTeam findOne(int id) {
	    String sql = "SELECT * FROM transteam WHERE IDteam =" + id;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<TransTeam>() {
	 
	        @Override
	        public TransTeam extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	TransTeam transTeam = new TransTeam();
					transTeam.setIDteam(rs.getInt(1));
					transTeam.setTeam(rs.getString(2));
					transTeam.setCreated(rs.getString(3));
					return transTeam;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	public List<TransTeam> findAll() {
		return jdbcTemplate.query("SELECT * FROM transteam", new RowMapper<TransTeam>() {
			public TransTeam mapRow(ResultSet rs, int row) throws SQLException {
				TransTeam transTeam = new TransTeam();
				transTeam.setIDteam(rs.getInt(1));
				transTeam.setTeam(rs.getString(2));
				transTeam.setCreated(rs.getString(3));
				return transTeam;
			}
		});
	}
}
