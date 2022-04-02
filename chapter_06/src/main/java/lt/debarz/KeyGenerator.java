package lt.debarz;

import org.bouncycastle.crypto.generators.SCrypt;

import java.security.SecureRandom;

import static java.nio.charset.StandardCharsets.UTF_16;
/**
 * They are
 * hard to implement correctly so you should never write your own—
 * Twootr uses an established Java library called Bouncy Castle. This is
 * open source and has undergone heavy peer review. Twootr uses the
 * Scrypt hashing function, which is a modern algorithm specifically
 * designed for storing passwords
 * */
public class KeyGenerator {
    private static final int SCRYPT_COST = 16384;
    private static final int SCRYPT_BLOCK_SIZE = 8;
    private static final int SCRYPT_PARALLELISM = 1;
    private static final int KEY_LENGTH = 20;

    private static final int SALT_LENGTH = 16;

    private static final SecureRandom secureRandom = new SecureRandom();

    static byte[] hash(final String password, final byte[] salt) {
        final byte[] passwordBytes = password.getBytes(UTF_16);
        return SCrypt.generate(
                passwordBytes,
                salt,
                SCRYPT_COST,
                SCRYPT_BLOCK_SIZE,
                SCRYPT_PARALLELISM,
                KEY_LENGTH);
    }

    static byte[] newSalt() {
        final byte[] salt = new byte[SALT_LENGTH];
        secureRandom.nextBytes(salt);
        return salt;
    }
}
