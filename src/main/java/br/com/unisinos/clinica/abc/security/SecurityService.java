package br.com.unisinos.clinica.abc.security;

import org.springframework.stereotype.Service;

@Service
public class SecurityService {
	public boolean isAuthenticated() {
		return false;
	}
}
