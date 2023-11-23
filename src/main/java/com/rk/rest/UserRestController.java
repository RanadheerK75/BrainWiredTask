package com.rk.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.exception.UserNotFoundException;
import com.rk.model.User;
import com.rk.service.IUserService;

@RestController
@RequestMapping("/rest/api/user")
public class UserRestController {
	@Autowired
	private IUserService service;

	// 1.Save User
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		ResponseEntity<String> res = null;
		try {
			Integer id = service.createUser(user);
			res = new ResponseEntity<String>("User " + id + " Created", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			res = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
	}

	// 2.Fetch All User
	@GetMapping("/all")
	public ResponseEntity<?> getAllUser() {
		ResponseEntity<?> res = null;
		try {
			List<User> users = service.getAllUser();
			res = new ResponseEntity<List<User>>(users, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			res = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
	}

	// 3.Fetch One User
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getOneUser(@PathVariable Integer id) {
		ResponseEntity<?> res = null;
		try {
			User user = service.getOneUser(id);
			res = new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (UserNotFoundException unfe) {
			unfe.printStackTrace();
			res = new ResponseEntity<String>(unfe.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			res = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
	}

	// 4.Update One User
	@PutMapping("/modify")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		ResponseEntity<String> res = null;
		try {
			service.updateUser(user);
			String message = "User " + user.getId() + " Updated";
			res = new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (UserNotFoundException unfe) {
			unfe.printStackTrace();
			res = new ResponseEntity<String>(unfe.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			res = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
	}

	// 5.Delete One User
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		ResponseEntity<String> res = null;
		try {
			service.deleteUser(id);
			String message = "User " + id + " Deleted";
			res = new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (UserNotFoundException unfe) {
			unfe.printStackTrace();
			res = new ResponseEntity<String>(unfe.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			res = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
	}

}
