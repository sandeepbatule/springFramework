package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.model.Student;

public class StudentDAO {

	private JdbcTemplate jdbcTemplete;

	public void setJdbcTemplete(JdbcTemplate jdbcTemplete) {
		this.jdbcTemplete = jdbcTemplete;
	}

	public int save(Student student) {
		// TODO Auto-generated method stub
		String query="insert into student1(name,salary,designation) values('"+student.getName()+"','"+student.getSalary()+"','"+student.getDesignation()+"')";
		return jdbcTemplete.update(query);
	}

	public List<Student> fetchList() {
		// TODO Auto-generated method stub
		return jdbcTemplete.query("select * from student1",new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Student student=new Student();
				
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setSalary(rs.getFloat("salary"));
				student.setDesignation(rs.getString("designation"));
				
				return student;
			}
			
		});
	}

	public Student  editForm(int id) {
		Student student=new Student();
		String sql="select * from student1 where id=?";
		return jdbcTemplete.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));  
		// TODO Auto-generated method stub
		
	}

	public int update(Student student) {
		// TODO Auto-generated method stub
		String query="update student1 set name='"+student.getName()+"',salary='"+student.getSalary()+"',designation='"+student.getDesignation()+"' where id="+student.getId()+"";
		return jdbcTemplete.update(query);
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		String query=" delete from student1 where id="+id+"";
		return jdbcTemplete.update(query);
	}
	
}
