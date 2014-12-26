package demo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwitterEndpoint {

	@Inject
	private Twitter twitter;

    @Inject
    private ConnectionRepository connectionRepository;

    @RequestMapping("/twitter")
    public List<Tweet> helloTwitter(Model model) {
//        if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
//            return "redirect:/connect/twitter";
//        }


        return twitter.timelineOperations().getHomeTimeline();
    }
}
