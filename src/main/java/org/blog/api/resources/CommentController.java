package org.blog.api.resources;

import java.util.List;

import org.blog.api.model.Comment;
import org.blog.api.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/blog/comments")
public class CommentController {

	@Autowired
	private CommentService cService;
	
	@GetMapping
	public List<Comment> getComments() {
		return cService.getComments();
	}
	
	@GetMapping("{id}")
	public Comment getComment(@PathVariable("id") String id) {
		return cService.getComment(id);
	}
	
	@GetMapping("/articles/{id}")
	public List<Comment> getBlogComments(@PathVariable("id") String id) {
		return cService.getBlogComments(id);
	}
	
	@PutMapping
	public boolean createComment(@RequestBody Comment comment) {
		if (comment == null) {
			return false;
		} else {
			return this.cService.createComment(comment);
		}
	}
	
	@PostMapping
	public boolean replyComment(@RequestBody Comment comment) {
		if (comment == null) {
			return false;
		} else {
			return this.cService.replyComment(comment);
		}
	}

}
