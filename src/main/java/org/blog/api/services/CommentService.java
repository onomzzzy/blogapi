package org.blog.api.services;
import java.util.List;
import java.util.NoSuchElementException;

import org.blog.api.model.Comment;
import org.blog.api.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

	@Autowired
	CommentRepository cRepo;
	
	public List<Comment> getComments(){
		return this.cRepo.findAll();
	}
	
	public Comment getComment(String id){
		try {
			Comment comment = this.cRepo.findAll().stream().filter(t -> t.getId().equals(id)).findFirst()
					.get();
			return comment;
		} catch (NoSuchElementException ex) {
			return null;
		}
	}
	
	public List<Comment> getBlogComments(String blogId){
		return cRepo.findByBlogId(blogId);
	}
	
	public boolean createComment(Comment comment) {
		try {
		 	this.cRepo.insert(comment);
		 	return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
	
	public boolean replyComment(Comment comment) {
		try {
		 	this.cRepo.save(comment);
		 	return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
}
