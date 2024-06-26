package com.insurancemanagementsystem.util;

import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordHash {

    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 512;

    /**
     * Hashes a plain text password using PBKDF2 with a random salt.
     *
     * @param password The plain text password to hash.
     * @return A String containing the hashed password and salt.
     * @throws Exception If any errors occur during hashing.
     */
    public static String hashPassword(String password) throws Exception {
        byte[] salt = generateSalt();
        byte[] hashedBytes = pbkdf2(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        return Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(hashedBytes);
    }

    /**
     * Generates a random salt using a secure random number generator.
     *
     * @return A byte array containing the random salt.
     * @throws Exception If any errors occur during salt generation.
     */
    private static byte[] generateSalt() throws Exception {
        SecureRandom random = SecureRandom.getInstanceStrong();
        byte[] salt = new byte[32];
        random.nextBytes(salt);
        return salt;
    }

    /**
     * Performs PBKDF2 hashing on the provided password and salt.
     *
     * @param password   The plain text password to hash.
     * @param salt       The random salt to use for hashing.
     * @param iterations The number of iterations for PBKDF2.
     * @param keyLength  The desired key length in bits.
     * @return A byte array containing the hashed password.
     * @throws Exception If any errors occur during hashing.
     */
    private static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int keyLength) throws Exception {
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
        return skf.generateSecret(spec).getEncoded();
    }

    /**
     * Verifies a hashed password against a plain text password.
     *
     * @param hashedPassword    The hashed password to verify.
     * @param candidatePassword The plain text password to compare.
     * @return True if the passwords match, false otherwise.
     * @throws Exception If any errors occur during verification.
     */
    public static boolean verifyPassword(String hashedPassword, String candidatePassword) throws Exception {
        String[] parts = hashedPassword.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid hashed password format.");
        }
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] hashedBytes = Base64.getDecoder().decode(parts[1]);
        byte[] testHashedBytes = pbkdf2(candidatePassword.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        return compareBytes(hashedBytes, testHashedBytes);
    }

    /**
     * Compares two byte arrays for equality.
     *
     * @param a The first byte array.
     * @param b The second byte array.
     * @return True if the byte arrays are equal, false otherwise.
     */
    private static boolean compareBytes(byte[] a, byte[] b) {
        int diff = a.length ^ b.length;
        for (int i = 0; i < a.length && i < b.length; i++) {
            diff |= (a[i] ^ b[i]);
        }
        return diff == 0;
    }

    /**
     * Encodes a plain text password using PBKDF2 with a random salt.
     *
     * @param password The plain text password to encode.
     * @return A String containing the encoded password and salt.
     * @throws Exception If any errors occur during encoding.
     */
    public static String encode(String password) throws Exception {
        return hashPassword(password);
    }

    /**
     * Validates a plain text password against a hashed password.
     *
     * @param plainTextPassword The plain text password to validate.
     * @param hashedPassword    The hashed password to compare against.
     * @return True if the passwords match, false otherwise.
     */
    public static boolean validate(String plainTextPassword, String hashedPassword) {
        try {
            return verifyPassword(hashedPassword, plainTextPassword);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
