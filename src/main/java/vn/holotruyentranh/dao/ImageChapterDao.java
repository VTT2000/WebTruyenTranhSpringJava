package vn.holotruyentranh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import vn.holotruyentranh.beans.ImageChapter;

public class ImageChapterDao {
	private JdbcTemplate jdbcTemplate;

	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public void save(ImageChapter imagechapter) {
		String sql = "INSERT INTO imagechapter (IdImageChapter, IDchapter, ImageLink) VALUES (NULL, '"
				+ imagechapter.getIDchapter() + "', '"			
				+ imagechapter.getImageLink() + "')";
		jdbcTemplate.update(sql);
	}

	public void delete(int id) {
		String sql = "DELETE FROM imagechapter WHERE IdImageChapter = " + id + "";
		jdbcTemplate.update(sql);
	}

	public void update(ImageChapter imagechapter) {
		String sql = "UPDATE imagechapter SET IDchapter = '" + imagechapter.getIDchapter() +
				"', ImageLink = '" + imagechapter.getImageLink() +
				"' WHERE IdImageChapter = " + imagechapter.getIdImageChapter() + "";
		jdbcTemplate.update(sql);
	}
	
	public ImageChapter findOne(int id) {
	    String sql = "SELECT * FROM imagechapter WHERE IdImageChapter =" + id;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<ImageChapter>() {
	        @Override
	        public ImageChapter extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	ImageChapter imagechapter = new ImageChapter();
					imagechapter.setIdImageChapter(rs.getInt(1));
					imagechapter.setIDchapter(rs.getInt(2));
					imagechapter.setImageLink(rs.getString(3));
					return imagechapter;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	public List<ImageChapter> findAll() {
		return jdbcTemplate.query("SELECT * FROM imagechapter", new RowMapper<ImageChapter>() {
			public ImageChapter mapRow(ResultSet rs, int row) throws SQLException {
				ImageChapter imagechapter = new ImageChapter();
				imagechapter.setIdImageChapter(rs.getInt(1));
				imagechapter.setIDchapter(rs.getInt(2));
				imagechapter.setImageLink(rs.getString(3));
				return imagechapter;
			}
		});
	}
}
