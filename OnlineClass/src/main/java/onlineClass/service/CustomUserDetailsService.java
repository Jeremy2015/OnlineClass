package onlineClass.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import onlineClass.dao.DbUserDao;
import onlineClass.domain.DbUser;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

	private DbUserDao userDAO = new DbUserDao();
	public static boolean userNotFound = false;

	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {

		UserDetails user = null;
		try {

			userNotFound = false;
			DbUser dbUser = userDAO.getDatabase(username);

			user = new User(dbUser.getUser_id(), dbUser.getPassword(), true,
					true, true, true, getAuthorities());

		} catch (Exception e) {

			userNotFound = true;
			throw new UsernameNotFoundException("Error in retrieving user");
		}
		return user;
	}

	public Collection<GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

		authList.add(new GrantedAuthorityImpl("ROLE_USER"));
		return authList;
	}

}
