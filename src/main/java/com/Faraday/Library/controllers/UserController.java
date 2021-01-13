package com.Faraday.Library.controllers;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.Faraday.Library.dto.JwtResponse;
import com.Faraday.Library.dto.StatusMessageDto;
import com.Faraday.Library.repository.UserRepository;
import com.Faraday.Library.security.jwt.JwtUtils;
import com.Faraday.Library.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Faraday.Library.dto.UserDto;
import com.Faraday.Library.entity.UserEntity;
import com.Faraday.Library.services.UserServiceImplement;

import lombok.Data;

@Data
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserServiceImplement service;

	@Autowired
	UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private JwtUtils jwtUtils;

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	@SuppressWarnings("rawtypes")
	private StatusMessageDto result = new StatusMessageDto();
	
	@GetMapping("/user")
	public ResponseEntity<?> getAll(){
		List<UserEntity> userEntities = service.getAll();
		return ResponseEntity.ok(userEntities);
	}
	
	@GetMapping("/user/id/{id}")
	public ResponseEntity<?> getAllUserActiveById(@PathVariable Integer id){
		UserEntity userEntities = service.getAllUserActiveById(id);
		return ResponseEntity.ok(userEntities);
	}
	
	@GetMapping("/user/id-all/{id}")
	public ResponseEntity<?> getAllUserById(@PathVariable Integer id){
		UserEntity userEntities = service.getALlUserById(id);
		return ResponseEntity.ok(userEntities);
	}
	
	@GetMapping("/user/code/{code}")
	public ResponseEntity<?> getAllUserByCode(@PathVariable String code){
		UserEntity userEntities = service.getAllUserActiveByUserCode(code);
		return ResponseEntity.ok(userEntities);
	}

	@GetMapping("/user/username/{userName}")
	public ResponseEntity<?> getAllUserByUserName(@PathVariable String userName){
		UserEntity userEntities = service.getAllUserActiveByUserName(userName);
		return ResponseEntity.ok(userEntities);
	}
	
	@GetMapping("/user/email/{email}")
	public ResponseEntity<?> getAllUserByEmail(@PathVariable String email){
		UserEntity userEntities = service.getAllUserActiveByEmail(email);
		return ResponseEntity.ok(userEntities);
	}
	
	@PostMapping("/users/signup")
	public ResponseEntity<?> insertUser(@RequestBody UserDto dto){
		StatusMessageDto response = new StatusMessageDto();
		if(dto.getFullName().equals("") || dto.getEmail().equals("") || dto.getPassword().equals("")) {
			response.setMessage("Data cannot empty");
			response.setData(null);
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			return ResponseEntity.badRequest().body(response);
		}else {
			UserEntity user = userRepository.findByUserName(dto.getUserName());
			if (user != null) {
				response.setMessage("Username has been used");
				response.setData(null);
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				return ResponseEntity.badRequest().body(response);
			}
			if(dto.getPassword().length() < 8){
				response.setMessage("password at least 8 characters");
				response.setData(null);
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				return ResponseEntity.badRequest().body(response);
			}
			Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(dto.getEmail());
			if(matcher.find()){
				UserEntity cekEmail = userRepository.findByEmail(dto.getEmail());
				if(cekEmail != null) {
					response.setMessage("Email has been used");
					response.setData(null);
					response.setStatus(HttpStatus.BAD_REQUEST.value());
					return ResponseEntity.badRequest().body(response);
				}else {
					UserEntity userEntity = service.insertUser(dto);
					response.setStatus(HttpStatus.OK.value());
					response.setMessage("User created!");
					response.setData(userEntity);
					return ResponseEntity.ok(response);
				}
			}else{
				response.setMessage("Format email failed");
				response.setData(null);
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				return ResponseEntity.badRequest().body(response);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/users/signin")
	public ResponseEntity<?> loginUser(@RequestBody UserEntity user){
		UserEntity cekUsername = service.getAllUserActiveByUserName(user.getUserName());
		StatusMessageDto response = new StatusMessageDto();
		if(cekUsername != null){
				Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
				SecurityContextHolder.getContext().setAuthentication(authentication);
				String jwt = jwtUtils.generateJwtToken(authentication);
				UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
				Set<String> roles = userDetails.getAuthorities().stream().map(role -> role.getAuthority())
						.collect(Collectors.toSet());
				return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUserCode(),userDetails.getUsername(), userDetails.getEmail(), roles));
		}else{
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Username not found");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}
	}
	
	@PostMapping("/users/admin")
	public ResponseEntity<?> insertAdmin(@RequestBody UserDto dto){
		StatusMessageDto response = new StatusMessageDto();
		if(dto.getFullName().equals("") || dto.getEmail().equals("") || dto.getPassword().equals("")) {
			response.setMessage("Data cannot empty");
			response.setData(null);
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			return ResponseEntity.badRequest().body(response);
		}else {
			UserEntity user = userRepository.findByUserName(dto.getUserName());
			if (user != null) {
				response.setMessage("Username has been used");
				response.setData(null);
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				return ResponseEntity.badRequest().body(response);
			}
			if(dto.getPassword().length() < 8){
				response.setMessage("password at least 8 characters");
				response.setData(null);
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				return ResponseEntity.badRequest().body(response);
			}
			Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(dto.getEmail());
			if(matcher.find()){
				UserEntity cekEmail = userRepository.findByEmail(dto.getEmail());
				if(cekEmail != null) {
					response.setMessage("Email has been used");
					response.setData(null);
					response.setStatus(HttpStatus.BAD_REQUEST.value());
					return ResponseEntity.badRequest().body(response);
				}else {
					UserEntity userEntity = service.insertAdmin(dto);
					response.setStatus(HttpStatus.OK.value());
					response.setMessage("User created!");
					response.setData(userEntity);
					return ResponseEntity.ok(response);
				}
			}else{
				response.setMessage("Format email failed");
				response.setData(null);
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				return ResponseEntity.badRequest().body(response);
			}

		}
	}
	
	@PutMapping("/user/profile/{id}")
	public ResponseEntity<?> updateUserProfile(@PathVariable Integer id, @RequestBody UserDto dto){
		if(dto.getPhone().equals("") || dto.getAddress().equals("")) {
			return ResponseEntity.badRequest().body("nama tidak boleh kosong");			
		}else {
			UserEntity userEntity = service.updateUser(id, dto);
			return ResponseEntity.ok(userEntity);
		}
	}
	
	@PutMapping("/user/password/{id}")
	public ResponseEntity<?> updateUserPassword(@PathVariable Integer id, @RequestBody UserDto dto){
		if(dto.getPassword().equals("")) {
			return ResponseEntity.badRequest().body("password tidak boleh kosong");			
		}else {
			UserEntity userEntity = service.updateUserPassword(id, dto);
			return ResponseEntity.ok(userEntity);
		}
	}
	
	@PutMapping("/user/suspendate/{id}")
	public ResponseEntity<?> updateUserSuspend(@PathVariable Integer id, @RequestBody UserDto dto){
		if(dto.getStatus().equals("")) {
			return ResponseEntity.badRequest().body("tanggal tidak boleh kosong");			
		}else {
			UserEntity userEntity = service.updateUserSuspend(id, dto);
			return ResponseEntity.ok(userEntity);
		}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id){
		List<UserEntity> userEntities = service.getAll();
		Integer status = 0;
		for(UserEntity e : userEntities) {
			if(e.getId().equals(id)) {
				UserEntity userEntity = service.deleteUser(id);
				status = HttpStatus.OK.value();
				break;
			}else {
				status = HttpStatus.BAD_REQUEST.value();
			}
		}
		
		if(status == HttpStatus.OK.value()) {
			return ResponseEntity.ok("berhasil terhapus");
		}else {
			return ResponseEntity.badRequest().body("gagal menemukan akun");
		}
	}
	
	@PutMapping("/user/balance/{id}")
	public ResponseEntity<?> updateUserBalance(@PathVariable Integer id, @RequestBody UserDto dto){
		if(dto.getBalance().equals("")) {
			return ResponseEntity.badRequest().body("password tidak boleh kosong");			
		}else {
			UserEntity userEntity = service.updateUserBalance(id, dto);
			return ResponseEntity.ok(userEntity);
		}
	}
	
	
}
