package com.thoaidz.blog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoaidz.blog.security.CustomUserDetails;
import com.thoaidz.blog.service.JwtTokenProvider;
import com.thoaidz.payload.LoginRequest;
import com.thoaidz.payload.LoginResponse;

@RestController
@RequestMapping("/api/")
public class UserController {

	private AuthenticationManager authenticationManager;

	private JwtTokenProvider tokenProvider;

	@Autowired
	public UserController(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider) {
		this.authenticationManager = authenticationManager;
		this.tokenProvider = tokenProvider;
	}

	@PostMapping("auth")
	public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		// Xác thực từ username và password.
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		// Nếu không xảy ra exception tức là thông tin hợp lệ
		// Set thông tin authentication vào Security Context
//		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Trả về jwt cho người dùng.
		String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
		return new LoginResponse(jwt);
	}

}
