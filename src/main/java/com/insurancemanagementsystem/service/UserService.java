package com.insurancemanagementsystem.service;
import com.insurancemanagementsystem.model.User;
import java.util.List;
public interface UserService {

    User registerUser(User user) throws Exception;

    User loginUser(User user) throws Exception;

    User getUserById(int id) throws Exception;

    User updateUser(int id, User user) throws Exception;

    List<User> getAllUsers() throws Exception;

    List<User> getDependentsByPolicyOwnerId(int policyOwnerId) throws Exception;
    List<User> getUsersByRole(String role) throws Exception;

}
