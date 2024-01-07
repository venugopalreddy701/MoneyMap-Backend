package com.venugopalreddy701.moneymap.service;

import com.venugopalreddy701.moneymap.constant.Messages;
import com.venugopalreddy701.moneymap.entity.LoginUser;
import com.venugopalreddy701.moneymap.entity.UpdateProfile;
import com.venugopalreddy701.moneymap.entity.User;
import com.venugopalreddy701.moneymap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    InputsChecking inputsChecking;

    @Autowired
    TokenUtility tokenUtility;

    public List<String> createUser(User user) {

        List<String> messages = inputsChecking.checkCreateUser(user);
        if (!messages.isEmpty()) {
            return messages;
        }

        userRepository.save(user);
        return Arrays.asList(Messages.SUCCESS);
    }

    public List<String> loginUser(LoginUser loginUser) {

        List<String> messages = inputsChecking.checkLoginUser(loginUser);
        if (!messages.isEmpty()) {
            return messages;
        }
        return Arrays.asList(tokenUtility.generateToken(loginUser.getEmail()));
    }

    public List<String> updateProfile(String token, UpdateProfile updateProfile) {

        if (token == null) {
            return Arrays.asList(Messages.EMPTY_TOKEN);
        }
        if (!tokenUtility.validateToken(token)) {
            return Arrays.asList(Messages.INVALID_TOKEN);
        }
        String userName = tokenUtility.extractUsername(token);

        List<String> messages = inputsChecking.checkUpdateProfile(updateProfile);
        if (!messages.isEmpty()) {
            return messages;
        }

        User user = userRepository.findByEmail(userName);
        user.setProfile(updateProfile.getProfile());

        userRepository.save(user);
        return Arrays.asList(Messages.SUCCESS);
    }

    public List<String> signout(String token) {

        tokenUtility.revokeToken(token);
        return Arrays.asList(Messages.SIGNOUT);
    }

    public Map<String, String> getUser(String token) {

        HashMap<String, String> map = new HashMap<>();
        if (token == null) {
            map.put("error", Messages.EMPTY_TOKEN);
            return map;
        }
        if (!tokenUtility.validateToken(token)) {
            map.put("error", Messages.INVALID_TOKEN);
            return map;
        }
        String userName = tokenUtility.extractUsername(token);
        User user= userRepository.findByEmail(userName);

        map.put("user_name", user.getEmail());
        map.put("profile", user.getProfile());
        return map;
    }
}
