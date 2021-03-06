package bdml.cache;

import bdml.services.exceptions.MisconfigurationException;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Base64;

public class Util {
    /**
     * Calculates the SHA-256 message digest of the given String.
     *
     * @param message string to digest
     * @return SHA-256 message digest in base64 representation.
     */
    public static String sha256(String message) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (GeneralSecurityException e) {
            throw new MisconfigurationException(e.getMessage());
        }
        byte[] messageBytes = message.getBytes();
        byte[] messageDigest = digest.digest(messageBytes);
        return Base64.getEncoder().encodeToString(messageDigest);
    }
}
