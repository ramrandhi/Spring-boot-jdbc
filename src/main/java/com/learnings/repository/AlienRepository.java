package com.learnings.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.learnings.entity.Alien;
@org.springframework.stereotype.Repository
public class AlienRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	String sql = "insert into alien (id, name, tech) values (?,?,?)";

	public void save(Alien alien) {
		int rows = jdbcTemplate.update(sql, alien.getId(), alien.getName(), alien.getTech());
		System.out.println("row/s effected : " + rows);
		
	}
	
	public List<Alien> getAllAliens(){
		String sql = "select * from alien";
		RowMapper<Alien> mapper = new RowMapper<Alien>() {
			public Alien mapRow(ResultSet re, int rowNum) throws SQLException {
				Alien a = new Alien();
				a.setId(re.getInt(1));
				a.setName(re.getString(2));
				a.setTech(re.getString(3));
				return a;
			}
		};
		return (List<Alien>)jdbcTemplate.query(sql, mapper);
	}

}
