package org.blog.api.repositories;
import java.util.List;

import org.blog.api.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CommentRepository  extends MongoRepository<Comment,String> {
	@Query("{blogId:?0}")
	 List<Comment> findByBlogId(String id);
}
