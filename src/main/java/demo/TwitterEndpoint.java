package demo;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.social.twitter.api.Tweet;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwitterEndpoint {

	@Inject
	private TwitterService twitter;

    @RequestMapping("/twitter")
    public List<Tweet> helloTwitterAll(Model model) {
    	return twitter.homeTimeline();
    }
    
    @RequestMapping("/twitter/{group}")
    public List<Tweet> helloTwitterGroup(Model model, @PathVariable String group) {
        List<Tweet> tweets = twitter.homeTimeline();
		return tweets.parallelStream()
				.filter(t -> t.getFromUser().equals(group))
				.collect(Collectors.toList());
    }

}
