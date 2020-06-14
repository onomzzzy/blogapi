package org.blog.api.resources;
import java.util.List;
import org.blog.api.model.Subscriber;
import org.blog.api.services.SubscriberService;
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
@RequestMapping("/blog/subscribers")
public class SubscriberController {
	
	@Autowired
	private SubscriberService ssService;

	@GetMapping
	public List<Subscriber> getSubscribers() {
		return ssService.getSubscribers();
	}
	
	@GetMapping("{email}")
	public Subscriber getSubscriber(@PathVariable("email") String email) {
		return ssService.getSubscriber(email);
	}
	
	@PutMapping
	public boolean addNewSubscriber(@RequestBody Subscriber subscriber) {
		if (subscriber == null) {
			return false;
		} else {
			return this.ssService.addNewSubscriber(subscriber);
		}
	}
	
}
