package org.blog.api.services;

import java.util.List;

import org.blog.api.model.Subscriber;
import org.blog.api.repositories.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriberService {
	@Autowired
	SubscriberRepository ssRepo;
	
	public Subscriber getSubscriber(String email) {
		return ssRepo.findByEmail(email);
		}
		
		public boolean addNewSubscriber(Subscriber subscriber) {
			Subscriber user = null;
			try {
		    boolean result = false;		
			user = this.getSubscriber(subscriber.getEmail());
			if(user == null) {
			ssRepo.insert(subscriber);
			result = true;
			}
			return result;
			}
			catch(Exception ex) {
				return false;
			}
			
		}

		public List<Subscriber> getSubscribers() {
			return ssRepo.findAll();
		}
}
