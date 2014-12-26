package demo;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwitterEndpoint {

	@Inject
	private Twitter twitter;

    @Inject
    private ConnectionRepository connectionRepository;

    @RequestMapping("/twitter")
    public List<Tweet> helloTwitterAll(Model model) {
    	return twitter.timelineOperations().getHomeTimeline();
    }
    
    @RequestMapping("/twitter/{group}")
    public List<Tweet> helloTwitterGroup(Model model, @PathVariable String group) {
//        if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
//            return "redirect:/connect/twitter";
//        }


        List<Tweet> tweets = twitter.timelineOperations().getHomeTimeline();
		return tweets.parallelStream()
				.filter(t -> t.getFromUser().equals(group))
				.collect(Collectors.toList());
    }
}
