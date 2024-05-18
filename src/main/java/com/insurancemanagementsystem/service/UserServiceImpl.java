package com.insurancemanagementsystem.service;

import com.insurancemanagementsystem.model.Role;
import com.insurancemanagementsystem.model.User;
import com.insurancemanagementsystem.util.DatabaseConnection;
import com.insurancemanagementsystem.util.PasswordHash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Override
    public Optional<User> getUserById(String id) {
        User user = null;

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("full_name");
                Role role = Role.valueOf(resultSet.getString("role"));
                String userEmail = resultSet.getString("email");

                user = new User(id, username, password, fullName, role, userEmail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM users";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("full_name");
                Role role = Role.valueOf(resultSet.getString("role"));
                String userEmail = resultSet.getString("email");

                users.add(new User(id, username, password, fullName, role, userEmail));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public void createUser(User user) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO users (username, password, full_name, role, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, PasswordHash.encode(user.getPassword()));
            statement.setString(3, user.getFullName());
            statement.setString(4, user.getRole().toString());
            statement.setString(5, user.getEmail());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User updateUser(User user) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE users SET username = ?, password = ?, full_name = ?, role = ?, email = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, PasswordHash.encode(user.getPassword()));
            statement.setString(3, user.getFullName());
            statement.setString(4, user.getRole().toString());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getUserId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void deleteUser(String id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Role authenticateUser(String username, String password) throws Exception {
        User user = getUserByUsername(username);

        if (user != null && PasswordHash.validate(password, user.getPassword())) {
            return user.getRole();
        }

        return null;    }

    @Override
    public User getUserByUsername(String username) {
        User user = null;

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("full_name");
                Role role = Role.valueOf(resultSet.getString("role"));
                String userEmail = resultSet.getString("email");

                user = new User(id, username, password, fullName, role, userEmail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}