package demo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;

public class TwitterService {

	@Inject
	private Twitter twitter;

    @Inject
    private ConnectionRepository connectionRepository;

    @Cacheable
	public List<Tweet> homeTimeline() {
		return twitter.timelineOperations().getHomeTimeline();
	}
    
//  if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
//  return "redirect:/connect/twitter";
//}
    
}
