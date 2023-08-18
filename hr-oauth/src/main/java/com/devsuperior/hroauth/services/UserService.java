package com.devsuperior.hroauth.services;

import com.devsuperior.hroauth.feignclients.UserFeignClients;
import com.devsuperior.hroauth.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

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
}
