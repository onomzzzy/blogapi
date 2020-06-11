package org.blog.api.resources;

import java.util.ArrayList;
import java.util.List;

import org.blog.api.model.Post;
import org.blog.api.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/blog/posts")
public class PostController {

	@Autowired
	private PostService pService;
	
	@GetMapping
	public List<Post> getPosts() {
		return pService.getPosts();
	}
	
	@GetMapping("{id}")
	public Post getPost(@PathVariable("id") String id) {
		return pService.getPost(id);
	}
	
	@GetMapping("/categories/{category}")
	public List<Post> getPostsByCategory(@PathVariable("category") String category) {
		return pService.getPostByCategory(category);
	}
	
	
	@GetMapping("/search/{searchWord}")
	public List<Post> getPostsBySearch(@PathVariable("searchWord") String searchWord) {
		if(searchWord.length() > 1) {
			return pService.getPostBySeach(searchWord);	
		}
		else {
			List<Post> posts = new ArrayList<>();
			return posts;
		}
		
	}
	
	@PutMapping
	public boolean createPost(@RequestBody Post post) {
		if (post == null) {
			return false;
		} else {
			return this.pService.createPost(post);
		}
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteUser(@PathVariable("id") String id) {
		return this.pService.deletePost(id);
	}
	
	
	
}
