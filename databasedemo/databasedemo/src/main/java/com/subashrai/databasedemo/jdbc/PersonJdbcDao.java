package com.subashrai.databasedemo.jdbc;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.subashrai.databasedemo.entity.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	static class PersonRowMapper implements RowMapper<Person>{
		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			return person;
		}
		
	}
	
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", new PersonRowMapper());
	}

	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?", id);
	}

	public int insert(Person person) {
        Object[] args = {person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime())};

        return jdbcTemplate.update("insert into person (id, name, location, birth_date) " + "values(?,  ?, ?, ?)", args);
	}

	public int update(Person person) {
        Object[] args = { person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId() };

        return jdbcTemplate.update("update person " + " set name = ?, location = ?, birth_date = ? " + " where id = ?", args);
	}

}

/*
 * JdbcTemplate is a key component in Spring's JDBC module that simplifies the
 * use of JDBC (Java Database Connectivity) by handling the tedious and
 * repetitive tasks of working with raw SQL, managing connections, executing
 * queries, and mapping results.
 */
/*
 * The @Repository annotation in Spring is a specialization of the @Component
 * annotation, which is used to indicate that a particular class is a Data
 * Access Object (DAO) that will interact with the database.
 */


/*
 * The BeanPropertyRowMapper in Spring is a useful utility class that allows you
 * to map rows of a ResultSet to a specific Java bean. This is particularly
 * handy when you want to map rows from a relational database directly into
 * objects without manually setting each field.
 */




