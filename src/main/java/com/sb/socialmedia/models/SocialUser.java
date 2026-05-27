package com.sb.socialmedia.models;

import jakarta.persistence.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "user")
//    @JoinColumn(name = "social_profile")
    private SocialProfile profile;

    @OneToMany(mappedBy = "user")
    private List<Post> posts=new ArrayList<>();

    @ManyToMany(mappedBy = "")
    private Set<Group> group = new HashSet<>();

}
