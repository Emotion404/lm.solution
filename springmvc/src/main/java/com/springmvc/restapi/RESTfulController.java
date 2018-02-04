package com.springmvc.restapi;

import com.springmvc.entity.User;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class RESTfulController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    //-------------------Retrieve All Users--------------------------------------------------------
    @RequestMapping(
            value = "/user",
            method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {

        List<User> users = userService.findAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);

    }

    //-------------------Retrieve Single User--------------------------------------------------------
    @RequestMapping(
            value = "/user/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {

        System.out.println("Fetching User with id " + id);

        User user = userService.findById(id);

        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);

    }

    //-------------------Create a User--------------------------------------------------------
    @RequestMapping(
            value = "/user",
            method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(
            @RequestBody User user,
            UriComponentsBuilder ucBuilder) {

        System.out.println("Creating User " + user.getName());

        if(userService.isUserExist(user)){
            System.out.println("A User with name " + user.getName() + " already exist");
            return  new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        userService.saveUser(user);

        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
        return  new ResponseEntity<Void>(headers,HttpStatus.CREATED);

    }

}
