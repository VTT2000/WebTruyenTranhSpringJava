package vn.holotruyentranh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import vn.holotruyentranh.beans.ComicCatergory;

public class ComicCatergoryDao {
	private JdbcTemplate jdbcTemplate;

	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public void save(ComicCatergory newComiccatergory) {
		String sql = "INSERT INTO comiccatergory (IDcatergory ,IDcomic) VALUES ('"
				+ newComiccatergory.getIDcatergory() + "', '" 				
				+ newComiccatergory.getIDcomic() + "')";
		jdbcTemplate.update(sql);
	}

	public void delete(ComicCatergory oldComiccatergory) {
		String sql = "DELETE FROM comiccatergory WHERE IDcatergory = " + oldComiccatergory.getIDcatergory() + " AND IDcomic = " + oldComiccatergory.getIDcomic();
		jdbcTemplate.update(sql);
	}

	public List<ComicCatergory> find(int IDcatergory, int IDcomic) {
		if(IDcatergory == 0 && IDcomic == 0) {
			return jdbcTemplate.query("SELECT * FROM comiccatergory", new RowMapper< ComicCatergory>() {
				public ComicCatergory mapRow(ResultSet rs, int row) throws SQLException {
					 ComicCatergory comiccatergory = new ComicCatergory();
					 comiccatergory.setIDcatergory(rs.getInt(1));
					 comiccatergory.setIDcomic(rs.getInt(2));
					 return comiccatergory;
				}
			});	
		}
		else {
			if(IDcatergory != 0 && IDcomic != 0) {
				return jdbcTemplate.query("SELECT * FROM comiccatergory WHERE IDcatergory = " + IDcatergory + " AND IDcomic = " + IDcomic, new RowMapper< ComicCatergory>() {
					public ComicCatergory mapRow(ResultSet rs, int row) throws SQLException {
						 ComicCatergory comiccatergory = new ComicCatergory();
						 comiccatergory.setIDcatergory(rs.getInt(1));
						 comiccatergory.setIDcomic(rs.getInt(2));
						 return comiccatergory;
					}
				});
			}
			else {
				if(IDcatergory != 0) {
					return jdbcTemplate.query("SELECT * FROM comiccatergory WHERE IDcatergory = " + IDcatergory, new RowMapper< ComicCatergory>() {
						public ComicCatergory mapRow(ResultSet rs, int row) throws SQLException {
							 ComicCatergory comiccatergory = new ComicCatergory();
							 comiccatergory.setIDcatergory(rs.getInt(1));
							 comiccatergory.setIDcomic(rs.getInt(2));
							 return comiccatergory;
						}
					});
				}
				else {
					return jdbcTemplate.query("SELECT * FROM comiccatergory WHERE IDcomic = " + IDcomic, new RowMapper< ComicCatergory>() {
						public ComicCatergory mapRow(ResultSet rs, int row) throws SQLException {
							 ComicCatergory comiccatergory = new ComicCatergory();
							 comiccatergory.setIDcatergory(rs.getInt(1));
							 comiccatergory.setIDcomic(rs.getInt(2));
							 return comiccatergory;
						}
					});
				}
			}
		}
	}
}
