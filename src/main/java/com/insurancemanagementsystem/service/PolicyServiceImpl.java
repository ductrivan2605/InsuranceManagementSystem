package com.insurancemanagementsystem.service;

import com.insurancemanagementsystem.model.Policy;
import com.insurancemanagementsystem.model.PolicyType;
import com.insurancemanagementsystem.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class PolicyServiceImpl implements PolicyService {
    @Override
    public Policy getPolicyById(String policyId) {
        Policy policy = null;

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM policies WHERE policy_number = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, policyId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String policyHolderId = resultSet.getString("user_id");
                PolicyType policyType = PolicyType.valueOf(resultSet.getString("type"));
                Date startDate = resultSet.getDate("start_date");
                Date endDate = resultSet.getDate("end_date");

                policy = new Policy(policyId, policyHolderId, policyType, startDate, endDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return policy;
    }

    @Override
    public void createPolicy(Policy policy) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO policies (policy_number, user_id, policy_type, start_date, end_date) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, policy.getPolicyId());
            statement.setString(2, policy.getPolicyHolderId());
            statement.setString(3, policy.getPolicyType().toString());
            statement.setDate(4, new java.sql.Date(policy.getStartDate().getTime()));
            statement.setDate(5, new java.sql.Date(policy.getEndDate().getTime()));
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePolicy(Policy policy) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE policies SET user_id = ?, policy_type = ?, start_date = ?, end_date = ? WHERE policy_number = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, policy.getPolicyHolderId());
            statement.setString(2, policy.getPolicyType().toString());
            statement.setDate(3, new java.sql.Date(policy.getStartDate().getTime()));
            statement.setDate(4, new java.sql.Date(policy.getEndDate().getTime()));
            statement.setString(5, policy.getPolicyId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePolicy(String policyId) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM policies WHERE policy_number = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, policyId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}