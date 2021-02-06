package com.zain.jo.webtoken.service;

import com.zain.jo.webtoken.domain.User;
import com.zain.jo.webtoken.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("tried to loging : " + username);
        if(!Objects.isNull(username) && !"".equals(username)){

            Optional<User> user = userRepository.findUserByUserName(username);

            System.out.println(user.get());
            if(user.isPresent()){

                User userParam = user.get();
                return new org.springframework.security.core.userdetails.User(userParam.getUserName(),
                        userParam.getPassword(), new ArrayList<>());
            }
        }
        throw new UsernameNotFoundException("user does not exists or empty !!");
    }
}
