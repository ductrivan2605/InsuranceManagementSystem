package com.insurancemanagementsystem.model;
import java.util.Date;
import java.util.List;

public class Claim {
    //    A Claim contains id, claim date, insured person, card number, exam date, list of documents, claim amount, status and receiver banking info
    public String id;
    Date claimDate;
    String insuredPerson;
    String cardNumber;
    Date examDate;
    List<String> documents;
    double claimAmount;
    public String status;
    String receiverBank;
    String receiverName;
    String receiverNumber;

    public Claim(String id, Date claimDate, String insuredPerson, String cardNumber, Date examDate, List<String> documents, double claimAmount, String status, String receiverBank, String receiverName, String receiverNumber) {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.status = status;
        this.receiverBank = receiverBank;
        this.receiverName = receiverName;
        this.receiverNumber = receiverNumber;
    }
    //    Getter and Setter for Claims
    public String getId() {
        return id;
    }
    public java.sql.Date getClaimDate() {
        return (java.sql.Date) claimDate;
    }

    public String getInsuredPerson() {
        return insuredPerson;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public java.sql.Date getExamDate() {
        return (java.sql.Date) examDate;
    }

    public List<String> getDocuments() {
        return documents;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public String getStatus() {
        return status;
    }
    public String getReceiverBank() {
        return receiverBank;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getReceiverNumber() {
        return receiverNumber;
    }
    @Override
    public String toString() {
        return "ID: " + id + "\n" + "Claim Date: " + claimDate + "\n" + "Insured Person: " + insuredPerson + "\n" + "Card Number: " + cardNumber + "\n" + "Exam Date: " + examDate + "\n" + "Documents: " + documents + "\n" + "Claim Amount: " + claimAmount + "\n" + "Status: " + status + "\n" + "Receiver Bank: " + receiverBank + "\n" + "Receiver Name: " + receiverName + "\n" + "Receiver Number: " + receiverNumber;
    }
}