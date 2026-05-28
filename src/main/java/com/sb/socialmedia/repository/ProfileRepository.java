package com.sb.socialmedia.repository;

import com.sb.socialmedia.models.SocialProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<SocialProfile,Long> {
}
