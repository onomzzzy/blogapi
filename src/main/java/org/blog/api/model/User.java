package org.blog.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Users")
public class User {
@Id	
private String id;
private String username;

private Log log;

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public Log getLog() {
	return log;
}
public void setLog(Log log) {
	this.log = log;
}


}
