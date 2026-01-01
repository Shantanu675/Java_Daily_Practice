import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHADigestExample {
    public static void main(String[] args) {
        String text = "Hello Shantanu!"; // your input text
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Compute the digest
            byte[] digest = md.digest(text.getBytes());

            // Convert byte array into hexadecimal format
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                hexString.append(String.format("%02x", b));
            }

            // Print the message digest
            System.out.println("Original text: " + text);
            System.out.println("SHA-256 Digest: " + hexString.toString());

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
