package com.example.periodtracker;

import org.junit.Test;

import static org.junit.Assert.*;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import javax.crypto.SecretKey;

public class AESEncryptorTest {

    @Test
    public void key_length_isCorrect() {
        SecureRandom random = new SecureRandom();
        char[] password = {'t', 'e', 'a', 'm', '5'};
        byte[] salt = new byte[32];
        random.nextBytes(salt);

        SecretKey key = AESEncryptor.generateKey(password, salt);
        int length = key.getEncoded().length;

        // Key length should be 32 bytes long (256 bits).
        assertEquals(32, length);
    }

    @Test
    public void encryption_decryption_check_pass() {
        SecureRandom random = new SecureRandom();
        byte[] message = new byte[32];
        random.nextBytes(message);

        char[] password = {'t', 'e', 'a', 'm', '5'};
        byte[] salt = new byte[32];
        random.nextBytes(salt);

        SecretKey key = AESEncryptor.generateKey(password, salt);
        AESEncryptor aes = new AESEncryptor(key);

        byte[] encrypted = aes.Encrypt(message);
        byte[] decrypted = aes.Decrypt(encrypted);

        assertArrayEquals(decrypted, message);
    }

}
