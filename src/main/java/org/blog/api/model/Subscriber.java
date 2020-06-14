package org.blog.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="Subscribers")
public class Subscriber {
@Id		
private String id;
private String blogName;
private String fullName;
private String email;

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getBlogName() {
	return blogName;
}
public void setBlogName(String blogName) {
	this.blogName = blogName;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


}
