package vn.holotruyentranh.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;    

import vn.holotruyentranh.beans.Catergory;

public class CatergoryDao {
	private JdbcTemplate jdbcTemplate;

	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public void save(Catergory catergory) {
		String sql = "INSERT INTO catergory (IDcatergory, catergory, decriptions, created_at, update_at) VALUES (NULL, '"
				+ catergory.getCatergory() + "', '" + catergory.getDescription() + "', '" + catergory.getCreated_at()
				+ "', '" + catergory.getUpdate_at() + "')";
		jdbcTemplate.update(sql);
	}

	public void delete(int id) {
		String sql = "DELETE FROM catergory WHERE IDcatergory = " + id + "";
		jdbcTemplate.update(sql);
	}

	public void update(Catergory catergory) {
		String sql = "UPDATE catergory SET catergory = '" + catergory.getCatergory() + "', decriptions = '"
				+ catergory.getDescription() + "', created_at = '" + catergory.getCreated_at() + "', update_at = '"
				+ catergory.getUpdate_at() + "' WHERE IDcatergory = " + catergory.getIDcatergory() + "";
		
		jdbcTemplate.update(sql);
	}
	
	public Catergory findOne(int id) {
	    String sql = "SELECT * FROM catergory WHERE IDcatergory =" + id;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Catergory>() {
	 
	        @Override
	        public Catergory extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	Catergory catergory = new Catergory();
					catergory.setIDcatergory(rs.getInt(1));
					catergory.setCatergory(rs.getString(2));
					catergory.setDescription(rs.getString(3));
					catergory.setCreated_at(rs.getString(4));
					catergory.setUpdate_at(rs.getString(5));
					return catergory;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	public List<Catergory> findAll() {
		return jdbcTemplate.query("SELECT * FROM catergory", new RowMapper<Catergory>() {
			public Catergory mapRow(ResultSet rs, int row) throws SQLException {
				Catergory catergory = new Catergory();
				catergory.setIDcatergory(rs.getInt(1));
				catergory.setCatergory(rs.getString(2));
				catergory.setDescription(rs.getString(3));
				catergory.setCreated_at(rs.getString(4));
				catergory.setUpdate_at(rs.getString(5));
				return catergory;
			}
		});
	}
}

