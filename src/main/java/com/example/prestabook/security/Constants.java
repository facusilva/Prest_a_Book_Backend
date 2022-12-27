package com.example.prestabook.security;

public class Constants {

	// Spring Security

	public static final String LOGIN_URL = "/login";
	public static final String REGISTER_URL = "/api/users";
	public static final String ROLES_URL = "/api/roles";
	public static final String BOOKS_URL = "/api/books";
	public static final String AUTHORS_URL = "/api/authors";
	public static final String WROTE_URL = "/api/wrote";
	public static final String USERNAME_URL = "/api/users/username/{username}";
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";

	// JWT

	public static final String ISSUER_INFO = "Team5";
	public static final String SUPER_SECRET_KEY = "8888PassSecreta@";
	public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day

}
