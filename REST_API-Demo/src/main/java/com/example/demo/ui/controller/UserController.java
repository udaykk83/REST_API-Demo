package com.example.demo.ui.controller;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ui.controller.user.mode.request.UserDetailsRequest;
import com.example.demo.ui.controller.user.mode.response.UserRestResponse;


@RestController
@RequestMapping("/users") //http://localhost:8080/users
public class UserController {
	
	/*@GetMapping()
	public String getUser(@RequestParam(value="page",defaultValue = "1") int page,@RequestParam(value="limit",defaultValue = "25") int limit) {
		return "User was called--CREATE "+page +" limit is "+limit;	
	}*/
	//path="/{userId}"
	//@PathVariable String userID)
	@GetMapping
	public UserRestResponse getUser() {
		UserRestResponse userrest=new UserRestResponse();
		userrest.setEmail("uday@gmail");
		userrest.setFirstName("Uday");
		return userrest;
		
	}
	
	@PostMapping(
			consumes= {MediaType.APPLICATION_JSON_VALUE} ,
			produces= {MediaType.APPLICATION_JSON_VALUE}
			)
	public UserDetailsRequest create(@RequestBody UserDetailsRequest userrequest) {
		UserRestResponse userrest=new UserRestResponse();
		userrest.setEmail(userrequest.getEmail());
		userrest.setFirstName(userrequest.getFirstName());
		userrest.setLastNAme(userrequest.getLastNAme());
		return userrequest;
	}
	
	@PutMapping
	public String update() {
		return "User Updated or PUT";
	}
	
	@DeleteMapping
	public String delete() {
		return "user deletede --DELETED";
	}
	
}
