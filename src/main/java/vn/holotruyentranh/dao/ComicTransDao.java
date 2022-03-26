package vn.holotruyentranh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import vn.holotruyentranh.beans.ComicTrans;

public class ComicTransDao {
	private JdbcTemplate jdbcTemplate;

	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public void save(ComicTrans newComictrans) {
		String sql = "INSERT INTO comictrans (IDcomic, IDteam) VALUES ('"
				+   newComictrans.getIDcomic() + "', '" 				
				+   newComictrans.getIDteam() + "')";
		jdbcTemplate.update(sql);
	}

	public void delete(ComicTrans oldComictrans) {
		String sql = "DELETE FROM comictrans WHERE IDcomic = " + oldComictrans.getIDcomic() + " AND IDteam = " + oldComictrans.getIDteam();
		jdbcTemplate.update(sql);
	}

	public List<ComicTrans> find(int IDcomic, int IDteam) {
		if(IDcomic == 0 && IDteam == 0) {
			return jdbcTemplate.query("SELECT * FROM comictrans", new RowMapper<ComicTrans>() {
				public ComicTrans mapRow(ResultSet rs, int row) throws SQLException {
					 ComicTrans comicTrans = new ComicTrans();
					 comicTrans.setIDcomic(rs.getInt(1));
					 comicTrans.setIDteam(rs.getInt(2));
					 return comicTrans;
				}
			});	
		}
		else {
			if(IDcomic != 0 && IDteam != 0) {
				return jdbcTemplate.query("SELECT * FROM comictrans WHERE IDcomic = " + IDcomic + " AND IDteam = " + IDteam, new RowMapper<ComicTrans>() {
					public ComicTrans mapRow(ResultSet rs, int row) throws SQLException {
						 ComicTrans comicTrans = new ComicTrans();
						 comicTrans.setIDcomic(rs.getInt(1));
						 comicTrans.setIDteam(rs.getInt(2));
						 return comicTrans;
					}
				});
			}
			else {
				if(IDcomic != 0) {
					return jdbcTemplate.query("SELECT * FROM comictrans WHERE IDcomic = " + IDcomic, new RowMapper< ComicTrans>() {
						public ComicTrans mapRow(ResultSet rs, int row) throws SQLException {
							 ComicTrans comicTrans = new ComicTrans();
							 comicTrans.setIDcomic(rs.getInt(1));
							 comicTrans.setIDteam(rs.getInt(2));
							 return comicTrans;
						}
					});
				}
				else {
					return jdbcTemplate.query("SELECT * FROM comictrans WHERE IDteam = " + IDteam, new RowMapper< ComicTrans>() {
						public ComicTrans mapRow(ResultSet rs, int row) throws SQLException {
							 ComicTrans comicTrans = new ComicTrans();
							 comicTrans.setIDcomic(rs.getInt(1));
							 comicTrans.setIDteam(rs.getInt(2));
							 return comicTrans;
						}
					});
				}
			}
		}
	}
}
