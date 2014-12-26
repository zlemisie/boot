package demo;

import javax.inject.Inject;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
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
    public CursoredList<TwitterProfile> helloTwitter(Model model) {
//        if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
//            return "redirect:/connect/twitter";
//        }

        model.addAttribute(twitter.userOperations().getUserProfile());
        CursoredList<TwitterProfile> friends = twitter.friendOperations().getFriends();
        model.addAttribute("friends", friends);
        return friends;
    }
}
