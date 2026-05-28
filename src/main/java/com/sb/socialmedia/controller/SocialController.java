package com.sb.socialmedia.controller;

import com.sb.socialmedia.models.SocialUser;
import com.sb.socialmedia.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialController {
  @Autowired
  private SocialService socialService;

  @GetMapping("/social/users")
  public ResponseEntity<List<SocialUser>>getusers(){
      return new ResponseEntity<>(socialService.getAllUser(), HttpStatus.OK);
  }

    @PostMapping("/social/users")
    public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser socialUser){
      return new ResponseEntity<>(socialService.saveUser(socialUser),HttpStatus.CREATED);
    }
}
