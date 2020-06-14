package org.blog.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Views")
public class View {
@Id		
private String id;
private String blogId;

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getBlogId() {
	return blogId;
}
public void setBlogId(String blogId) {
	this.blogId = blogId;
}


}
