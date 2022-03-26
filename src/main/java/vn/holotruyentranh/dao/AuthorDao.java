package vn.holotruyentranh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import vn.holotruyentranh.beans.Author;

public class AuthorDao {
	private JdbcTemplate jdbcTemplate;

	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public void save(Author author) {
		String sql = "INSERT INTO author(IDauthor, author, created, updated) VALUES (NULL, '"
				+ author.getAuthor() + "', '" + author.getCreated() + "', '" + author.getUpdated() + "')";
		jdbcTemplate.update(sql);
	}

	public void delete(int id) {
		String sql = "DELETE FROM author WHERE IDauthor = " + id + "";
		jdbcTemplate.update(sql);
	}

	public void update(Author author) {
		String sql = "UPDATE author SET author = '" + author.getAuthor() + "', created = '"
				+ author.getCreated() + "', updated = '" + author.getUpdated() + "' WHERE IDauthor = " + author.getIDauthor() + "";
		
		jdbcTemplate.update(sql);
	}
	
	public Author findOne(int id) {
	    String sql = "SELECT * FROM author WHERE IDauthor =" + id;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Author>() {
	 
	        @Override
	        public Author extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	Author author = new Author();
					author.setIDauthor(rs.getInt(1));
					author.setAuthor(rs.getString(2));
					author.setCreated(rs.getString(3));
					author.setUpdated(rs.getString(4));
					return author;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	public List<Author> findAll() {
		return jdbcTemplate.query("SELECT * FROM author", new RowMapper<Author>() {
			public Author mapRow(ResultSet rs, int row) throws SQLException {
				Author author = new Author();
				author.setIDauthor(rs.getInt(1));
				author.setAuthor(rs.getString(2));
				author.setCreated(rs.getString(3));
				author.setUpdated(rs.getString(4));
				return author;
			}
		});
	}
}
