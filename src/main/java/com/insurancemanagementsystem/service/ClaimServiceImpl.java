package com.insurancemanagementsystem.service;

import com.insurancemanagementsystem.model.*;
import com.insurancemanagementsystem.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.List;

public class ClaimServiceImpl implements ClaimService {

    @Override
    public Claim getClaimById(int claimId)  {
        String query = "SELECT * FROM claims WHERE claim_id = ?";

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, claimId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User policyHolder = getPolicyHolder(resultSet.getInt("policy_holder_id"));
                Policy policy = getPolicy(resultSet.getString("policy_number"));
                Date claimDate = resultSet.getDate("claim_date");
                String cardNumber = resultSet.getString("card_number");
                Date examDate = resultSet.getDate("exam_date");
                double claimAmount = resultSet.getDouble("claim_amount");
                ClaimStatus status = ClaimStatus.valueOf(resultSet.getString("claim_status"));
                String receiverBank = resultSet.getString("receiver_bank");
                String receiverName = resultSet.getString("receiver_name");
                String receiverNumber = resultSet.getString("receiver_number");

                return new Claim(claimId, claimDate, policyHolder, cardNumber, examDate, policy, claimAmount, status, receiverBank, receiverName, receiverNumber);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public static User getPolicyHolder(int policyHolderId) {
        String query = "SELECT * FROM users WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, policyHolderId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("full_name");
                String role = resultSet.getString("role");
                String userEmail = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");

                return new User(userId, username, password, fullName, Role.valueOf(role), userEmail, phoneNumber);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public static Policy getPolicy(String policyId) throws Exception {
        String query = "SELECT * FROM policies WHERE policy_number = ?";

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, policyId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String policyIdValue = resultSet.getString("policy_number");
                String policyHolderId = resultSet.getString("id");
                PolicyType policyType = PolicyType.valueOf(resultSet.getString("type").toUpperCase());
                Date startDate = resultSet.getDate("start_date");
                Date endDate = resultSet.getDate("end_date");

                return new Policy(policyIdValue, policyHolderId, policyType, startDate, endDate);
            }
        }

        return null;
    }
    @Override
    public void updateClaim(Claim claim) throws Exception {
        String query = "UPDATE claims SET policy_number = ?, policy_holder_id = ?, claim_date = ?, card_number = ?, exam_date = ?, claim_amount = ?, claim_status = ?, receiver_bank = ?, receiver_name = ?, receiver_number = ? WHERE claim_id = ?";

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, claim.getPolicyId().getPolicyId());
            statement.setInt(2, claim.getPolicyHolder().getUserId());
            statement.setDate(3, new Date(claim.getClaimDate().getTime()));
            statement.setString(4, claim.getCardNumber());
            statement.setDate(5, new Date(claim.getExamDate().getTime()));
            statement.setDouble(6, claim.getClaimAmount());
            statement.setString(7, claim.getStatus().toString());
            statement.setString(8, claim.getReceiverBank());
            statement.setString(9, claim.getReceiverName());
            statement.setString(10, claim.getReceiverNumber());
            statement.setInt(11, claim.getId());

            statement.executeUpdate();
        }
    }

    @Override
    public void createClaim(Claim claim) throws Exception{
        String query = "INSERT INTO claims (claim_id, policy_number, policy_holder_id, claim_date, card_number, exam_date, claim_amount, claim_status, receiver_bank, receiver_name, receiver_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, claim.getId());
            statement.setString(2, claim.getPolicyId().getPolicyId());
            statement.setInt(3, claim.getPolicyHolder().getUserId());
            statement.setDate(4, new Date(claim.getClaimDate().getTime()));
            statement.setString(5, claim.getCardNumber());
            statement.setDate(6, new Date(claim.getExamDate().getTime()));
            statement.setDouble(7, claim.getClaimAmount());
            statement.setString(8, claim.getStatus().toString());
            statement.setString(9, claim.getReceiverBank());
            statement.setString(10, claim.getReceiverName());
            statement.setString(11, claim.getReceiverNumber());

            statement.executeUpdate();
        }
    }
    @Override
    public void deleteClaim(int claimId) throws Exception {
        String query = "DELETE FROM claims WHERE claim_id = ?";

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, claimId);

            statement.executeUpdate();
        }
    }










    // Testing only
    @Override
    public List<Claim> getAssignedClaims() {
        return List.of();
    }

    @Override
    public List<Claim> getFilteredClaims(String filter) {
        return List.of();
    }

    @Override
    public void requestMoreInfo(int claimId) {

    }

    @Override
    public Claim proposeClaim(int claimId, Claim claim) {
        return null;
    }
}