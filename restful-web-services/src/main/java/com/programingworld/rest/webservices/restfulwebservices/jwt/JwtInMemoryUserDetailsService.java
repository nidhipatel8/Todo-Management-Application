package com.programingworld.rest.webservices.restfulwebservices.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
    inMemoryUserList.add(new JwtUserDetails(1L, "jadubaby",
        "$2a$10$4FCWUAckCiux.5poL59eqe/B0KGGnfabuNnnnopUIyFOuCNYKOZzC", "ROLE_USER_2"));
//    inMemoryUserList.add(new JwtUserDetails(2L, "jadubaby1",
//            "$2a$10$4FCWUAckCiux.5poL59eqe/B0KGGnfabuNnnnopUIyFOuCNYKOZzC", "ROLE_USER_2"));
//  
    //$2a$10$4FCWUAckCiux.5poL59eqe/B0KGGnfabuNnnnopUIyFOuCNYKOZzC
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}


