package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.dao.ToDoListDao;
import com.todo.model.ToDoList;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class ToDoListController {

	@Autowired
	private ToDoListDao todoDao;
	
	//list all courses
	@RequestMapping(value="/lists", method=RequestMethod.GET)
	public List toDoLists(){
		
		List doList = todoDao.listAll();
		return doList;
		
	}
	
	//insert task details into list
	@RequestMapping(value="/insertlist", method=RequestMethod.POST)
	public void insertTask(@RequestBody ToDoList todoList){
		
		todoDao.insert(todoList);
	}
	
	//delete task from list
	@RequestMapping(value="/deletelist/{id}", method=RequestMethod.DELETE)
	public void deleteTask(@PathVariable("id")int id){
		
		todoDao.deleteList(id);
		
	}
	
	//update task list
	@RequestMapping(value="/updatelist", method=RequestMethod.PUT)
	public void updateTask(@RequestBody ToDoList todoList){
		todoDao.updateList(todoList);
	}
	
	//search a task by id
	@RequestMapping(value="/listsbyid/{id}", method=RequestMethod.GET)
	public ToDoList searchTasks(@PathVariable("id")int id){
		
		ToDoList todoList = todoDao.searchTask(id);
		
		return todoList;
	}
	
	
	
}
