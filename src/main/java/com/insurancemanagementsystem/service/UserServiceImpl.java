package com.insurancemanagementsystem.service;

import com.insurancemanagementsystem.model.Role;
import com.insurancemanagementsystem.model.User;
import com.insurancemanagementsystem.repository.UserRepository;
import com.insurancemanagementsystem.util.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User authenticateUser(String username, String password) throws Exception {
        User user = null;

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String userId = resultSet.getString("user_id");
                String fullName = resultSet.getString("full_name");
                String userEmail = resultSet.getString("user_email");
                String roleString = resultSet.getString("role");
                Role role = Role.valueOf(roleString);

                user = new User(userId, username, password, fullName, role, userEmail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }
}