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
                String policyHolderId = resultSet.getString("id");
                PolicyType policyType = PolicyType.valueOf(resultSet.getString("type"));
                Date startDate = resultSet.getDate("start_date");
                Date endDate = resultSet.getDate("end_date");
                double coverageAmount = resultSet.getDouble("coverage_amount");

                policy = new Policy(policyId, policyHolderId, policyType, startDate, endDate, coverageAmount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return policy;
    }

    @Override
    public void createPolicy(Policy policy) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO policies (policy_number, id, type, start_date, end_date, coverage_amount) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, policy.getPolicyId());
            statement.setString(2, policy.getPolicyHolderId());
            statement.setString(3, policy.getPolicyType().toString());
            statement.setDate(4, new java.sql.Date(policy.getStartDate().getTime()));
            statement.setDate(5, new java.sql.Date(policy.getEndDate().getTime()));
            statement.setDouble(6, policy.getCoverageAmount());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePolicy(Policy policy) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE policies SET id = ?, type = ?, start_date = ?, end_date = ?, coverage_amount = ? WHERE policy_number = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, policy.getPolicyHolderId());
            statement.setString(2, policy.getPolicyType().toString());
            statement.setDate(3, new java.sql.Date(policy.getStartDate().getTime()));
            statement.setDate(4, new java.sql.Date(policy.getEndDate().getTime()));
            statement.setDouble(5, policy.getCoverageAmount());
            statement.setString(6, policy.getPolicyId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePolicy(String policyId) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.setAutoCommit(false);

            // Delete dependent records from the 'insurancecards' table
            String deleteInsuranceCardsQuery = "DELETE FROM insurancecards WHERE policy_number = ?";
            try (PreparedStatement deleteInsuranceCardsStmt = connection.prepareStatement(deleteInsuranceCardsQuery)) {
                deleteInsuranceCardsStmt.setString(1, policyId);
                deleteInsuranceCardsStmt.executeUpdate();
            }

            // Delete dependent records from the 'dependents' table
            String deleteDependentsQuery = "DELETE FROM dependents WHERE policy_number = ?";
            try (PreparedStatement deleteDependentsStmt = connection.prepareStatement(deleteDependentsQuery)) {
                deleteDependentsStmt.setString(1, policyId);
                deleteDependentsStmt.executeUpdate();
            }

            // Delete dependent records from the 'claims' table
            String deleteClaimsQuery = "DELETE FROM claims WHERE policy_number = ?";
            try (PreparedStatement deleteClaimsStmt = connection.prepareStatement(deleteClaimsQuery)) {
                deleteClaimsStmt.setString(1, policyId);
                deleteClaimsStmt.executeUpdate();
            }

            // Now, delete the policy from the 'policies' table
            String deletePolicyQuery = "DELETE FROM policies WHERE policy_number = ?";
            try (PreparedStatement deletePolicyStmt = connection.prepareStatement(deletePolicyQuery)) {
                deletePolicyStmt.setString(1, policyId);
                deletePolicyStmt.executeUpdate();
            }

            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
