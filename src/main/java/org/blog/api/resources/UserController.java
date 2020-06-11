package org.blog.api.resources;
import org.blog.api.model.User;
import org.blog.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog/users")
public class UserController {

	@Autowired
	private UserService uService;
	
	@CrossOrigin(maxAge = 3600)
	@GetMapping("{username}")
	public User getPost(@PathVariable("username") String username) {
		return uService.getUser(username);
	}
}
