package com.project.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.User;

import com.project.service.BookInfoService;

import org.springframework.security.core.*;


@Service("customUserDetailsService")
@Transactional(readOnly=true)
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private BookInfoService bookInfoService;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		com.project.model.User user= bookInfoService.getUser(username);
		System.out.println(username);
		
		boolean enabled = user.isActive();
		boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        
        List<String> roles = new ArrayList<String>();
        
       roles.add(user.getUserRoles().getRole().getRolename());
		 
		return new User(
				user.getUserName(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
				getAuthorities(roles));
	}

	public Collection<? extends GrantedAuthority> getAuthorities(List<String> role) {
		 List<GrantedAuthority> authList = getGrantedAuthorities(role);
	        return authList;
	}

	public List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
	}

	/*private List<String> getRoles(Integer roleId) {
		
		List<String> roles = new ArrayList<String>();
		
		if(roleId.)
		
		return null;
	}*/

}
