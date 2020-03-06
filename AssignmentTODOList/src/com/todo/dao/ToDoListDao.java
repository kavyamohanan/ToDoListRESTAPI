package com.todo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.todo.model.ToDoList;

public class ToDoListDao {
	
	//spring framework jdbc template
	private JdbcTemplate template;
	//setter for jdbc template
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	//query for crud operations
	private static String DISPLAY_LIST = "SELECT * FROM todolist";
	private static String INSERT_LIST="INSERT INTO todolist(task,dueDate,startTime,endTime,personId,status) values(?,?,?,?,?,0)";
	private static String DELETE_LIST = "DELETE FROM todolist WHERE id=?";
	private static String UPDATE_LIST = "UPDATE todolist SET task=?,dueDate=?,startTime=?,endTime=?,personId=?,status=? WHERE id=?";
	private static String SEARCH_TASK = "SELECT * FROM todolist WHERE id=?";
	
	
	//to list all
	public List<ToDoList> listAll(){
		
		//returning list
		return template.query(DISPLAY_LIST, new RowMapper<ToDoList>(){

			@Override
			public ToDoList mapRow(ResultSet rs, int row)
					throws SQLException {
				
				//instance for bean ToDoList
				ToDoList toDoList = new ToDoList();
				//getting data from result set
				toDoList.setId(rs.getInt("id"));
				toDoList.setTask(rs.getString("task"));
				toDoList.setDueDate(rs.getDate("dueDate"));
				toDoList.setStartTime(rs.getTime("startTime"));
				toDoList.setEndTime(rs.getTime("endTime"));
				toDoList.setPersonId(rs.getInt("personId"));
				toDoList.setStatus(rs.getInt("status"));
				
				//return a row
				return toDoList;
			}
			
		});
	}
	
	//insert into to do list
	public void insert(final ToDoList todoList){
		
		template.update(INSERT_LIST,todoList.getTask(),todoList.getDueDate(),todoList.getStartTime(),todoList.getEndTime(),todoList.getPersonId());
	}
	
	//delete todo list
	public void deleteList(final int id){
		
		template.execute(DELETE_LIST,new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement statement)
					throws SQLException, DataAccessException {

				statement.setInt(1,id);
				
				return statement.execute();
			}
		});
	}
	
	//update to do list
	public void updateList(final ToDoList todoList){
		
		template.update(UPDATE_LIST,todoList.getTask(),todoList.getDueDate(),todoList.getStartTime(),todoList.getEndTime(),todoList.getPersonId(),todoList.getStatus(),todoList.getId());
				
	}
	
	//search a task
	public ToDoList searchTask(int id){
		
		return template.queryForObject(SEARCH_TASK, new Object[] { id },
				new BeanPropertyRowMapper<ToDoList>(ToDoList.class));
		
	}
	
	
}
