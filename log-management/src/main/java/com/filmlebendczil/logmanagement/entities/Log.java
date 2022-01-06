package com.filmlebendczil.logmanagement.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOG")
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE )
	private Long ID;
	
	@Column(name="origin")
	private String origin;
	
	@Column(name="type")
    private String type;
	
	@Column(name = "stack_trace")
    private String stackTrace;
	
	@Column(name="message")
    private String message;
	
	@Column(name="timestamp")
    private Timestamp timestamp;

	public Log() {
		super();
	}

	public Log(String origin, String type, String stackTrace, String message, Timestamp timestamp) {
		super();
		this.origin = origin;
		this.type = type;
		this.stackTrace = stackTrace;
		this.message = message;
		this.timestamp = timestamp;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
