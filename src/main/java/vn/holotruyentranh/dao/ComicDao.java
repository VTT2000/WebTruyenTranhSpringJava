package vn.holotruyentranh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import vn.holotruyentranh.beans.Comic;

public class ComicDao {
	private JdbcTemplate jdbcTemplate;

	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public void save(Comic comic) {
		String sql = "INSERT INTO comic (IDcomic, comic, created, updated, ratting, views, share, IDauthor, status, description, ImageLink) VALUES (NULL, '"
				+ comic.getComic() + "', '" 
				+ comic.getCreated() + "', '" 
				+ comic.getUpdated() + "', '"
				+ comic.getRatting() + "', '"
				+ comic.getViews() + "', '"
				+ comic.getShare() + "', '"
				+ comic.getIDauthor() + "', '"
				+ comic.getStatus() + "', '"
				+ comic.getDescription() + "', '"				
				+ comic.getImageLink() + "')";
		jdbcTemplate.update(sql);
	}

	public void delete(int id) {
		String sql = "DELETE FROM comic WHERE IDcomic = " + id + "";
		jdbcTemplate.update(sql);
	}

	public void update(Comic comic) {
		String sql = "UPDATE comic SET comic = '" + comic.getComic() + 
				"', created = '" + comic.getCreated() + 
				"', updated = '" + comic.getUpdated() + 
				"', ratting = '" + comic.getRatting() + 
				"', views = '" + comic.getViews() +
				"', share = '" + comic.getShare() +
				"', IDauthor = '" + comic.getIDauthor() +
				"', status = '" + comic.getStatus() +
				"', description = '" + comic.getDescription() +
				"', ImageLink = '" + comic.getImageLink() +
				"' WHERE IDcomic = " + comic.getIDcomic() + "";
		jdbcTemplate.update(sql);
	}
	
	public Comic findOne(int id) {
	    String sql = "SELECT * FROM comic WHERE IDcomic =" + id;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Comic>() {
	 
	        @Override
	        public Comic extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	Comic comic = new Comic();
					comic.setIDcomic(rs.getInt(1));
					comic.setComic(rs.getString(2));
					comic.setCreated(rs.getString(3));
					comic.setUpdated(rs.getString(4));
					comic.setRatting(rs.getInt(5));
					comic.setViews(rs.getInt(6));
					comic.setShare(rs.getInt(7));
					comic.setIDauthor(rs.getInt(8));
					comic.setStatus(rs.getString(9));
					comic.setDescription(rs.getString(10));;
					comic.setImageLink(rs.getString(11));
					return comic;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	public List<Comic> findAll() {
		return jdbcTemplate.query("SELECT * FROM comic", new RowMapper<Comic>() {
			public Comic mapRow(ResultSet rs, int row) throws SQLException {
				Comic comic = new Comic();
				comic.setIDcomic(rs.getInt(1));
				comic.setComic(rs.getString(2));
				comic.setCreated(rs.getString(3));
				comic.setUpdated(rs.getString(4));
				comic.setRatting(rs.getInt(5));
				comic.setViews(rs.getInt(6));
				comic.setShare(rs.getInt(7));
				comic.setIDauthor(rs.getInt(8));
				comic.setStatus(rs.getString(9));
				comic.setDescription(rs.getString(10));;
				comic.setImageLink(rs.getString(11));
				return comic;
			}
		});
	}
}
