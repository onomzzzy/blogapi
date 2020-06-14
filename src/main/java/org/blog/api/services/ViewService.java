package org.blog.api.services;
import java.util.List;

import org.blog.api.model.View;
import org.blog.api.repositories.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewService {

	@Autowired
	ViewRepository vRepo;
	
	public List<View> getView(String blogId) {
	return vRepo.findByBlogId(blogId);
	}
	
	public boolean addViewCount(View view) {
		vRepo.insert(view);
		return true;
	}

	public List<View> getViews() {
		return vRepo.findAll();
	}
}
