package vn.holotruyentranh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import vn.holotruyentranh.beans.Chapter;

public class ChapterDao {
	private JdbcTemplate jdbcTemplate;

	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public void save(Chapter chapter) {
		String sql = "INSERT INTO chapter(IDchapter, chapter, IDcomic, created, updated) VALUES (NULL, '"
				+ chapter.getChapter() + "', '" + chapter.getIDcomic() + "', '" + chapter.getCreated()
				+ "', '" + chapter.getUpdated() + "')";
		jdbcTemplate.update(sql);
	}

	public void delete(int id) {
		String sql = "DELETE FROM chapter WHERE IDchapter = " + id + "";
		jdbcTemplate.update(sql);
	}

	public void update(Chapter chapter) {
		String sql = "UPDATE chapter SET chapter = '" + chapter.getChapter() + "', IDcomic = '"
				+ chapter.getIDcomic() + "', created = '" + chapter.getCreated() + "', updated = '"
				+ chapter.getUpdated() + "' WHERE IDchapter = " + chapter.getIDchapter() + "";
		
		jdbcTemplate.update(sql);
	}
	
	public Chapter findOne(int id) {
	    String sql = "SELECT * FROM chapter WHERE IDchapter =" + id;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Chapter>() {
	 
	        @Override
	        public Chapter extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	Chapter chapter = new Chapter();
					chapter.setIDchapter(rs.getInt(1));
					chapter.setChapter(rs.getString(2));
					chapter.setIDcomic(rs.getInt(3));
					chapter.setCreated(rs.getString(4));
					chapter.setUpdated(rs.getString(5));
					return chapter;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	public List<Chapter> findAll() {
		return jdbcTemplate.query("SELECT * FROM chapter", new RowMapper<Chapter>() {
			public Chapter mapRow(ResultSet rs, int row) throws SQLException {
				Chapter chapter = new Chapter();
				chapter.setIDchapter(rs.getInt(1));
				chapter.setChapter(rs.getString(2));
				chapter.setIDcomic(rs.getInt(3));
				chapter.setCreated(rs.getString(4));
				chapter.setUpdated(rs.getString(5));
				return chapter;
			}
		});
	}
}
