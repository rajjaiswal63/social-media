package com.sb.socialmedia;


import com.sb.socialmedia.models.Post;
import com.sb.socialmedia.models.SocialGroup;
import com.sb.socialmedia.models.SocialProfile;
import com.sb.socialmedia.models.SocialUser;
import com.sb.socialmedia.repository.GroupRepository;
import com.sb.socialmedia.repository.PostRepository;
import com.sb.socialmedia.repository.ProfileRepository;
import com.sb.socialmedia.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    private final GroupRepository groupRepository;
    private final PostRepository postRepository;
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public DataInitializer(GroupRepository groupRepository, PostRepository postRepository, ProfileRepository profileRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.postRepository = postRepository;
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    @Bean
    public CommandLineRunner initializeData() {
        return arg -> {
            // Create some users
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            // Save users to the database
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

            // Create some groups
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            // Add users to groups
            group1.getSocialUsers().add(user1);
            group1.getSocialUsers().add(user2);

            group2.getSocialUsers().add(user2);
            group2.getSocialUsers().add(user3);

            // Save groups to the database
            groupRepository.save(group1);
            groupRepository.save(group2);

            // Associate users with groups
            user1.getGroups().add(group1);
            user2.getGroups().add(group1);
            user2.getGroups().add(group2);
            user3.getGroups().add(group2);

            // Save users back to database to update associations
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

            // Create some posts
            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();

            // Associate posts with users
            post1.setUser(user1);
            post2.setUser(user2);
            post3.setUser(user3);

            // Save posts to the database (assuming you have a PostRepository)
            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);

            // Create some social profiles
            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();

            // Associate profiles with users
            profile1.setUser(user1);
            profile2.setUser(user2);
            profile3.setUser(user3);

            // Save profiles to the database
            profileRepository.save(profile1);
            profileRepository.save(profile2);
            profileRepository.save(profile3);


            // FETCH TYPES
            System.out.println("FETCHING SOCIAL USER");
            userRepository.findById(1L);
        };
    }
}
