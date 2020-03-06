package com.todo.model;

import java.sql.Time;
import java.sql.Date;


public class ToDoList {
	
	//instance variables
	private Integer id;
	private String task;
	private Date dueDate;
	private Time startTime;
	private Time endTime;
	private Integer personId;
	private Integer status;
	
	//default constructor
	public ToDoList() {
		// TODO Auto-generated constructor stub
	}

	//parameterized constructor
	public ToDoList(Integer id, String task, Date dueDate, Time startTime,
			Time endTime, Integer personId, Integer status) {
		super();
		this.id = id;
		this.task = task;
		this.dueDate = dueDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.personId = personId;
		this.status = status;
	}

	public ToDoList(String task, Date dueDate, Time startTime, Time endTime,
			Integer personId, Integer status) {
		super();
		this.task = task;
		this.dueDate = dueDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.personId = personId;
		this.status = status;
	}

	//getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
}
