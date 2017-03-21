package com.cloudwei.service;

import org.apache.commons.codec.binary.Base64;

import com.cloudwei.entity.User;
import com.cloudwei.repository.UserRepository;
import com.cloudwei.utils.SpringUtils;

public final class TokenHandler {

    public User parseUserFromToken(String token) {
        String s = new String(Base64.decodeBase64(token.getBytes()));
        String[] ss = s.split(":");
        String username = ss[1];
        UserRepository userRepository = SpringUtils.getBean(UserRepository.class);
        return userRepository.findByUserName(username);
    }

    public String createTokenForUser(User user) {
        String username = user.getUserName();
        String cid = user.getCid();
        String s = cid + ":" + username;
        byte[] ss = Base64.encodeBase64(s.getBytes());
        return new String(ss);
    }
}
