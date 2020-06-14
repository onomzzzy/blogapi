package org.blog.api.repositories;
import org.blog.api.model.Subscriber;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends MongoRepository<Subscriber,String>{
	@Query("{email:?0}")
	 Subscriber findByEmail(String email);
}
