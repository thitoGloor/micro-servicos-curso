package com.devsuperior.hroauth.services;

import com.devsuperior.hroauth.feignclients.UserFeignClients;
import com.devsuperior.hroauth.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserFeignClients userFeignClients;

    public User findByEmail(String email) {
        User user = userFeignClients.findByEmail(email).getBody();
        if (user == null) {
            logger.error("email not found" + email);
            throw new IllegalArgumentException("Email nao encontrado");
        }
        logger.info("Email: " + email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userFeignClients.findByEmail(userName).getBody();
        if (user == null) {
            //logger.error("email not found" + userName);
            throw new UsernameNotFoundException("Email nao encontrado");
        }
       // logger.info("Email: " + userName);
        return user;
    }
}
