package org.blog.api.resources;

import java.util.List;
import org.blog.api.model.View;
import org.blog.api.services.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/blog/views")
public class ViewController {
	
@Autowired
private ViewService vService;


@GetMapping
public List<View> getViews() {
	return this.vService.getViews();
}

@GetMapping("{blogId}")
public List<View> getView(@PathVariable("blogId") String blogId) {
	return this.vService.getView(blogId);
}

@PutMapping
public boolean createView(@RequestBody View view) {
	if (view == null) {
		return false;
	} else {
		return this.vService.addViewCount(view);
	}
}
}
