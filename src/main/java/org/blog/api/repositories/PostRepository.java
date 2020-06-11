package org.blog.api.repositories;

import java.util.List;

//import java.util.List;

import org.blog.api.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository  extends MongoRepository<Post,String> {

	@Query("{category:?0}")
	 List<Post> findByCategory(String category);
	
	@Query("{ 'des' : { $regex: ?0 } }")
	 List<Post> findByRegex(String regexp);
	
	@Query("{ 'article' : { $regex: ?0 } }")
	 List<Post> findByRegexPost(String regexp);
	
}