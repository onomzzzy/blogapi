package org.blog.api.repositories;
import java.util.List;

import org.blog.api.model.View;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewRepository extends MongoRepository<View,String>{
	@Query("{blogId:?0}")
	 List<View> findByBlogId(String blogId);
}
