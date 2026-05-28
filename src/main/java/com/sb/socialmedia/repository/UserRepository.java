package com.sb.socialmedia.repository;

import com.sb.socialmedia.models.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SocialUser,Long> {
}
