package org.blog.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Posts")
public class Post {
@Id	
private String id;
private String title;
private String date;
private String postCover;
private boolean isVideo;
private String des;
private String category;
private String article;
private String author;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getPostCover() {
	return postCover;
}
public void setPostCover(String postCover) {
	this.postCover = postCover;
}

public String getArticle() {
	return article;
}
public void setArticle(String article) {
	this.article = article;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public boolean isVideo() {
	return isVideo;
}
public void setVideo(boolean isVideo) {
	this.isVideo = isVideo;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getDes() {
	return des;
}
public void setDes(String des) {
	this.des = des;
}


}
