package com.sb.socialmedia.repository;

import com.sb.socialmedia.models.SocialGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<SocialGroup,Long>  {

}
