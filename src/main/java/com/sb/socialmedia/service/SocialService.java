package com.sb.socialmedia.service;

import com.sb.socialmedia.models.SocialUser;
import com.sb.socialmedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {
    @Autowired
    private UserRepository userRepository;

    public List<SocialUser> getAllUser() {
        return userRepository.findAll();
    }

    public SocialUser saveUser(SocialUser socialUser) {
        return userRepository.save(socialUser);
    }
}
